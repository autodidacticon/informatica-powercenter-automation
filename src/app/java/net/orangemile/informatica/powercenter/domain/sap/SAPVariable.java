package net.orangemile.informatica.powercenter.domain.sap;

public class SAPVariable {

	private String name;
	private String subType;	// (STRUCTURETYPE | STRUCTUREFIELDTYPE | ABAPTYPE | NONE)
	private String varDef;
	private String dataType;
	private String scale;
	private String precision;
	private String defaultValue;
	private Boolean isOutputPort;
	private String dsqInstanceName;
	
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDsqInstanceName() {
		return dsqInstanceName;
	}
	public void setDsqInstanceName(String dsqInstanceName) {
		this.dsqInstanceName = dsqInstanceName;
	}
	public Boolean getIsOutputPort() {
		return isOutputPort;
	}
	public void setIsOutputPort(Boolean isOutputPort) {
		this.isOutputPort = isOutputPort;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getVarDef() {
		return varDef;
	}
	public void setVarDef(String varDef) {
		this.varDef = varDef;
	}
}
