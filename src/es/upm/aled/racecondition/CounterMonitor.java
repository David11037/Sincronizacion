package es.upm.aled.racecondition;

//Esta clase es Thread-safe (puede ser utilizada por distintos Threads)
public class CounterMonitor extends Counter {

	@Override
	public synchronized int getCount() {
		return count;
	}

	@Override
	public synchronized void setCount(int count) {
		this.count = count;
	}

	// Cuando alguien empieza a utilizar este método, bloquea el acceso para
	// cualquier otro
	@Override
	public synchronized void increase() {
		count++;
	}
}
