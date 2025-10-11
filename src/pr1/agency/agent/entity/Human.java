package pr1.agency.agent.entity;

import java.util.ArrayList;

import pr1.agency.agent.AbstractAgent;
import pr1.agency.agent.AgentType;
import pr1.agency.equipment.AbstractEquipment;
import pr1.agency.vehicle.AbstractVehicle;

public class Human extends AbstractAgent {

	protected String firstname;
	protected String lastname;

	public Human(String firstname, String lastname, ArrayList<AbstractVehicle> vehicles,
			ArrayList<AbstractEquipment> equipment, AgentType agentType) {
		this.firstname = firstname;
		this.lastname = lastname;
		super.vehicles = vehicles;
		super.equipment = equipment;
		super.agentType = agentType;
	}

	// Die folgenden zwei Methoden müssen zwanghaft implementiert werden
	@Override
	public void doAction() {
		System.out.println("Ich bin ein Mensch und kann reden, fahren und Gegenstände benutzen.");
	}

	@Override
	public String toString() {
		return this.firstname + " " + this.lastname;
	}

	// Human darf Autos fahren, also implementieren wir den Code dafür
	@Override
	public void addVehicle(AbstractVehicle car) {
		this.vehicles.add(car);
	}

	@Override
	public void removeVehicle(int index) {
		try {
			this.vehicles.remove(index);
		} catch (IndexOutOfBoundsException ignored) {

		}

	}

	@Override
	public AbstractVehicle getVehicle(int index) {
		try {
			return this.vehicles.get(index);
		} catch (IndexOutOfBoundsException exception) {
			return null;
		}
	}

	@Override
	public ArrayList<AbstractVehicle> getVehicles() {
		return this.vehicles;
	}

	@Override
	public void addEquipment(AbstractEquipment equipment) {
		this.equipment.add(equipment);
	}

	@Override
	public void removeEquipment(int index) {
		try {
			this.equipment.remove(index);
		} catch (IndexOutOfBoundsException ignored) {

		}

	}

	@Override
	public AbstractEquipment getEquipment(int index) {
		try {
			return this.equipment.get(index);
		} catch (IndexOutOfBoundsException exception) {
			return null;
		}
	}

	@Override
	public ArrayList<AbstractEquipment> getEquipment() {
		return this.equipment;
	}

}
