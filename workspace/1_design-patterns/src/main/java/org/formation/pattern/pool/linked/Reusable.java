package org.formation.pattern.pool.linked;

public class Reusable {

	private long myAttribute=0l;
	
	public Reusable() {
		// Instantiation is long
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			 // Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
	}
	public void clear() {
		// Clear attributes as i was new
		myAttribute=0l;
	}
	
	public long callMethod() {
		// Call method is a little long
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			 // Restore interrupted state...
		    Thread.currentThread().interrupt();
		}
		
		myAttribute += System.currentTimeMillis();
		return myAttribute;
	}


	
	
}
