package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.Planet;

class PlanetTest extends TestCase {

	// ATTRIBUTES
	
	private static final String MERCURY = "Mercurio";

    /**
     * Planeta de prueba.
     */
    private Planet planet;
    
    //METHODS
    
    private void setupEscenary1( )
    {
        planet = new Planet( MERCURY, 0.466, 0.205, 115.88, 478.725, 7.004, "data/img/"+MERCURY+".gif" );
    }
    
    @Test
    public void testGetName( )
    {
        setupEscenary1( );
        assertEquals( "El Nombre del Planeta es Correcto", MERCURY, planet.getName());
    }
    
    @Test
    public void testGetAverageDistanceSun( )
    {
        setupEscenary1( );
        assertEquals( "La Distancia Media del Sol es Correcta", 0.466, planet.getAverageDistanceSun(), 0.001);
    }
    
    @Test
    public void testGetEccentricity( )
    {
        setupEscenary1( );
        assertEquals( "La Excentricidad del Planeta es Correcta", 0.205, planet.getEccentricity(), 0.001);
    } 
    
    @Test
    public void testGetOrbitalVelocity( )
    {
        setupEscenary1( );
        assertEquals( "La Velocidad Orbital del Planeta es Correcta", 478.725, planet.getOrbitalVelocity(), 0.001);
    } 
    
    @Test
    public void testGetOrbitalPeriod( )
    {
        setupEscenary1( );
        assertEquals( "El Periodo Orbital del Planeta es Correcto", 115.88, planet.getOrbitalPeriod(), 0.001);
    } 
    

    @Test
    public void testGetInclineOrbital( )
    {
        setupEscenary1( );
        assertEquals( "La Distancia de Inclinación es Correcta", 7.004, planet.getInclineOrbital(), 0.001 );
    }
    
    @Test
    public void testGetImage( )
    {
        setupEscenary1( );
        assertEquals( "La Imagen Obtenida del Planera es Correcta", "data/img/"+MERCURY+".gif" , planet.getImage());
    }

}
