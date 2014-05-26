package net.orangemile.informatica.powercenter.domain;

public class InitProp implements Cloneable {

	private String name;
	private String value;
	private String description;
	private String userDefined;
	
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
	public String getUserDefined() {
		return userDefined;
	}
	public void setUserDefined(String userDefined) {
		this.userDefined = userDefined;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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

