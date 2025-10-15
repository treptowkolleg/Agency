package pr1.agency.agent;

import java.util.ArrayList;

import pr1.agency.agent.entity.Human;
import pr1.agency.equipment.AbstractEquipment;
import pr1.agency.vehicle.AbstractVehicle;

public class HumanAgentBuilder {

	private String firstname = null;
	private String lastname = null;
	private ArrayList<AbstractEquipment> equipmentList = new ArrayList<>();
	private ArrayList<AbstractVehicle> vehicleList = new ArrayList<>();
	private AgentType agentType = AgentType.BEGINNER;

	public HumanAgentBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public HumanAgentBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public HumanAgentBuilder addEquipment(AbstractEquipment equipment) {
		this.equipmentList.add(equipment);
		return this;
	}

	public HumanAgentBuilder setEquipmentList(ArrayList<AbstractEquipment> equipmentList) {
		this.equipmentList = equipmentList;
		return this;
	}

	public HumanAgentBuilder addVehicle(AbstractVehicle vehicle) {
		this.vehicleList.add(vehicle);
		return this;
	}

	public HumanAgentBuilder setVehicleList(ArrayList<AbstractVehicle> vehicleList) {
		this.vehicleList = vehicleList;
		return this;
	}

	public HumanAgentBuilder setAgentType(AgentType type) {
		this.agentType = type;
		return this;
	}

	public Human create() {
		return new Human(firstname, lastname, vehicleList, equipmentList, agentType);
	}

}
