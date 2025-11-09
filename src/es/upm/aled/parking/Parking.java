package es.upm.aled.parking;

public class Parking {

	private final int capacity;
	private int cars;

	public Parking(int capacity) {
		this.capacity = capacity;
		this.cars = 0;
	}

	public synchronized void enter(int plate) {
		// Si cars < capacidad le dejo pasar
		// Si no, a esperar
		// Una vez entre, aumentar en uno
		try {
			while (cars >= capacity) {
				System.out.println("Car " + plate + " is waiting to enter");
				wait();
			}
			cars++;
			System.out.println("Car " + plate + " has managed to enter");
		} catch (InterruptedException e) {
			System.out.println("Threas interrupted");
		}

		//
	}

	public synchronized void exit(int plate) {
		// Reducir cars en uno
		cars--;
		System.out.println("Car " + plate + " has exit");
		notify(); // Despierta a un coche que esté esperando al azar
		//
	}
}
