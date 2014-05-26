package net.orangemile.informatica.powercenter.domain.sap;

public class SAPOutputPort {

	private String portName;
	private String fieldName;
	private String varName;
	private String dsqInstanceName;
	
	public String getDsqInstanceName() {
		return dsqInstanceName;
	}
	public void setDsqInstanceName(String dsqInstanceName) {
		this.dsqInstanceName = dsqInstanceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
}
