package pr1.agency.helper;

import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	private static Scanner scanner = new Scanner(System.in);

	private static PrintWriter writer = new PrintWriter(System.out);

	public static String colorize(String text, TextColor textColor) {
		return colorize(text, textColor, BackgroundColor.NONE);
	}

	public static String colorize(String text, TextColor textColor, BackgroundColor bgColor) {
		return String.format("%s%s%s%s", setColor(textColor), setColor(bgColor), text, setColor(TextColor.DEFAULT));
	}

	public static void print(String text) {
		print(text, TextColor.DEFAULT);
	}

	public static void print(String text, TextColor textColor) {
		print(text, textColor, BackgroundColor.NONE);
	}

	public static void print(String text, TextColor textColor, BackgroundColor bgColor) {
		System.out.printf("%s%s%s%s", setColor(textColor), setColor(bgColor), text, setColor(TextColor.DEFAULT));
	}

	public static void println(String text) {
		println(text, TextColor.DEFAULT);
	}

	public static void println(String text, TextColor textColor) {
		println(text, textColor, BackgroundColor.NONE);
	}

	public static void println(String text, TextColor textColor, BackgroundColor bgColor) {
		System.out.printf("%s%s%s%s%n", setColor(textColor), setColor(bgColor), text, setColor(TextColor.DEFAULT));
	}

	public static void clear() {
		// funktioniert nicht zuverlässig unter Windows
		System.out.print("\u001B[2J\u001B[1;1H");
	}

	public static String readln() {
		return readln("Eingabe:");
	}

	public static String readln(String helpText) {
		IO.print(helpText + " ", TextColor.BLUE);
		return scanner.nextLine();
	}

	public static void collectText(String text) {
		writer.println(text);
	}

	public static void flushText() {
		writer.flush();
	}

	private static String setColor(TextColor textColor) {
		return setColor(textColor.getCode());
	}

	private static String setColor(BackgroundColor bgColor) {
		return setColor(bgColor.getCode());
	}

	private static String setColor(String textColor) {
		return "\u001B[" + textColor + "m";
	}

}
