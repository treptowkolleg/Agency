package pr1.agency.agent;

public enum AgentType {

	BEGINNER("Agent für einfache Aufträge"), INTERMEDIATE("Agent für mittlere Aufträge"),
	EXPERT("Agent für schwierige Aufträge");

	private final String label;

	AgentType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	@Override
	public String toString() {
		return this.getLabel();
	}

}
