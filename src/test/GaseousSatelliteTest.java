package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.GaseousSatellite;

class GaseousSatelliteTest extends TestCase {

	// ATTRIBUTES
	
		/**
	     * Satelite de prueba.
	     */
	    private GaseousSatellite satellite;
	    
	    //METHODS
	    
	    /**
	     * Escenario 1: Construye un nuevo satelite gaseoso.
	     * 
	     * planeta - nombre: Satelite N, estado: Gaseoso, area: 15, porcentaje hidrogeno: 23%, porcentaje helium: 12%.
	     */
	    private void setupEscenary1( ) {    
	    satellite = new GaseousSatellite("Satelite N","Gaseoso",15,"23", "12"); 
	    }
	    
	    /**
	     * Prueba 1: Devuelve el porcentaje del componente de hidrogeno del satelite natural.<br>
	     * <b> Métodos a probar: </b> <br>
	     * getComponentHydrogen<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el porcentaje del componente hidrogeno del satelite natural.<br>
	     * <b> Resultados esperados: </b> <br>
	     * 1. Obtener el valor correcto el porcentaje del componente hidrogeno del satelite natural.
	     */
	    @Test
	    public void testGetComponentHydrogen() {
	    	setupEscenary1();
	    	assertEquals( "El Porcentaje del Componente Hidrogeno del Satelite Natural Es Correcto","23",satellite.getComponentHydrogen()); 	
	    }
	    
	    /**
	     * Prueba 2: Devuelve el porcentaje del componente de helium del satelite natural.<br>
	     * <b> Métodos a probar: </b> <br>
	     * getComponentHelium<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el porcentaje del componente helium del satelite natural.<br>
	     * <b> Resultados esperados: </b> <br>
	     * 1. Obtener el valor correcto el porcentaje del componente helium del satelite natural.
	     */
	    @Test
	    public void testGetComponentHelium() {
	    	setupEscenary1();
	    	assertEquals( "El Porcentaje del Componente Helium del Satelite Natural Es Correcto","12",satellite.getComponentHelium()); 	
	    }

}
