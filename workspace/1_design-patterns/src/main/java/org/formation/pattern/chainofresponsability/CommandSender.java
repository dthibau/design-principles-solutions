package org.formation.pattern.chainofresponsability;

public class CommandSender {

	CommandHandler handler;

	public CommandHandler getHandler() {
		return handler;
	}


	public void setHandler(CommandHandler handler) {
		this.handler = handler;
	}


	public void sendCommand(String commande) {
		// I'd like to send my commande to all the handlers in the chain without knowing them
		handler.sendCommand(commande);
	}
}
