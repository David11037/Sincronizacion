package es.upm.aled.buffer;


//Al usar la clase, se puede elegir el tipo de objetos sobre los que trabaja
public class Buffer<Tipo> {
	
	private Tipo dato;
	
	public synchronized void store(int id, Tipo dato) {
		//Si el buffer está vacío
		try {
			while (this.dato != null) {
				System.out.println("Productor " + id + " está esperando.");
				wait();
			}
			this.dato = dato;
			System.out.println("Productor " + id + " ha producido el dato " + dato);
			notifyAll();
		}catch(InterruptedException e) {
			
		}
		
	}
	
	public synchronized Tipo retrieve(int id) {
		//Si el buffer está lleno
		Tipo aDevolver = null;
		try {
			while (this.dato == null) {
				System.out.println("Consumidor " + id + " está esperando.");
				wait();
			}
			aDevolver = dato;
			dato = null;
			System.out.println("Consumidor " + id + " ha sacado el dato " + aDevolver);
			notifyAll();
		}catch (InterruptedException e) {}
		return aDevolver;
	}
}
