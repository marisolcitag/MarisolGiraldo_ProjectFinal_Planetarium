package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.ArtificialSatellite;
import model.ArtificialSatellite.serviceType;

/**
 * Clase usada para verificar que los m�todos de la clase SateliteArtificial est�n correctamente implementados
 */
class ArtificialSatelliteTest extends TestCase{
	
	    // ATRIBUTTES

	    /**
	     * Sat�lite artificial de prueba
	     */
	    private ArtificialSatellite satellite;

	    // METHODS

	    /**
	     * Escenario 1: Construye un nuevo sat�lite natural.	     * 
	     * satellite - Nombre: Satelite1, Pa�s: Colombia, Tipo de Servicio: COMUNICACION.
	     */
	    private void setupEscenario1( )
	    {
	        satellite = new ArtificialSatellite("Satelite1", "Colombia", serviceType.MILITAR);
	    }
	    
	    /**
	     * Prueba 1: Obtener el nombre del sat�lite artificial.<br>
	     * <b> M�todos a probar: </b> <br>
	     * getName<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite artificial.<br>
	     * <b> Resultados esperados: </b> <br>
	     * 1. Obtener el valor correcto del nombre.
	     */
	    @Test
	    public void testGetName( )
	    {
	        setupEscenario1( );
	        assertEquals( "El Nombre del Satelite Artificial Es Correcto", "Satelite1", satellite.getName() );
	    }
	    
	    /**
	     * Prueba 2: Obtener el pa�s de origen del sat�lite artificial.<br>
	     * <b> M�todos a probar: </b> <br>
	     * getCountry<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite artificial.<br>
	     * <b> Resultados esperados: </b> <br>
	     * 1. Obtener el valor correcto del pa�s.
	     */
	    @Test
	    public void testGetCountry( )
	    {
	        setupEscenario1( );
	        assertEquals( "El Pa�s del Satelite Artificial es Correcto", "Colombia", satellite.getCountry() );
	    }
	    
	    /**
	     * Prueba 3: Obtener el tipo de servicio que ofrece el sat�lite artificial.<br>
	     * <b> M�todos a probar: </b> <br>
	     * getServiceType<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el sat�lite artificial.<br>
	     * <b> Resultados esperados: </b> <br>
	     * 1. Obtener el valor correcto del tipo de servicio.
	     */
	    @Test
	    public void testGetServiceType( )
	    {
	        setupEscenario1( );
	        assertEquals( "El Tipo de Servicio del Satelite Artificial es Correcto", serviceType.MILITAR, satellite.getServiceType() );
	    } 
}
