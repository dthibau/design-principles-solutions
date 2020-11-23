package org.formation.pattern.cor;

public class CommandSender {

	CommandChain chain;
	
	
	public CommandChain getChain() {
		return chain;
	}


	public void setChain(CommandChain chain) {
		this.chain = chain;
	}


	public void sendCommand(String commande) {
		chain.getFirst().postCommand(chain,commande);
	}
}
