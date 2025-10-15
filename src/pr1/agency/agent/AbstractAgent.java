package pr1.agency.agent;

import java.util.ArrayList;

import pr1.agency.equipment.AbstractEquipment;
import pr1.agency.vehicle.AbstractVehicle;

public abstract class AbstractAgent {

	protected ArrayList<AbstractVehicle> vehicles = new ArrayList<>();
	protected ArrayList<AbstractEquipment> equipment = new ArrayList<>();
	protected AgentType agentType = AgentType.BEGINNER;

	/**
	 * Methode zum Ausführen von Aktionen, je nach Agent
	 */
	public abstract void doAction();

	/**
	 * Methode, die eine Bezeichnung, einen Namen oder Spitznamen zurückgibt
	 * 
	 * @return Name des Agenten
	 */
	public abstract String toString();

	/**
	 * Fahrzeug zur ArrayList hinzufügen.
	 * @param car Fahrzeug, das dem Agenten zugeordnet wird.
	 */
	public void addVehicle(AbstractVehicle car) {
	}

	/**
	 * Fahrzeug an bestimmter Position entfernen.
	 * @param index Position, an der ein Fahrzeug entfernt werden soll.
	 */
	public void removeVehicle(int index) {
	}

	/**
	 * Alle Fahrzeuge zurückgeben.
	 * @param index Position des Fahrzeugs.
	 * @return Fahrzeug
	 */
	public AbstractVehicle getVehicle(int index) {
		return null;
	}

	/**
	 * 
	 * @return Fahrzeugliste
	 */
	public ArrayList<AbstractVehicle> getVehicles() {
		return new ArrayList<>();
	}

	public void addEquipment(AbstractEquipment equipment) {
	}

	public void removeEquipment(int index) {
	}

	public void removeEquipment(AbstractEquipment equipment) {
	}

	public AbstractEquipment getEquipment(int index) {
		return null;
	}

	public ArrayList<AbstractEquipment> getEquipment() {
		return new ArrayList<>();
	}

	public AgentType getAgentType() {
		return agentType;
	}

}
