package pr1.agency.agent.entity;

import pr1.agency.agent.AbstractAgent;

public class Dog extends AbstractAgent {

	protected String nickname;

	public Dog(String nickname) {
		this.nickname = nickname;
	}

	// Die folgenden zwei Methoden müssen zwanghaft implementiert werden
	@Override
	public void doAction() {
		System.out.println("Wuff!");
	}

	@Override
	public String toString() {
		return this.nickname;
	}

	// Dog darf KEIN Autos fahren, also überschreiben wir auch nicht die leeren
	// Methoden der Oberklasse.

}
