package es.upm.aled.racecondition;

public class Increaser extends Thread {

	protected Counter counter;

	public Increaser(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		for (int i = 0; i < 1000000; i++) {
			counter.increase();
		}
	}

}
