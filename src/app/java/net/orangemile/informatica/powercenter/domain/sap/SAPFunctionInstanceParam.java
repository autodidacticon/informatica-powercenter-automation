package net.orangemile.informatica.powercenter.domain.sap;

public class SAPFunctionInstanceParam {

	private String name;
	private String type;	// (INPUT | OUTPUT | TABLE | CHANGING | NONE) 
    private String value;
    private String valueType;	// (CONSTANT | VARIABLE | SOURCEFIELD | DEFAULT | NONE)
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValueType() {
		return valueType;
	}
	public void setValueType(String valueType) {
		this.valueType = valueType;
	}
}
