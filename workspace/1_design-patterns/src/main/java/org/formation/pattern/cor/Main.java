package org.formation.pattern.cor;

public class Main {

	public static void main(String[] args) {
		CommandChain chain = new CommandChain();
		
		CommandSender sender = new CommandSender();
		sender.setChain(chain);
		
		sender.sendCommand("Une commande");

	}

}
