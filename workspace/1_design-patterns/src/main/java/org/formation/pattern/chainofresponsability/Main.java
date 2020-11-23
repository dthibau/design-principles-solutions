package org.formation.pattern.chainofresponsability;

public class Main {

	public static void main(String[] args) {
		CommandChain chain = new CommandChain();
		
		CommandSender sender = new CommandSender();
		sender.setChain(chain);
//		sender.setEndPoint(chain.getFirst());
		
		sender.sendCommand("Une commande");

	}

}
