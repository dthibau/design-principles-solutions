package org.formation.pattern.chainofresponsability;

public abstract class CommandHandler {

	
	protected abstract boolean handleCommand(String commande);
	
	public void postCommand(CommandChain chain, String commande) {
		if ( handleCommand(commande) ) {
			return;
		} else {
			chain.getNext().postCommand(chain, commande);
		}
	}
	

}
