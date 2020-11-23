package org.formation.pattern.cor;

public class ConcreteCommandHandler1 extends CommandHandler {

	@Override
	public boolean handleCommand(String commande) {
		System.out.println("First handler handles " + commande + " I will return false");
		return false;
	}

}
