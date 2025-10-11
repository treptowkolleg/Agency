package pr1.agency.equipment;

public abstract class AbstractEquipment {

	protected String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public abstract String toString();

}
