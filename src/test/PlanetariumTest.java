package test;


import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.Planetarium;

class PlanetariumTest extends TestCase{
	
	// ATTRIBUTES

    /**
     * Planetario de prueba.
     */
    private Planetarium planetarium;
    
    // METHODS
    
    /**
     * Escenario 1: Construye un nuevo planetario.
     * 
     */
    private void setupEscenary1( )
    {
    	planetarium = new Planetarium( );
    }
    
    /**
     * Prueba 1: Construye el observatorio.
     * <b> Objetivo: </b> Probar la inicialización del observatorio.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. El observatorio debe tener 8 planetas.
     */
    @Test
    public void testGetMyFirstPlanet( )
    {
        setupEscenary1( );
        assertEquals(8,planetarium.getMyFirstPlanet("Andromeda"));
        //assertEquals( "El Primer Planeta del Planetario debe ser Mercurio", planetarium.NOMBRE_MERCURIO, planetarium.getMyFirstPlanet());
    }
    
    @Test
    public void testSearchPlanet( )
    {
        setupEscenary1( );
        String nombreP = "Mercurio";
        assertEquals("Mercurio",planetarium.searchPlanet("Via Lactea",nombreP));
        //assertEquals( "El Primer Planeta del Planetario debe ser Mercurio", planetarium.NOMBRE_MERCURIO, planetarium.getMyFirstPlanet());
    }
}
