package model;

import java.util.ArrayList;

/**
 * Clase que representa la clase principal del modelo 
 * 
 */
public class Planetarium{
    
    private ArrayList<Galaxy> galaxies;
       
    private Publicity publicity;

    // CONSTRUCTOR
    
    public Planetarium( )
    {
    	initialize();	
     }
    
    public void initialize() {
    	
    	galaxies= new ArrayList<Galaxy>();
    	galaxies.add(new Galaxy("Andromeda",2));
    	galaxies.add(new Galaxy("Via Lactea", 8));
    	
        publicity = new Publicity("data/img/YouKnowMercury.png");
        Publicity publicity1 = new Publicity("data/img/YouKnowVenus.png");
        Publicity publicity2 = new Publicity("data/img/YouKnowEarth.png");
        Publicity publicity3 = new Publicity("data/img/YouKnowMoon.png");
        Publicity publicity4 = new Publicity("data/img/YouKnowMars.png");
        Publicity publicity5 = new Publicity("data/img/YouKnowJupiter.png");
        
        publicity.setPrevious(null);
        publicity.setNext(publicity1);
        publicity1.setPrevious(publicity);
        publicity1.setNext(publicity2);
        publicity2.setPrevious(publicity1);
        publicity2.setNext(publicity3);
        publicity3.setPrevious(publicity2);
        publicity3.setNext(publicity4);
        publicity4.setPrevious(publicity3);
        publicity4.setNext(publicity5);
        publicity5.setPrevious(publicity4);
        publicity5.setNext(null);
    }

    //GALAXY
    public ArrayList<Galaxy> getGalaxies() {
  		return galaxies;
  	}
    
    /**
     * Busca una Galaxia según su nombre y retorna la galaxia.
     * @param nameG es el nombre de la galaxia a buscar - nameG!=null
     * @return Retorna la galaxia. Si no se encuentra ninguna galaxia retorna null
     */
  	public Galaxy searchGalaxy(String nameG) {
  		 
  		for( int i = 0; i < galaxies.size(); i++ ){
  			if( galaxies.get(i).getName( ).equals( nameG ) ){
  				return galaxies.get(i);
  	        }
  	    }
  	    return null;
  	}
  	
  	/**
     * Busca una galaxia utilizando el ALGORITMO DE BUSQUEDA BINARIA. <br>
     * <b>pre: </b> La lista de galaxias se encuentra ordenada por nombre.
     * @param nameG es el nombre de la galaxia que se va a buscar - name!=null
     * @return La posición de la galaxia con el nombre dado. Si la galaxia no existe se retorna -1.
     */
    public int searchBinaryByGalaxyName( String nameG )
    {
        int position = -1;
        int begin = 0;
        int end = galaxies.size( ) - 1;
        Galaxy g = new Galaxy( nameG,1 );
        while( begin <= end && position == -1 )
        {
            int middle = ( begin + end ) / 2;
            Galaxy mitad = ( Galaxy )galaxies.get( middle );
            if( mitad.compareGalaxyByName( g ) == 0 )
            {
                position = middle;
            }
            else if( mitad.compareGalaxyByName( g ) > 0 )
            {
                end = middle - 1;
            }
            else
            {
                begin = middle + 1;
            }
        }
        return position;
    }
    
    /**
     * Busca una galaxia utilizando el ALGORITMO DE BUSQUEDA BINARIA. <br>
     * <b>pre: </b> La lista de galaxias se encuentra ordenada por numero de planetas.
     * @param numPlanetsG es el numero de planetas de la galaxia que se va a buscar - numPlanetsG!=null
     * @return La posición de la galaxia con el numero de planetas dado. Si la galaxia no existe se retorna -1.
     */
    public int searchBinaryByGalaxyNumPlanets( int numPlanetsG) {
        int position = -1;
        int begin = 0;
        int end = galaxies.size( ) - 1;
        Galaxy g = new Galaxy( "",numPlanetsG );
        while( begin <= end && position == -1 )
        {
            int middle = ( begin + end ) / 2;
            Galaxy mitad = ( Galaxy )galaxies.get( middle );
            if( mitad.compareGalaxyByNumPlanets( g ) == 0 )
            {
                position = middle;
            }
            else if( mitad.compareGalaxyByNumPlanets( g ) > 0 )
            {
                end = middle - 1;
            }
            else
            {
                begin = middle + 1;
            }
        }
        return position;
    }

