public class Counter {
	private int count = 0;
	private final Object lock = new Object();

	public synchronized void increment() {
			count++;

	}

	public int getCount() {
		return count;
	}

}
