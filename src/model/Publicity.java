package model;

public class Publicity {
	
	private String ruta;
	
	private Publicity previous;
	
	private Publicity next;
	
	public Publicity(String pRuta) {
		
		ruta=pRuta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Publicity getPrevious() {
		return previous;
	}

	public void setPrevious(Publicity previous) {
		this.previous = previous;
	}

	public Publicity getNext() {
		return next;
	}

	public void setNext(Publicity next) {
		this.next = next;
	}
	
}
