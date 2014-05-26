package net.orangemile.informatica.powercenter.domain;

public class FieldDependency implements Cloneable {

	private String inputField;
	private String outputField;
	public String getInputField() {
		return inputField;
	}
	public void setInputField(String inputField) {
		this.inputField = inputField;
	}
	public String getOutputField() {
		return outputField;
	}
	public void setOutputField(String outputField) {
		this.outputField = outputField;
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