  	/**
     * Organiza la lista de galaxias por nombre usando el ALGORITMO BURBUJA. <br>
     * <b>post: </b>La lista de galaxias está ordenada por nombre (orden ascendente).
     */
    public void orderGalaxyByName( )
    {
        for( int i = galaxies.size( ); i > 0; i-- )
        {
            for( int j = 0; j < i - 1; j++ )
            {
                Galaxy p1 = ( Galaxy )galaxies.get( j );
                Galaxy p2 = ( Galaxy )galaxies.get( j + 1 );

                // Si es necesario se deben intercambiar p1 y p2
                if( p1.compareGalaxyByName( p2 ) > 0 )
                {
                    galaxies.set( j, p2 );
                    galaxies.set( j + 1, p1 );
                }
            }
        }
    }
  	
    /**
     * Organiza la lista de galaxias por numero de planetas usando el ALGORITMO DE INSERCIÓN. <br>
     * <b>post: </b>La lista de las galaxias está ordenada por numero de planetas (orden ascendente).
     */
    public void orderGalaxyByNumPlanets( )
    {
        for( int i = 1; i < galaxies.size( ); i++ )
        {
            Galaxy g = ( Galaxy )galaxies.get( i );
            boolean end = false;
            for( int j = i; j > 0 && !end; j-- )
            {
            	Galaxy current = ( Galaxy )galaxies.get( j - 1 );
                if( current.compareGalaxyByNumPlanets( g ) > 0 )
                {
                	galaxies.set( j, current );
                	galaxies.set( j - 1, g );
                }
                else
                    end = true;
            }
        }
    }
    
    
    //PLANET
	public Planet getMyFirstPlanet(String nameG) {
		return searchGalaxy(nameG).getMyFirstPlanet();
	}	
	/**
     * Nombre: planetHigherInclination()
     * Descripcion:Retorna el Planeta con Mayor Inclinacion
	 * @return miPlaneta
	 * @linecode : 7 Lineas
	 * @devtime : 20 Minutos
	 */	 
    public Planet planetHigherInclination(String nameG){
	   	return searchGalaxy(nameG).planetHigherInclination();
    }
    
    /**
	 * Nombre: searchPlanet(String nameG,String nameP)
     * Descripción: Metodo que Retorna el Planeta que Ingrese como Parametro de Busqueda
	 * @return miPlaneta
	 * @linecode : 7 Lineas
	 * @devtime : 15 Minutos
	 */
	public Planet searchPlanet(String nameG,String nameP){
		return searchGalaxy(nameG).searchPlanet(nameP);
	}
	
	//PUBLICITY
	public Publicity getPublicity() {
		return publicity;
	}

	//NATURAL SATELLITE
	public Satellite getSatellitesNatural(String nameG, String nameP) {
		return searchGalaxy(nameG).searchPlanet(nameP).getRootNatural();
  		 
  	}

	
	public void addNaturalSatelite( String nameG, String nameP, String nameS, String statusS, int areaS ){
		searchGalaxy(nameG).addNaturalSatellite(nameP, nameS, statusS, areaS);
	    
	}
	
	public void deleteNaturalSatelite( String nameG, String nameP, String nameS )
    {
        searchGalaxy(nameG).deleteNaturalSatellite(nameP, nameS);
    }
	
	//ARTIFICIAL SATELLITE
	public void addArtificialSatellite( String nameG, String nameP, String nameS, String countryS, ArtificialSatellite.serviceType typeS) {
		searchGalaxy(nameG).addArtificialSatellite(nameP, nameS,countryS,typeS);
	}
	
	public void deleteArtificialSatelite( String nameG, String nameP, String nameS )
    {
        searchGalaxy(nameG).deleteArtificialSatellite(nameP, nameS);
    }
	
	public Satellite getSatellitesArtificial(String nameG, String nameP) {
		return searchGalaxy(nameG).searchPlanet(nameP).getRootArtificial();
  		 
  	}
	
	
	
}