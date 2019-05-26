package model;

public class SolidSatellite extends NaturalSatellite{
	
	//ATTRIBUTES
	private String componentCore;
	
	private String percentageComponent;

	//CONSTRUCTOR
	public SolidSatellite(String nSatellite, String sSatellite, int aSatellite, String cSatellite, String pSatellite) {
		super(nSatellite,sSatellite,aSatellite);
		componentCore=cSatellite;
		percentageComponent=pSatellite;
	}

	//METHODS
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
