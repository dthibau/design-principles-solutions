package org.formation.pattern.chainofresponsability;

public class ConcreteCommandHandler2 implements Receiver {


	public boolean handleCommand(String commande) {
		System.out.println("Second handler handles " + commande + " I will return true");
		return true;
	}

}
