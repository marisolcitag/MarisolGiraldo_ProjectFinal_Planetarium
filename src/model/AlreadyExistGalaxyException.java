package model;


public class AlreadyExistGalaxyException extends Exception {
	
	private String nameGalaxy;

	public AlreadyExistGalaxyException(String nameGalaxy) {
        super( "Ya Existe una Galaxia con el nombre: " + nameGalaxy );
	}
	
	@Override
	public String getMessage() {
		String msg = super.getMessage();
		msg += ": " + nameGalaxy;
		return msg;
	}
}
