package es.upm.aled.racecondition;

public class IncreaserGetSet extends Increaser {

	public IncreaserGetSet(Counter counter) {
		super(counter);
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			// START Región crítica
			synchronized (counter) {
				int count = counter.getCount();
				count++;
				counter.setCount(count);
			}
			// END Región crítica
		}
	}
}
