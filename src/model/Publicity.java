package model;

public class Publicity {
	
	//ATRIBUTES
	
	private String path;
	
	private Publicity previous;
	
	private Publicity next;
	
	//CONSTRUCTOR
	public Publicity(String pRoute) {
		
		path=pRoute;
	}

	public String getRuta() {
		return path;
	}

	public void setRuta(String ruta) {
		this.path = ruta;
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
