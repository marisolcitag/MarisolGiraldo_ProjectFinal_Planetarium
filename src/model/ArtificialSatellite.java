package model;

import java.util.Collection;

public class ArtificialSatellite extends Satellite {
	
     // ATTRIBUTES
    /**
     * Pa�s de origen del sat�lite artificial.
     */
    private String country;
    
    /**
     * Tipo de servicio que ofrece el sat�lite artificial.
     */
    public static enum serviceType{MILITAR, COMUNICACI�N, METEOROL�GICO};
    
    public serviceType sType;
    
    //CONSTRUCTOR
    /**
     * Construye un sat�lite artificial con los datos suministrados por par�metro.
     * @param pNombre Nombre del sat�lite artificial. pNombre != null && pNombre != ""
     * @param pPais Pa�s de origen del sat�lite artificial. pPais != null && pPais != ""
     * @param pTipoDeServicio Tipo de servicio que ofrece sat�lite artificial. pTipoDeServicio = {TIPO_MILITAR, TIPO_COMUNICACION, TIPO_INVESTIGACION}
     */
    public ArtificialSatellite( String nSatellite, String cSatellite, serviceType tSatellite ){
    	super(nSatellite);
        country = cSatellite;
        sType = tSatellite;
    }

    //METHODS
	/**
     * Devuelve el pa�s de origen del sat�lite artificial.
     * @return Pa�s de origen del sat�lite artificial.
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
