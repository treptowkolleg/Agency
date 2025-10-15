package pr1.agency;

import java.util.ArrayList;

import pr1.agency.core.DecToBin;
import pr1.agency.core.ExampleInterface;
import pr1.agency.core.UniversalBaseConverter;

public class Agency {

	public static ArrayList<ExampleInterface> examples = new ArrayList<>();

	public static void main(String[] args) {

		// Beispiele sammeln
		// examples.add(new Example1());
		examples.add(new DecToBin());
		examples.add(new UniversalBaseConverter());

		// Beispiele der Reihe nach durchgehen
		for (ExampleInterface example : examples) {
			example.prepare().run();
		}

	}

}
