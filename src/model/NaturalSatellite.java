package model;

public class NaturalSatellite extends Satellite {
	
	//ATTRIBUTES
	
    private String status;
    
    private int area;
      
   //CONSTRUCTOR
    
    public NaturalSatellite( String nSatellite, String sSatellite, int aSatellite){
        super(nSatellite);
        status = sSatellite;
        area = aSatellite;
    }

    //METHODS
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	 /**
     * Compara un Satelite con Otro Satelite
     * @param o es el otro Satelite con el que se compara
     * @return -1 si otherSatellite es menor a satellite, 0 si son iguales y 1 si otherSatellite es mayor al satellite
     */
	@Override
	public int compareTo(Satellite otherSatellite) {
		NaturalSatellite satellite = ( NaturalSatellite )otherSatellite;
        return super.getName().compareToIgnoreCase( satellite.getName() );
	}
	
}
