package pr1.agency.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import pr1.agency.helper.BackgroundColor;
import pr1.agency.helper.IO;
import pr1.agency.helper.TextColor;

public class DecToBin implements ExampleInterface {

	private Scanner scanner = new Scanner(System.in);
	private String input;
	private StringBuilder binaryInteger = new StringBuilder();
	private int integer = 0;
	private ArrayList<String> exitHooks = new ArrayList<>();
	private ArrayList<String> methodNames = new ArrayList<>();

	@Override
	public ExampleInterface prepare() {
		this.exitHooks.add("ende");
		this.exitHooks.add("exit");

		this.methodNames.add("convertIntToBin");
		this.methodNames.add("convertBinToInt");
		this.methodNames.add("convertIntToSignedBin8");
		return this;
	}

	@Override
	public void run() {

		int methodNamesIndex;
		String selectedMethodName;

		IO.println("Start der Übung.\n", TextColor.WHITE, BackgroundColor.RED);

		int i = 0;
		for (String methodName : this.methodNames) {
			System.out.printf("%d:\t %s%n", i, methodName);
			i++;
		}

		while (true) {
			System.out.print("Funktion wählen (Siehe Nummern): ");

			try {
				methodNamesIndex = Integer.parseInt(this.scanner.nextLine().replaceAll("[^0-9]", ""));
				selectedMethodName = this.methodNames.get(methodNamesIndex);
				break;
			} catch (IndexOutOfBoundsException ignore) {
				System.err.println("Diese Funktionsnummer ist nicht vorhanden.");
			} catch (NumberFormatException ignore) {
				System.err.println("Die Eingabe enthält keine Ziffer.");
			}

		}

		// Ab hier in eigene Methode überführen.
		try {
			Class<?>[] parameterTypes = { String.class };
			Method selectedMethod = this.getClass().getDeclaredMethod(selectedMethodName, parameterTypes);
			String result;

			while (true) {
				System.out.print("\nBitte eine Zahl angeben: ");
				this.input = this.scanner.nextLine();
				if (this.exitHooks.contains(this.input.toLowerCase()))
					break;
				result = (String) selectedMethod.invoke(this, this.input);
				IO.print(result);
			}

		// Sollte auf jeden Fall überarbeitet werden.
		} catch (NoSuchMethodException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (SecurityException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (InvocationTargetException e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			IO.println("\nEnde der Übung.", TextColor.WHITE, BackgroundColor.RED);
			this.scanner.close();
		}

	}

	/**
	 * Dezimalzahlen in Binärzahlen umwandeln und ausgeben.
	 * 
	 * @param input Unsaubere Zeichenkette.
	 * @return
	 */
	private String convertIntToBin(String input) {
		this.binaryInteger.setLength(0);
		try {

			// Zahlen von 0 bis 9 erlauben.
			if (!input.matches("[0-9]+"))
				throw new NumberFormatException("Nur positive ganze Zahlen erlaubt!");

			int x = Integer.parseInt(input);
			int sx = x;

			// Wenn x == 0, dann überspringen wir die Schleife und setzen direkt 0.
			if (x == 0)
				this.binaryInteger.append(x);

			/*
			 * Idee: Zahl solange durch 2 teilen, bis 1 übrig bleibt. Jedes Mal den Rest
			 * einem String anfügen. Am Ende den String umkehren, da wir von rechts nach
			 * links notieren müssen.
			 */
			while (x >= 1) {
				this.binaryInteger.append(x % 2);
				x = (x / 2);
			}

			return String.format("Die Dezimalzahl %s entspricht der Binärzahl %s.%n",
					IO.colorize(String.valueOf(sx), TextColor.RED), IO.colorize(this.binaryInteger.reverse().toString(), TextColor.RED));

		} catch (NumberFormatException e) {
			return String.format("Deine Eingabe enthält keine gültige ganze Zahl.\n");
		}

	}

	/**
	 * 
	 * @param input
	 * @return
	 */
	private String convertIntToSignedBin8(String input) {
		this.binaryInteger.setLength(0);
		boolean isNegative = false;
		try {

			// Zahlen von 0 bis 9 erlauben.
			if (!input.matches("-?\\d+"))
				throw new NumberFormatException("Nur ganze Zahlen erlaubt!");

			int x = Integer.parseInt(input);

			if (x < -127 || x > 127)
				throw new NumberFormatException("Nur ganze Zahlen erlaubt!");
			int sx = x;

			if (x < 0) {
				isNegative = true;
				x = -x;
			}

			// Wenn x == 0, dann überspringen wir die Schleife und setzen direkt 0.
			if (x == 0)
				this.binaryInteger.append(x);

			/*
			 * Idee: Zahl solange durch 2 teilen, bis 1 übrig bleibt. Jedes Mal den Rest
			 * einem String anfügen. Am Ende den String umkehren, da wir von rechts nach
			 * links notieren müssen.
			 */
			while (x >= 1) {
				this.binaryInteger.append(x % 2);
				x = (x / 2);
			}

			while (this.binaryInteger.length() < 7) {
				this.binaryInteger.append(0);
			}

			// Binärzahl invertieren, wenn negativ.
			if (isNegative) {
				StringBuilder invertedBinaryInteger = new StringBuilder();
				for (char c : this.binaryInteger.toString().toCharArray())
					invertedBinaryInteger.append(c == '0' ? '1' : '0');
				this.binaryInteger = invertedBinaryInteger;

			}
			this.binaryInteger.append(isNegative ? 1 : 0);

			String result = this.binaryInteger.reverse().toString();

			return String.format("Die Dezimalzahl %s entspricht der 8-Bit-Einerkomplement-Binärzahl %s %s.%n",
					IO.colorize(String.valueOf(sx), TextColor.RED), IO.colorize(result.substring(0, 4), TextColor.RED),
					IO.colorize(result.substring(4), TextColor.RED));

		} catch (NumberFormatException e) {
			return String.format("Deine Eingabe enthält keine gültige ganze Zahl.\n");
		}
	}

	/**
	 * Binärzahlen in Dezimalzahlen umwandeln und ausgeben.
	 * 
	 * @param input Unsaubere Zeichenkette.
	 */
	private String convertBinToInt(String input) {
		this.integer = 0;
		int i = 0;
		try {

			if (!input.matches("[01]+"))
				throw new IllegalArgumentException("Nur 0 und 1 erlaubt!");

			// 0 und 1 extrahieren.
			String x = input;

			// Prüfung abbrechen, wenn keine 0 oder 1 enthalten ist.
			if (x.length() == 0)
				throw new NullPointerException();

			// Durchlauf nur, wenn Eingabe nicht 0 ist.
			if (!x.equals("0")) {
				i = x.length();
				for (char c : x.toCharArray()) {
					i--;
					this.integer += (int) (Integer.parseInt(String.valueOf(c)) * Math.pow(2, i));
				}
			}

			return String.format("Die Binärzahl %s entspricht der Dezimalzahl %s.%n", IO.colorize(x, TextColor.RED), IO.colorize(String.valueOf(this.integer), TextColor.RED));

		} catch (NullPointerException ignore) {
			return String.format("Deine Eingabe enthält keine gültige Binärzahl.%n");
		} catch (IllegalArgumentException e) {
			return String.format("%s%n", e.getMessage());
		}
	}

}
