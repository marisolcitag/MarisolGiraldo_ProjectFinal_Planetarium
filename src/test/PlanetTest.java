package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.Planet;

class PlanetTest extends TestCase {

	// ATTRIBUTES
	
	/**
     * Constante que determina el nombre del planeta Mercurio.
     */
	private static final String NOMBRE_MERCURIO = "Mercurio";

    /**
     * Planeta de prueba.
     */
    private Planet planet;
    
    //METHODS
    
    /**
     * Escenario 1: Construye un nuevo planeta.
     * 
     * planeta - nombre: Mercurio, distancia media al sol: 0.382, excentricidad: 0.205, periodo de órbita: 115.88, velocidad media: 478.725, inclinación: 7.004.  
     */
    private void setupEscenary1( )
    {
        planet = new Planet( NOMBRE_MERCURIO, 0.466, 0.205, 115.88, 478.725, 7.004, "data/img/"+NOMBRE_MERCURIO+".gif" );
    }
    
    /**
     * Prueba 1: Devuelve el nombre del planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darNombre<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del nombre del planeta.
     */
    @Test
    public void testGetName( )
    {
        setupEscenary1( );
        assertEquals( "El Nombre del Planeta es Correcto", NOMBRE_MERCURIO, planet.getName());
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
    
    /**
     * Prueba 5: Devuelve la inclinación del planeta.<br>
     * <b> Métodos a probar: </b> <br>
     * darInclinacion<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el planeta.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto de la inclinación orbital.
     */
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
        assertEquals( "La Imagen Obtenida del Planera es Correcta", "data/img/"+NOMBRE_MERCURIO+".gif" , planet.getImage());
    }

}
