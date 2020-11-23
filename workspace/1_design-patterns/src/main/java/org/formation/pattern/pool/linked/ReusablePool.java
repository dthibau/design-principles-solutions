package org.formation.pattern.pool.linked;

import java.util.LinkedList;
import java.util.List;

public class ReusablePool {

	private static ReusablePool instance;
	
	private int maxPoolSize = 10;
	
	private List<Reusable> inUse = new LinkedList<>();
	private List<Reusable> available = new LinkedList<>();
	
	private NoMoreObjectAvailableException REUSABLE_EXCEPTION = new NoMoreObjectAvailableException(); 
	
	private ReusablePool() {
	}

	public static ReusablePool getInstance() {
		if ( instance == null ) {
			instance = new ReusablePool();
		}
		return instance;
	}
	
	public synchronized Reusable getReusable() throws NoMoreObjectAvailableException {
		
		Reusable ret;
		if ( available.isEmpty() ) {
			if ( inUse.size() == maxPoolSize ) {
				throw REUSABLE_EXCEPTION;
			} else {
				ret = new Reusable();
				inUse.add(ret);
			}		
		} else {
			ret = available.get(0);
			available.remove(0);
			inUse.add(ret);
		}
		return ret;
		
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	
	public synchronized void releaseReusable(Reusable reusable) {
		inUse.remove(reusable);
		reusable.clear();
		available.add(reusable);
	}

	/**
	 * Has side effect to initialize the pool.
	 * @param maxPoolSize
	 */
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
		
	}
	
	
}
