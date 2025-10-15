package pr1.agency.core;

import java.util.ArrayList;

import pr1.agency.agent.AbstractAgent;
import pr1.agency.agent.AgentType;
import pr1.agency.agent.HumanAgentBuilder;
import pr1.agency.agent.entity.Human;

/**
 * Dieses Beispiel zeigt die Nutzung vom Builder-Design Pattern.
 */
public class Example1 implements ExampleInterface {
	private ArrayList<AbstractAgent> agents = new ArrayList<>();
	private HumanAgentBuilder humanBuilder = new HumanAgentBuilder();

	public ExampleInterface prepare() {
		Human bond = humanBuilder.setFirstname("James").setLastname("Bond").setAgentType(AgentType.EXPERT).create();

		this.agents.add(bond);
		return this;
	}

	public void run() {
		System.out.println("Beispiel 1");

		for (AbstractAgent agent : agents) {
			System.out.printf("%s, %s%n", agent, agent.getAgentType());
		}
	}

}
