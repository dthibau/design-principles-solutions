package org.formation.pattern.cor;

public abstract class CommandHandler {

	private CommandHandler successor;
	
	public abstract boolean handleCommand(String commande);
	
	public void postCommand(CommandChain chain, String commande) {
		if ( handleCommand(commande) ) {
			return;
		} else {
			successor.postCommand(chain, commande);
		}
	}

	public void setSuccessor(CommandHandler successor) {
		this.successor = successor;
	}
	
	
}
