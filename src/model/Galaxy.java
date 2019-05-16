package model;

public class Galaxy {
	
	// CONSTANTES
	/**
     * Constante que determina el nombre del planeta Ípsilon A.
     */
	public static final String IPSILON_A ="Ipsilon_A";
	
	/**
     * Constante que determina el nombre del planeta Ípsilon B.
     */
	public static final String IPSILON_B ="Ipsilon_B";
	
    /**
     * Constante que determina la cantidad de elementos que tiene el arreglo de planetas.
     */
/*    public static final int CANTIDAD_PLANETAS = 8;
*/
    public static final String MERCURY = "Mercury";

    /**
     * Constante que determina el nombre del planeta Venus.
     */
    public static final String VENUS = "Venus";

    /**
     * Constante que determina el nombre del planeta Tierra.
     */
    public static final String EARTH = "Earth";

    /**
     * Constante que determina el nombre del planeta Marte.
     */
    public static final String MARS = "Mars";
    
    /**
     * Constante que determina el nombre del planeta Júpiter.
     */
    public static final String JUPITER = "Jupiter";

    /**
     * Constante que determina el nombre del planeta Saturno.
     */
    public static final String SATURN = "Saturn";

    /**
     * Constante que determina el nombre del planeta Urano.
     */
    public static final String URANUS = "Uranus";

    /**
     * Constante que determina el nombre del planeta Neptuno.
     */
    public static final String NEPTUNE = "Neptune";

    // ATRIBUTOS
    /**
     * Arreglo que contiene los planetas del sistema solar.
     */
    //private Planeta[] planetas;
    
    private Planet myFirstPlanet;
	
	private String name;
	
	private int numPlanets;
	
	public Galaxy(String name, int numPlanets) {
		myFirstPlanet=null;
		this.name = name;
		this.numPlanets = numPlanets;
		initialize();
	}
	
