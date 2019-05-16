package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa en el modelo un Planeta del Sistema Solar.
 *  
 */
public class Planet implements Comparable<Planet>{    
    // ATRIBUTOS
    
    private Planet next;
    
    private Planet previous;
    
    /**
    * Nombre del planeta.
    */
   private String name;

    /**
     * Distancia media al sol. Dada en UA.
     */
    private double averageDistanceSun;

    /**
     * Excentricidad del planeta.
     */
    private double eccentricity;

    /**
     * Periodo de orbital del planeta. Dado en años.
     */
    private double orbitalPeriod;

    /**
     * Velocidad media del planeta. Dada en km/s.
     */
    private double orbitalVelocity;

    /**
     * Inclinación del planeta. Dada en grados.
     */
    private double inclineOrbital;
 
    /**
     * Ruta de la imagen para mostar en la interfaz
     */
    private String imageSource;
    
    private NaturalSatellite rootNatural;
    
    private ArtificialSatellite rootArtificial;
    
    // CONSTRUCTOR
    /**
     * Construye un planeta con los datos suministrados por parámetro.
     * @param pNombre Nombre del planeta. pNombre != null && pNombre != ""
     * @param pDistanciaMediaSol Distancia media al sol. pDistanciaMediaSol > 0
     * @param pExcentricidad Excentricidad de la órbita.
     * @param pPeriodoOrbitalSinodico Periodo orbital sinódico.
     * @param pVelocidadOrbitalMedia Velocidad media del planeta.
     * @param pInclinacion Inclinación del planeta con respecto a su eje.
     * @param laRuta Ruta de la imagen para mostar en la interfaz.
     * 
     */
    public Planet( String pNombre, double pDistanciaMediaSol, double pExcentricidad, double pPeriodoOrbitalSinodico, double pVelocidadOrbitalMedia, double pInclinacion, String laRuta){
        name = pNombre;
        averageDistanceSun = pDistanciaMediaSol;
        eccentricity = pExcentricidad;
        orbitalPeriod = pPeriodoOrbitalSinodico;
        orbitalVelocity = pVelocidadOrbitalMedia;
        inclineOrbital = pInclinacion;
        imageSource = laRuta;
        rootNatural=null;
        rootArtificial=null;
    }
    
    //METODOS    
    /**
     * Metodo: getName()
     * Descripcion: Este Metodo se encarga de Retornar el Nombre del Planeta
     * @return nombre - Retorna el nombre del deportista.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public String getName() {
		return name;
	}
	
	/**
     * Metodo: setName
     * Descripcion: Este Metodo se encarga de Modificar  el Nombre del Planeta
     * @param name Nuevo nombre.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setName(String nombreP){
		name = nombreP; 	
	}
	
	/**
     * Metodo: getAverageDistanceSun()
     * Descripcion: Este Metodo se encarga de Retornar la Distancia Media al Sol
     * @return distanciaMediaSol - Retorna el valor de la distancia media al Sol
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public double getAverageDistanceSun() {
		return averageDistanceSun;
	}
	
	/**
     * Metodo: setAverageDistanceSun()
     * Descripcion: Este Metodo se encarga de Modificar el valor de la distancia media al Sol
     * @param distanciaSolP Nueva Distancia.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setAverageDistanceSun(double distanciaSolP){
		averageDistanceSun = distanciaSolP; 		
	}
	
	/**
     * Metodo: getEccentricity()
     * Descripcion: Este Metodo se encarga de Retornar la Excentricidad del Planeta
     * @return excentricidad - Retorna el valor de la excentricididad del Planeta
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public double getEccentricity() {
		return eccentricity;
	}
	
	/**
     * Metodo: setEccentricity()
     * Descripcion: Este Metodo se encarga de Modificar la Excentricidad del Planeta
     * @param excentricidadP Nueva Excentricidad.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setEccentricity(double excentricidadP){
		eccentricity = excentricidadP; 		
	}
	
	/**
     * Metodo: getOrbitalPeriod()
     * Descripcion: Este Metodo se encarga de Retornar el Periodo Orbital
     * @return periodoOrbital - Retorna el valor del Periodo Orbital (Sinódico)
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	/**
     * Metodo: setOrbitalPeriod()
     * Descripcion: Este Metodo se encarga de Modificar el valor del Periodo Orbital
     * @param orbitalPeriod -  Nuevo Periodo Orbital Sinodial.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setOrbitalPeriod(double periodoOrbitalP){
		orbitalPeriod = periodoOrbitalP; 		
	}
	
	/**
     * Metodo: getOrbitalVelocity()
     * Descripcion: Este Metodo se encarga de Retornar la Velocidad Orbital
     * @return valocidadOrbitalP - Retorna el valor de la Velocidad Orbital (Sinódico)
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public double getOrbitalVelocity() {
		return orbitalVelocity;
	}
	
	/**
     * Metodo: setOrbitalVelocity()
     * Descripcion: Este Metodo se encarga de Modificar el valor de la Velocidad Orbital Media
     * @param velocidadOrbitalMediaP -  Nueva Velocidad Orbital Media.
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setOrbitalVelocity(double velocidadOrbitalP){
		orbitalVelocity = velocidadOrbitalP; 		
	}
	
	/**
     * Metodo: getInclineOrbital()
     * Descripcion: Este Metodo se encarga de Retornar la Inclinacion Orbital
     * @return inclinacion - Retorna el valor de la Inclinacion
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public double getInclineOrbital() {
		return inclineOrbital;
	}
	
	/**
     * Metodo: setInclineOrbital()
     * Descripcion: Este Metodo se encarga de Modificar el valor de Inclinacion
     * @param inclinacionP - Nueva Inclinacion
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setInclineOrbital(double inclinacionP){
		inclineOrbital = inclinacionP; 		
	}
	
	/**
     * Metodo: getImage(()
     * Descripcion: Este Metodo se encarga de Retornar la Imagen del Planeta
     * @return rutaImagen - Retorna la Imagen del Planeta
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public String getImage() {
		return imageSource;
	}
	
	/**
     * Metodo: setImage
     * Descripcion: Este Metodo se encarga de Modificar la Imagen del Planeta
     * @param imagenP - Nueva Imagen
     * @linecode : 1 Linea
     * @devtime : 1 Minuto
	 */
	public void setImage(String imagenP){
		imageSource = imagenP; 		
	}

