package net.orangemile.informatica.powercenter.domain.sap;

public class SAPFunctionParam {

	private String name;
	private String type;	// (INPUT | OUTPUT | TABLE | CHANGING | NONE)
	private Boolean isReference;
    private String subType; // (STRUCTURETYPE | STRUCTUREFIELDTYPE | ABAPTYPE | NONE)
    private String def;
    private String dataType;
    private String precision;
    private String scale;
    private Boolean isOptional;
    private String defaultValue;
    private String order;
    
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Boolean getIsOptional() {
		return isOptional;
	}
	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}
	public Boolean getIsReference() {
		return isReference;
	}
	public void setIsReference(Boolean isReference) {
		this.isReference = isReference;
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
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
