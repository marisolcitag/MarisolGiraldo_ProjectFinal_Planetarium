package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Planet.
 */
public class Planet implements Comparable<Planet>{    
    
	// ATTRIBUTES
	
    private Planet next;
    
    private Planet previous;
    
    private String name;

    private double averageDistanceSun;

    private double eccentricity;

    private double orbitalPeriod;

    private double orbitalVelocity;

    private double inclineOrbital;
 
    private String imageSource;
    
    private NaturalSatellite rootNatural;
    
    private ArtificialSatellite rootArtificial;
    
    // CONSTRUCTOR
    
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
    
    //METHODS   
    
	public String getName() {
		return name;
	}
	
	public void setName(String nombreP){
		name = nombreP; 	
	}
	
	public double getAverageDistanceSun() {
		return averageDistanceSun;
	}
	
	public void setAverageDistanceSun(double distanciaSolP){
		averageDistanceSun = distanciaSolP; 		
	}
	
	public double getEccentricity() {
		return eccentricity;
	}
	
	public void setEccentricity(double excentricidadP){
		eccentricity = excentricidadP; 		
	}
	
	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}
	
	public void setOrbitalPeriod(double periodoOrbitalP){
		orbitalPeriod = periodoOrbitalP; 		
	}

	public double getOrbitalVelocity() {
		return orbitalVelocity;
	}
	
	public void setOrbitalVelocity(double velocidadOrbitalP){
		orbitalVelocity = velocidadOrbitalP; 		
	}
	
	public double getInclineOrbital() {
		return inclineOrbital;
	}
	
	public void setInclineOrbital(double inclinacionP){
		inclineOrbital = inclinacionP; 		
	}
	
	public String getImage() {
		return imageSource;
	}
	
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
	
	public NaturalSatellite getRootNatural() {
		return rootNatural;
	}

	public void setRootNatural(NaturalSatellite rootNatural) {
		this.rootNatural = rootNatural;
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

	public ArtificialSatellite getRootArtificial() {
		return rootArtificial;
	}

	public void setRootArtificial(ArtificialSatellite rootArtificial) {
		this.rootArtificial = rootArtificial;
	}
	
	
}