	public Planet getNext() {
		return next;
	}

	public void setNext(Planet siguiente) {
		this.next = siguiente;
	}

	public Planet getPrevious() {
		return previous;
	}

	public void setPrevious(Planet anterior) {
		this.previous = anterior;
	}

	@Override
	public int compareTo(Planet p) {
		// TODO Auto-generated method stub
		int comparation = 0;
		if(name.compareTo(p.getName()) > 0) {
			comparation =1;
		}
		else if(name.compareTo(p.getName()) < 0) {
			comparation = -1;
		}
		return comparation;
	}
	
	//NATURAL SATELLITE	
	//ADD
	public void addNaturalSatellite( String nSatellite, String sSatellite, int aSatellite ) throws AlreadyExistSatelliteException{
        NaturalSatellite c = new NaturalSatellite( nSatellite,sSatellite,aSatellite );
        if( rootNatural == null )
            rootNatural = c;
        else
            rootNatural.insertSatellite( c );
    }
	
	//DELETE
	public void deleteNaturalSatelite( String  nameS ){
        rootNatural.deleteSatellite(nameS) ;
    }
	
	//PREORDER
	public List<Satellite> preorderNaturalSatellite() {
		ArrayList<Satellite> s = new ArrayList<Satellite>();
		if(rootNatural != null) {
			rootNatural.preorder(s);
		}
		return s;
	}
	
	//INORDER
	public List<Satellite> inorderNaturalSatellite() {
		ArrayList<Satellite> s = new ArrayList<Satellite>();
		if(rootNatural != null) {
			rootNatural.inorder(s);
		}
		return s;
	}
	
	//POSTORDER
	public List<Satellite> postorderNaturalSatellite() {
		ArrayList<Satellite> s = new ArrayList<Satellite>();
		if(rootNatural != null) {
			rootNatural.postorder(s);
		}
		return s;
	}
	
	//ARTIFICIAL SATELLITE
	
	//ADD
	public void addArtificialSatellite( String nSatellite, String cSatellite, ArtificialSatellite.serviceType tSatellite ) throws AlreadyExistSatelliteException{
		ArtificialSatellite c = new ArtificialSatellite( nSatellite,cSatellite,tSatellite );
        if( rootArtificial == null )
            rootArtificial = c;
        else
            rootArtificial.insertSatellite( c );
    }
	
	//DELETE
	public void deleteArtificialSatelite( String  nameS ){
        rootArtificial.deleteSatellite(nameS) ;
	}
	
	//PREORDER
	public List<Satellite> preorderArtificialSatellite() {
		ArrayList<Satellite> s = new ArrayList<Satellite>();
		if(rootArtificial != null) {
			rootArtificial.preorder(s);
		}
		return s;
	}
	
	//INORDER
	public List<Satellite> inorderArtificialSatellite() {
		ArrayList<Satellite> s = new ArrayList<Satellite>();
		if(rootArtificial != null) {
			rootArtificial.inorder(s);
		}
		return s;
	}
	
	//POSTORDER
	public List<Satellite> postorderArtificialSatellite() {
		ArrayList<Satellite> s = new ArrayList<Satellite>();
		if(rootArtificial != null) {
			rootArtificial.postorder(s);
		}
		return s;
	}
}
