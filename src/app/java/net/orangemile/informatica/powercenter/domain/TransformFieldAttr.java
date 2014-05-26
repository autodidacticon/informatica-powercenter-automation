package net.orangemile.informatica.powercenter.domain;

public class TransformFieldAttr implements Cloneable {

	private String name;
	private String value;
	
	public TransformFieldAttr(){
		name = new String();
		value = new String();
	}
	public TransformFieldAttr( String name, String value ){
		this.name = name;
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
