package es.upm.aled.parking;

public class Test {

	public static void main(String[] args) {
		Parking teleco = new Parking(5);
		for (int i = 0; i < 10; i++) {
			Car c = new Car(i, teleco);
			c.start();
		}

	}

}
