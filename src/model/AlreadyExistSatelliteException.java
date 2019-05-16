package model;


public class AlreadyExistSatelliteException extends Exception {

	public AlreadyExistSatelliteException(String nombreSatel) {
        super( "Ya Existe un Satelite con Ese nombre: " + nombreSatel );

		// TODO Auto-generated constructor stub
	}
}
