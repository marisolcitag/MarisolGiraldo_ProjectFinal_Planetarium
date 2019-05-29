package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.SolidSatellite;

class SolidSatelliteTest extends TestCase{
	
	// ATTRIBUTES
	
	/**
     * Satelite de prueba.
     */
    private SolidSatellite solidsatellite;
    
    //METHODS
    
    /**
     * Escenario 1: Construye un nuevo satelite gaseoso.
     * 
     * planeta - nombre: Satelite M, estado: Solido, area: 46, componente: hierro, porcentaje: 50%
     */
    private void setupEscenary1( ) {    
    solidsatellite = new SolidSatellite("Satelite1","Solido",25, "Hierro", "50%"); 
    }
    
    /**
     * Prueba 1: Devuelve el componente del satelite natural.<br>
     * <b> Métodos a probar: </b> <br>
     * getComponentCore<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el componente del satelite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del componente del satelite natural.
     */
    @Test
    public void testGetComponenteCore() {
    	setupEscenary1();
    	assertEquals( "El Nombre del Satelite Natural Es Correcto","Hierro",solidsatellite.getComponentCore()); 	
    }
    
    /**
     * Prueba 2: Devuelve el porcentanje del componente del satelite natural.<br>
     * <b> Métodos a probar: </b> <br>
     * getPercentageComponent<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el porcentaje componente del satelite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del porcentaje del componente del satelite natural.
     */
    @Test
    public void testGetPercentageComponente() {
    	setupEscenary1();
    	assertEquals( "El Porcentaje del Satelite Natural Es Correcto","50%",solidsatellite.getPercentageComponent()); 	
    }
}
