package net.orangemile.informatica.powercenter.domain.sap;

public class SAPProgram {

	private String name;
	private String programType;
	private String installTime;
	private String hostname;
	private String username;
	private String clientSpace;
	private Boolean isValid;
	
	public String getClientSpace() {
		return clientSpace;
	}
	public void setClientSpace(String clientSpace) {
		this.clientSpace = clientSpace;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getInstallTime() {
		return installTime;
	}
	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
