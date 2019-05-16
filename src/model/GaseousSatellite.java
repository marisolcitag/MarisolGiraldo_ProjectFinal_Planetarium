package model;

public class GaseousSatellite extends NaturalSatellite{
	
	private String percentageHydrogen;
	private String percentageHelium;

	public GaseousSatellite(String nSatellite, String sSatellite, int aSatellite, String cHydrogenSatellite, String cHeliumSatellite) {
		super(nSatellite,sSatellite,aSatellite);
		percentageHydrogen= cHydrogenSatellite;
		percentageHelium= cHeliumSatellite;
	}

	public String getComponentHydrogen() {
		return percentageHydrogen;
	}
	
	public void setComponentHydrogen(String componentHydrogen) {
		percentageHydrogen = componentHydrogen;
	}

	public String getComponentHelium() {
		return percentageHelium;
	}
	
	public void setComponentHelium(String componentHelium) {
		percentageHelium = componentHelium;
	}
}
