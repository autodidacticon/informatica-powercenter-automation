package net.orangemile.informatica.powercenter.domain;

/**
 * This class represents the connection between two mapping elements across a sing port.
 */
public class Connector implements Cloneable {

	private String fromInstance;
	private String fromInstanceType;
	private String fromField;
	private String toInstance;
	private String toInstanceType;
	private String toField;
	
	public Connector() {}
	
	/**
	 * Provide the to and from values in string form.
	 * @param fromField
	 * @param fromInstance
	 * @param fromInstanceType
	 * @param toField
	 * @param toInstance
	 * @param toInstanceType
	 */
	public Connector(String fromField, String fromInstance, String fromInstanceType,  
			String toField, String toInstance, String toInstanceType ) {
		this.fromInstance = fromInstance;
		this.fromInstanceType = fromInstanceType;
		this.fromField = fromField;
		
		this.toInstance = toInstance;
		this.toInstanceType = toInstanceType;
		this.toField = toField;
	}
	
	public String getFromInstance() {
		return fromInstance;
	}
	public void setFormInstance(String fromInstance) {
		this.fromInstance = fromInstance;
	}
	public String getFromField() {
		return fromField;
	}
	public void setFromField(String fromField) {
		this.fromField = fromField;
	}
	public String getFromInstanceType() {
		return fromInstanceType;
	}
	public void setFromInstanceType(String fromInstanceType) {
		this.fromInstanceType = fromInstanceType;
	}
	public String getToField() {
		return toField;
	}
	public void setToField(String toField) {
		this.toField = toField;
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