	public void initialize() {
		
		if(name.equals("Andromeda")) {
			myFirstPlanet= new Planet(IPSILON_A, 0.266, 0.105, 105.68, 372.495, 4.004, "data/img/"+IPSILON_A+".gif");
			Planet planetIpsilonB= new Planet(IPSILON_B, 0.166, 0.405, 317.58, 248.823, 8.134, "data/img/"+IPSILON_B+".gif");
			myFirstPlanet.setPrevious(null);
	        myFirstPlanet.setNext(planetIpsilonB);
	        planetIpsilonB.setPrevious(myFirstPlanet);
	        planetIpsilonB.setNext(null);
		}else {
		
		myFirstPlanet = new Planet( MERCURY, 0.466, 0.205, 115.88, 478.725, 7.004, "data/img/"+MERCURY+".gif" );
        Planet venus = new Planet( VENUS, 0.728, 0.006, 583.92, 35.021, 339.471, "data/img/"+VENUS+".gif");
        Planet tierra = new Planet( EARTH, 1.016, 0.0167, 365.25, 30.28, 23.45,"data/img/"+EARTH+".gif" );
        Planet marte = new Planet( MARS, 1.665, 0.09341233, 779.95, 24.13, 1.850,"data/img/"+MARS+".gif" );
        Planet jupiter = new Planet( JUPITER, 5.458, 0.09341233, 398.9, 13.069, 1.305,"data/img/"+JUPITER+".gif" );
        Planet saturno = new Planet( SATURN, 10.115, 0.0541506, 378.1, 9.67, 2.484,"data/img/"+SATURN+".gif" );
        Planet urano = new Planet( URANUS, 20.096, 0.04716771, 369.7, 6.835, 0.769,"data/img/"+URANUS+".jpg");
        Planet neptuno = new Planet( NEPTUNE, 30.327, 0.00858587, 367.5, 5.47, 1.769,"data/img/"+NEPTUNE+".gif");
        
        myFirstPlanet.setPrevious(null);
        myFirstPlanet.setNext(venus);
        venus.setPrevious(myFirstPlanet);
        venus.setNext(tierra);
        tierra.setPrevious(venus);
        tierra.setNext(marte);
        marte.setPrevious(tierra);
        marte.setNext(jupiter);
        jupiter.setPrevious(marte);
        jupiter.setNext(saturno);
        saturno.setPrevious(jupiter);
        saturno.setNext(urano);
        urano.setPrevious(saturno);
        urano.setNext(neptuno);
        neptuno.setPrevious(urano);
        neptuno.setNext(null);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPlanets() {
		return numPlanets;
	}

	public void setNumPlanets(int numPlanets) {
		this.numPlanets = numPlanets;
	}

	/**
     * Compara dos galaxias según su nombre. <br>
     * @param g es la galaxia contra el que se está comparando - g != null
     * @return Retorna 0 si las galaxias tienen el mismo nombre. <br>
     *         Retorna -1 si la galaxia g tiene una valor "MAYOR" para el nombre. <br>
     *         Retorna 1 si la galaxia tiene una valor "MENOR" para el nombre. <br>
     */
	public int compareGalaxyByName( Galaxy g){
	    int valueCompare = name.compareToIgnoreCase( g.name );
	    if(valueCompare < 0){
	    	valueCompare = -1;
	    }else if(valueCompare == 0){
	    	 valueCompare = 0;
	    }else{
	    	 valueCompare = 1;
	    }
	    return valueCompare;
	}
	
	/**
     * Compara dos galaxias según su numero de planetas. <br>
     * @param g La galaxia contra el que se está comparando - g!= null
     * @return Retorna 0 si las galaxias tienen la misma de numero de planetas. <br>
     *         Retorna -1 si la galaxia g tiene una valor "MAYOR" para numero de planetas . <br>
     *         Retorna 1 si la galaxia tiene una valor "MENOR" para numero de planetas. <br>
     */
	public int compareGalaxyByNumPlanets( Galaxy p )
    {
        if( numPlanets == p.numPlanets )
            return 0;
        else if( numPlanets > p.numPlanets )
            return 1;
        else
            return -1;
    }
	
	//METHODS PLANETS
	/**
     * Nombre: planetHigherInclination()
     * Descripcion:Retorna el Planeta con Mayor Inclinacion
	 * @return miPlaneta
	 * @linecode : 7 Lineas
	 * @devtime : 20 Minutos
	 */	 
    public Planet planetHigherInclination(){
	
    	Planet miPlaneta=myFirstPlanet;
		
		double inclinacionMayorPlaneta = myFirstPlanet.getInclineOrbital();
		
		while(miPlaneta.getNext()!=null){
			
			miPlaneta=miPlaneta.getNext();
						
			if(miPlaneta.getInclineOrbital()>inclinacionMayorPlaneta){
					
				inclinacionMayorPlaneta=miPlaneta.getInclineOrbital();
			}
		}			
		return miPlaneta;	
    }
    
    /**
	 * Nombre: searchPlanet()
     * Descripción: Metodo que Retorna el Planeta que Ingrese como Parametro de Busqueda
	 * @return miPlaneta
	 * @linecode : 7 Lineas
	 * @devtime : 15 Minutos
	 */
	public Planet searchPlanet(String nombreP){		
		Planet miPlaneta = myFirstPlanet;
		while(miPlaneta.getNext()!=null) {							
						
			if (!miPlaneta.getName().equalsIgnoreCase(nombreP)){		
					
				miPlaneta=miPlaneta.getNext();
			}else {break;}
		}
					
		return miPlaneta;
	}

	public Planet getMyFirstPlanet() {
		return myFirstPlanet;
	}
	 
	 //NATURAL SATELLITE
	 public void addNaturalSatellite( String nameP, String nameS,String statusS, int areaS ){
		 try {
			searchPlanet(nameP).addNaturalSatellite(nameS, statusS, areaS);
		} catch (AlreadyExistSatelliteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	 
	 public void deleteNaturalSatellite(String nameP,String nameS) {
		 searchPlanet(nameP).deleteNaturalSatelite(nameS);
	 }
	 
	 //ARTIFICIAL SATELLITE
	 public void addArtificialSatellite( String nameP, String nameS,String countryS, ArtificialSatellite.serviceType typeS ){
		 try {
			searchPlanet(nameP).addArtificialSatellite(nameS, countryS, typeS);
		} catch (AlreadyExistSatelliteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  }
	 
	 public void deleteArtificialSatellite(String nameP,String nameS) {
		 searchPlanet(nameP).deleteArtificialSatelite(nameS);
	 } 
	 
	 public String toString() {
		 return name;
	 }
}
