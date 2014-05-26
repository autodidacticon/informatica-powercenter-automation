package net.orangemile.informatica.powercenter.domain.constant;

public enum InstanceType {
	
	SOURCE_DEFINITION("Source Definition"),
	SOURCE_QUALIFIER("Source Qualifier"), 		
	EXPRESSION("Expression"),
	ROUTER("Router"),
	UPDATE_STRATEGY("Update Strategy"),
	SORTER("Sorter"),
	AGGREGATOR("Aggregator"),
	JOINER("Joiner"),
	LOOKUP_PROCEDURE("Lookup Procedure"),
	TARGET_DEFINITION("Target Definition");
	
	private String instanceType;

	private InstanceType(String instanceType) {
		this.instanceType = instanceType;
	}

	public String getInstanceType() {
		return instanceType;
	}
}
