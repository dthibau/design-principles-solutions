package org.formation.pattern.chainofresponsability;

public interface Receiver {

	public boolean handleCommand(String commande);
}
