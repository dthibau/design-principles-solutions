package org.formation.pattern.cor;

public class ConcreteCommandHandler2 extends CommandHandler {

	@Override
	public boolean handleCommand(String commande) {
		System.out.println("Second handler handles " + commande + " I will return true");
		return true;
	}

}
