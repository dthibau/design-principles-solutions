package org.formation.pattern.chainofresponsability;

public class Main {

	public static void main(String[] args) {
		CommandChain chain = new CommandChain();

		CommandHandler handler = new CommandHandler(chain) ;
		CommandSender sender = new CommandSender();
		sender.setHandler(handler);
		
		sender.sendCommand("Une commande");

	}

}
