package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.TableAttributeName;

public class TableAttribute implements Cloneable {

	private String name;
	private String value;
	
	public TableAttribute() {}
	
	public TableAttribute( String name, String value ) {
		this.name = name;
		this.value = value;		
	}
	
	public TableAttribute( TableAttributeName name, String value ) {
		this.name = name.getName();
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
