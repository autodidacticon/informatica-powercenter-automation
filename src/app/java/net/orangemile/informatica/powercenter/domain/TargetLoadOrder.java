package net.orangemile.informatica.powercenter.domain;

public class TargetLoadOrder implements Cloneable {

	private String  targetInstance;
	private String order;

	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getTargetInstance() {
		return targetInstance;
	}
	public void setTargetInstance(String targetInstance) {
		this.targetInstance = targetInstance;
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
