package net.orangemile.informatica.powercenter.domain.sap;

public class SAPTableParam {

	private String name;
	private String type;	// (INPUT | OUTPUT | TABLE | CHANGING | NONE)
	private String def;
	private String isOptional;
	private String order;
	
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getIsOptional() {
		return isOptional;
	}
	public void setIsOptional(String isOptional) {
		this.isOptional = isOptional;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
