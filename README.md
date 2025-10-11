# Agency

Diese Übung demonstriert die Anwendung verschiedener Design Patterns.

## Template

Die abstrakten Oberklassen ``AbstractAgent``, ``AbstractEquipment`` und ``AbstractVehicle`` stellen für die spezialisierten Unterklassen
Methoden bereit, die:

- implementiert werden müssen (abstrakte Methoden) und
- implementiert werden können ("leere" Methoden).

In diesem Beispiel gibt es menschliche Agenten und Hunde. Menschen können Fahrzeuge und Ausrüstung führen, Hunde jedoch nicht.
Dennoch kennt die ``Dog``-Klasse dieselben Methoden wie ``Human``, diese sind jedoch nicht implementiert.

``Dog`` und ``Human`` sind zudem **polymorph**, das bedeutet, dass Hunde den Datentyp ``Dog``, aber auch den Datentyp ``AbstractAgent`` annehmen können. Das gleiche
gilt entsprechend für ``Human``. Je nach Perspektive

## Builder

Builder helfen uns, Objekte einfacher zusammenzustellen, indem die Builder-Methoden genutzt werden. Dies ist zwar aufwendiger, hat aber deutliche semantische Vorteile gegenüber der
manuellen Erzeugung von Objekten mittels Konstruktoren.

````java
// ohne Builder
Human agent01 = new Agent("James", "Bond", null, null, AgentType.EXPERT);

// mit Builder
HumanBuilder builder = new HumanBuilder();
Human agent01 = builder.setFirstname("James").setLastname("Bond").setAgentType(AgentType.EXPERT).create();
````

## Director

Ein Director enthält Methoden mit vorgefertigten Builder-Anweisungen, um unkompliziert Standardkonfigurationen zu erzeugen.

````java
ArrayList<AbstractAgent> agents = new ArrayList<>();

Human jamesBond = AgentDirector.createJamesBond();
Dog rex = AgentDirector.createRex();

// 'jamesBond' und 'rex' sind ebenfalls auch vom Datentyp 'AbstractAgent', daher können wir sie zur ArrayList hinzufügen.
agents.add(jamesBond);
agents.add(rex);

// Für jeden registrierten Agenten alle Fahrzeuge und deren Typen ausgeben.
for (AbstractAgent agent : agents)
	for (AbstractVehicle vehicle : agent.getVehicles()) {
		System.out.printf("%s: %s %n",vehicle.getVehicleType(),vehicle);
	}
}
````

