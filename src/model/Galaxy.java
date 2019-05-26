package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class Planet.
 */
public class Galaxy {
		
	// CONSTANTS
	
	public static final String PATH ="data/text/planets.txt";

    public static final String MERCURY = "Mercury";

    // ATTRIBUTES
    
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
	
	public int compareGalaxyByNumPlanets( Galaxy p )
    {
        if( numPlanets == p.numPlanets )
            return 0;
        else if( numPlanets > p.numPlanets )
            return 1;
        else
            return -1;
    }
	
	//PLANETS
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
	
	public void loadPlanetsFile(String path, String separator) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		while(line != null) {
			String[] parts = line.split(separator);
			
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
 
		if( myFirstPlanet == null ){
			myFirstPlanet = p;
			myFirstPlanet.setPrevious(null);
			myFirstPlanet.setNext(null);
		}
		else{     		       		 
			Planet p2 = searchLast();
			p2.setNext(p);
			p.setPrevious(p2);
			p.setNext(null);
		}
	}
 
	public Planet searchLast( ){
		Planet current = myFirstPlanet;

        if( current != null ){
            while( current.getNext() != null ){
            	current = current.getNext();
            }
        }
        return current;
    }
	 
	 //NATURAL SATELLITE
	 public void addNaturalSatellite( String nameP, String nameS,String statusS, int areaS ){
		 try {
			searchPlanet(nameP).addNaturalSatellite(nameS, statusS, areaS);
		} catch (AlreadyExistSatelliteException e) {
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
