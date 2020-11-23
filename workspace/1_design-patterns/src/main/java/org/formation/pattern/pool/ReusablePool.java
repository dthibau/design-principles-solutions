package org.formation.pattern.pool;

public class ReusablePool {

	private static ReusablePool instance;
	
	private int maxPoolSize = 10;
	
	private Reusable[] pool;
	private boolean inUse[];
	
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
		
		for ( int i=0; i< inUse.length; i++) {
			if ( !inUse[i] ) {
				inUse[i] = true;
				return pool[i];
			}
		}
		throw REUSABLE_EXCEPTION;
		
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	
	public synchronized void releaseReusable(Reusable reusable) {
		for ( int i=0; i<pool.length; i++) {
			if ( pool[i].equals(reusable) ) {
				reusable.clear();
				inUse[i] = false;
			}
		}
	}

	/**
	 * Has side effect to initialize the pool.
	 * @param maxPoolSize
	 */
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
		
		pool = new Reusable[maxPoolSize];
		inUse = new boolean[maxPoolSize];
		for ( int i=0 ; i<maxPoolSize; i++) {
			pool[i] = new Reusable();
			inUse[i] = false;
		}
	}
	
	
}
