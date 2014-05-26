package net.orangemile.informatica.powercenter.domain;

public class Scheduler implements Cloneable {

	private String name;
	private String description;
	private Boolean reusable;
	private String versionNumber;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public Boolean isReusable() {
		return reusable;
	}
	public void setReusable(Boolean reusable) {
		this.reusable = reusable;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}	
}
