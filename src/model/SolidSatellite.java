package model;

public class SolidSatellite extends NaturalSatellite{
	
	private String componentCore;
	private String percentageComponent;

	public SolidSatellite(String nSatellite, String sSatellite, int aSatellite, String cSatellite, String pSatellite) {
		super(nSatellite,sSatellite,aSatellite);
		componentCore=cSatellite;
		percentageComponent=pSatellite;
	}

	public String getComponentCore() {
		return componentCore;
	}

	public void setComponentCore(String c) {
		componentCore = c;
	}

	public String getPercentageComponent() {
		return percentageComponent;
	}

	public void setPercentageComponent(String percentageComponent) {
		this.percentageComponent = percentageComponent;
	}
}
