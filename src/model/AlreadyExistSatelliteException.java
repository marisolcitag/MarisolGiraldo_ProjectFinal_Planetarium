package model;


public class AlreadyExistSatelliteException extends Exception {
	
	private String nameSatellite;

	public AlreadyExistSatelliteException(String nameSatellite) {
        super( "Ya Existe un Satelite con el nombre: " + nameSatellite );
	}
	
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		msg += ": " + nameSatellite;
		return msg;
	}
}
