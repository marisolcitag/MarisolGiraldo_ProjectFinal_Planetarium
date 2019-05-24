package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Galaxy {
	
	public static final String PATH ="data/text/planets.txt";
	
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
		
		if(name.equalsIgnoreCase("Andromeda") || name.equalsIgnoreCase("Via Lactea")) {
		 try {
			loadPlanetsFile(PATH, ",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			Planet newP = new Planet(name+"-"+0, 0.466, 0.205, 115.88, 478.725, 7.004, "data/img/"+MERCURY+".gif");
			myFirstPlanet= newP;
			myFirstPlanet.setPrevious(null);
			Planet newSecondP ;

			for (int i=1; i<numPlanets;i++) {
				
				newSecondP= new Planet(name+"-"+i, 0.466, 0.205, 115.88, 478.725, 7.004, "data/img/"+MERCURY+".gif");
				newSecondP.setPrevious(newP);
				newP.setNext(newSecondP);
				newP=newSecondP;
			}
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
	 
	 /**
	     * Carga los perros iniciales de la exposición a partir de un archivo de propiedades.
	     * @param archivo nombre del archivo de propiedades que contiene la información de los perros - archivo!=null
	     */
	 public void loadPlanetsFile(String path, String sep) throws IOException {
			File f = new File(path);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			while(line != null) {
				String[] parts = line.split(sep);
				
				String nameG = parts[0];
				String name = parts[1];
		        double averageDistanceSun = Double.parseDouble(parts[2]);
		        double eccentricity = Double.parseDouble(parts[3]);
		        double orbitalPeriod = Double.parseDouble(parts[4]);
		        double orbitalVelocity = Double.parseDouble(parts[5]);
		        double inclineOrbital = Double.parseDouble(parts[6]);
		        String imageSource = parts[7];
				
		        if(nameG.equalsIgnoreCase(this.name)) {
				 Planet p = new Planet(name, averageDistanceSun, eccentricity, orbitalPeriod, orbitalVelocity, inclineOrbital, imageSource);
				 addPlanet(p);
		        }
				line = br.readLine();
				
			}
			
			br.close();
			fr.close();
		}
	 
	 public void addPlanet(Planet p) {
	 
		 if( myFirstPlanet == null ) // Si la cabeza no existe adiciona de primero el paciente
		 {
			 myFirstPlanet = p;
			 myFirstPlanet.setPrevious(null);
			 myFirstPlanet.setNext(null);
		 }
		 else
		 {     		       		 
    	 Planet p2 = searchLast();
    	 p2.setNext(p);
    	 p.setPrevious(p2);
    	 p.setNext(null);
		 }
	 }
	 
	 public Planet searchLast( )
	    {
	        Planet current = myFirstPlanet;

	        if( current != null )
	        {
	            while( current.getNext() != null )
	            {
	            	current = current.getNext();
	            }
	        }
	        return current;
	    }
			
			
	
}
