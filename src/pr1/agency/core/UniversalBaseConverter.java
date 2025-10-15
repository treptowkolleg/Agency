package pr1.agency.core;

/**
 * Diese Klasse soll Methoden erhalten, um eine Zahl eines beliebigen
 * Zahlensystems in ein anderes Zahlensystem zu konvertieren. Z. B. von Dezimal
 * nach Binär oder von Oktal nach Hexa-Dezimal.
 */
public class UniversalBaseConverter implements ExampleInterface {

	@Override
	public ExampleInterface prepare() {
		
		return this;
	}

	@Override
	public void run() {
		
	}
	
	/**
	 * Konvertiert eine beliebige Zahl in ein anderes Zahlensystem.
	 * @param number zu konvertierende Zahl
	 * @param fromBase Ausgangszahlenraum
	 * @param toBase Zielzahlenraum
	 * @return Ergebnis
	 */
	private String convert(String number, NumeralSystem sourceBase, NumeralSystem targetBase) {
		// code implementieren
		
		return "";
	}
	

}
