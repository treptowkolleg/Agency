package pr1.agency.vehicle;

import java.util.ArrayList;

import pr1.agency.agent.AbstractAgent;
import pr1.agency.equipment.AbstractEquipment;

public abstract class AbstractVehicle {

	private final VehicleType vehicleType;
	protected Boolean isStarted = false;
	protected boolean hasEngine;
	protected Double fuel = 0.0;
	private Integer seats = 1;
	private AbstractAgent driver;
	private ArrayList<AbstractAgent> passengers = new ArrayList<>(seats);
	protected ArrayList<AbstractEquipment> equipment = new ArrayList<>();

	public AbstractVehicle(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public abstract String toString();

	public VehicleType getVehicleType() {
		return this.vehicleType;
	}

	public Boolean isStarted() {
		return false;
	}

	public void setStarted(boolean started) {
	}

	public boolean hasEngine() {
		return this.hasEngine;
	}

	public void setHasEngine(boolean hasEngine) {
		this.hasEngine = hasEngine;
	}

	public Double getFuel() {
		return null;
	}

	public void setFuel(double fuel) {
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.passengers = new ArrayList<>(seats - 1);
		this.seats = seats;
	}

	public AbstractAgent getDriver() {
		return driver;
	}

	public void setDriver(AbstractAgent driver) {
		this.driver = driver;
	}

	public ArrayList<AbstractAgent> getPassengers() {
		return this.passengers;
	}

	public AbstractAgent getPassenger(int index) {
		try {
			return this.passengers.get(index);
		} catch (IndexOutOfBoundsException exception) {
			System.out.println("Sitzplatz existiert nicht.");
			return null;
		}
	}

	public void setPassengers(ArrayList<AbstractAgent> passengers) {
		this.passengers = passengers;
	}

	public void addPassenger(AbstractAgent passenger) {
		if (this.passengers.size() < this.seats - 1) {
			this.passengers.add(passenger);
		}
	}

	public void setPassenger(int index, AbstractAgent passenger) {
		try {
			this.passengers.set(index, passenger);
		} catch (IndexOutOfBoundsException exception) {
			System.out.println("Sitzplatz existiert nicht!");
		}
	}

	public void removePassenger(int index) {
		try {
			this.passengers.remove(index);
		} catch (IndexOutOfBoundsException exception) {
			System.out.println("Sitzplatz existiert nicht!");
		}
	}

	public void removePassenger(AbstractAgent passenger) {
		this.passengers.remove(passenger);
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

}
