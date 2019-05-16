package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.Galaxy;


/**
 * Clase usada para verificar que los métodos de la clase Galaxia estén correctamente implementados
 */
class GalaxyTest extends TestCase{

	// ATRIBUTTES
	/**
     * Galaxia de prueba.
     */
    private Galaxy myGalaxy;
    
    //METHODS
    
    /**
     * Escenario 1: Construye una nueva galaxia.     
     * planeta - nombre: Andromeda, numero de planetas: 2  
     */
    private void setupEscenary1( )
    {
        myGalaxy = new Galaxy( "Andromeda",2 );
    }
    
    /**
     * Prueba 1: Devuelve el nombre de la galaxia.<br>
     * <b> Métodos a probar: </b> <br>
     * getName<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el nombre de la galaxia.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del nombre de la galaxia.
     */
    @Test
    public void testGetName( )
    {
        setupEscenary1( );
        assertEquals( "El Nombre de la Galaxia es Correcto", "Andromeda", myGalaxy.getName());
    }
    
    @Test
    public void testGetNumPlanets( )
    {
        setupEscenary1( );
        assertEquals( "El Numero de Planetas de la Galaxia es Correcto", 2, myGalaxy.getNumPlanets());
    }
}
