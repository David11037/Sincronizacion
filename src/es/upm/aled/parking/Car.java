package es.upm.aled.parking;

import java.time.LocalDateTime;
import java.util.Random;

public class Car extends Thread {

	private int plate;
	private Parking parking;

	public Car(int plate, Parking parking) {
		this.plate = plate;
		this.parking = parking;
	}

	public void run() {
		try {
			parking.enter(plate);
			Random rand = new Random(LocalDateTime.now().getNano());
			sleep(rand.nextInt(0, 999));
			parking.exit(plate);
		} catch (InterruptedException e) {

			System.out.println("Thread interrupted");
		}
	}
}
