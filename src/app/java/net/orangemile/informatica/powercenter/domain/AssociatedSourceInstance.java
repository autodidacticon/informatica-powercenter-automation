package net.orangemile.informatica.powercenter.domain;

public class AssociatedSourceInstance implements Cloneable {

	private String name;

	public AssociatedSourceInstance() {}
	
	public AssociatedSourceInstance( String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
