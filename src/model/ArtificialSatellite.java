package model;

import java.util.Collection;

public class ArtificialSatellite extends Satellite {
	
     // ATTRIBUTES
    /**
     * País de origen del satélite artificial.
     */
    private String country;
    
    /**
     * Tipo de servicio que ofrece el satélite artificial.
     */
    public static enum serviceType{MILITAR, COMUNICACIÓN, METEOROLÓGICO};
    
    public serviceType sType;
    
    //CONSTRUCTOR
    /**
     * Construye un satélite artificial con los datos suministrados por parámetro.
     * @param pNombre Nombre del satélite artificial. pNombre != null && pNombre != ""
     * @param pPais País de origen del satélite artificial. pPais != null && pPais != ""
     * @param pTipoDeServicio Tipo de servicio que ofrece satélite artificial. pTipoDeServicio = {TIPO_MILITAR, TIPO_COMUNICACION, TIPO_INVESTIGACION}
     */
    public ArtificialSatellite( String nSatellite, String cSatellite, serviceType tSatellite ){
    	super(nSatellite);
        country = cSatellite;
        sType = tSatellite;
    }

    //METHODS
	/**
     * Devuelve el país de origen del satélite artificial.
     * @return País de origen del satélite artificial.
     */
    public String getCountry( ){
        return country;
    }
    
    public void setCountry(String country) {
		this.country = country;
	}
    
    public serviceType getServiceType() {
    	return sType;
    }
    
    public void setServiceType(serviceType st) {
    	this.sType=st;
    }
    
    /**
     * Compara un Satelite con Otro Satelite
     * @param o es el otro Satelite con el que se compara
     * @return -1 si otherSatellite es menor a satellite, 0 si son iguales y 1 si otherSatellite es mayor al satellite
     */
	@Override
	public int compareTo(Satellite otherSatellite) {
		ArtificialSatellite satellite = ( ArtificialSatellite )otherSatellite;
        return super.getName().compareToIgnoreCase( satellite.getName() );
	}  
}
