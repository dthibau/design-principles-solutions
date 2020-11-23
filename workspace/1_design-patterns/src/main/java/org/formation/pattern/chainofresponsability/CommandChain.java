package org.formation.pattern.chainofresponsability;

import java.util.LinkedList;
import java.util.List;

public class CommandChain {

	private List<Receiver> chain = new LinkedList<Receiver>();
	private int i=-1;
	
	public CommandChain() {
		chain.add(new ConcreteCommandHandler1());
		chain.add(new ConcreteCommandHandler2());
		chain.add(new ConcreteCommandHandler1());
	}

	
	public Receiver getNext() {
		i++;
		if ( i< chain.size() ) {
			return chain.get(i);
		}
		return null;
		
	}
}
