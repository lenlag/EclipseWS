package factory;

public class CfgData {

	private String display;
	private String klassname;
	
	
	public CfgData(String display, String klassname) {
		this.display = display;
		this.klassname = klassname;
	}


	public String getDisplay() {
		return display;
	}


	public void setDisplay(String display) {
		this.display = display;
	}


	public String getKlassname() {
		return klassname;
	}


	public void setKlassname(String klassname) {
		this.klassname = klassname;
	}


	@Override
	public String toString() {
		return display + "," + klassname;
	}

	
	
	
	
}
