package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.NaturalSatellite;

class NaturalSatelliteTest extends TestCase {

	// ATTRIBUTES
    // -----------------------------------------------------------------

    /**
     * Sat�lite natural de prueba
     */
    private NaturalSatellite satellite;

    // METHODS

    /**
     * Escenario 1: Construye un nuevo sat�lite natural.
     * 
     * sat�lite - nombre: Satelite1, estado: Solido, area: 25
     */
    private void setupEscenario1( )
    {
        satellite = new NaturalSatellite( "Satelite1", "Solido", 25 );
    }

    /**
     * Prueba 2: Obtener el estado del sat�lite natural.<br>
     * <b> M�todos a probar: </b> <br>
     * getStatus<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el estado del sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el estado del satelite natural.
     */
    @Test
    public void testGetStatus( )
    {
        setupEscenario1( );
        assertEquals( "El Estado del Satelite Natural es Correcta", "Solido", satellite.getStatus() );
    }

    /**
     * Prueba 3: Obtener el area del sat�lite natural.<br>
     * <b> M�todos a probar: </b> <br>
     * getArea<br>
     * <b> Objetivo: </b> Probar que se creo correctamente el area del sat�lite natural.<br>
     * <b> Resultados esperados: </b> <br>
     * 1. Obtener el valor correcto del area.
     */
    @Test
    public void testGetArea( )
    {
        setupEscenario1( );
        assertEquals( "El Area del Satelite Natural es Correcta", 25, satellite.getArea() );
    }
}
