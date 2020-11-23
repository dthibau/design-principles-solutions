package org.formation.pattern.chainofresponsability;

public class CommandHandler {

	private final CommandChain commandChain;
	
	public CommandHandler(CommandChain commandChain) {
		this.commandChain = commandChain;
	}
	
	
	public void sendCommand(String commande) {
		Receiver handler = commandChain.getNext();
		
		while ( !handler.handleCommand(commande) ) {
			handler = commandChain.getNext();
			if ( handler == null ) {
				break;
			}
		}
		
	}

}
