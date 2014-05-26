package net.orangemile.informatica.powercenter.domain;

public class MapDependency implements Cloneable {

	private String fromInstance;
	private String fromInstanceType;
	private String toInstance;
	private String toInstanceType;
	
	public String getFromInstance() {
		return fromInstance;
	}
	public void setFromInstance(String fromInstance) {
		this.fromInstance = fromInstance;
	}
	public String getFromInstanceType() {
		return fromInstanceType;
	}
	public void setFromInstanceType(String fromInstanceType) {
		this.fromInstanceType = fromInstanceType;
	}
	public String getToInstance() {
		return toInstance;
	}
	public void setToInstance(String toInstance) {
		this.toInstance = toInstance;
	}
	public String getToInstanceType() {
		return toInstanceType;
	}
	public void setToInstanceType(String toInstanceType) {
		this.toInstanceType = toInstanceType;
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