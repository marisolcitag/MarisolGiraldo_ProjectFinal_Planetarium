package test;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import model.ArtificialSatellite;
import model.ArtificialSatellite.serviceType;

/**
 * Clase usada para verificar que los métodos de la clase SateliteArtificial estén correctamente implementados
 */
class ArtificialSatelliteTest extends TestCase{
	
	    // ATRIBUTTES

	    /**
	     * Satélite artificial de prueba
	     */
	    private ArtificialSatellite satellite;

	    // METHODS

	    /**
	     * Escenario 1: Construye un nuevo satélite natural.	     * 
	     * satellite - Nombre: Satelite1, País: Colombia, Tipo de Servicio: COMUNICACION.
	     */
	    private void setupEscenario1( )
	    {
	        satellite = new ArtificialSatellite("Satelite1", "Colombia", serviceType.MILITAR);
	    }
	    
	    /**
	     * Prueba 1: Obtener el nombre del satélite artificial.<br>
	     * <b> Métodos a probar: </b> <br>
	     * getName<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el satélite artificial.<br>
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
	     * Prueba 2: Obtener el país de origen del satélite artificial.<br>
	     * <b> Métodos a probar: </b> <br>
	     * getCountry<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el satélite artificial.<br>
	     * <b> Resultados esperados: </b> <br>
	     * 1. Obtener el valor correcto del país.
	     */
	    @Test
	    public void testGetCountry( )
	    {
	        setupEscenario1( );
	        assertEquals( "El País del Satelite Artificial es Correcto", "Colombia", satellite.getCountry() );
	    }
	    
	    /**
	     * Prueba 3: Obtener el tipo de servicio que ofrece el satélite artificial.<br>
	     * <b> Métodos a probar: </b> <br>
	     * getServiceType<br>
	     * <b> Objetivo: </b> Probar que se creo correctamente el satélite artificial.<br>
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
