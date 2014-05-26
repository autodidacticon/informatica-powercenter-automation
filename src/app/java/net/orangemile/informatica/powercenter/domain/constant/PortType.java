package net.orangemile.informatica.powercenter.domain.constant;

public enum PortType {
	INPUT("INPUT"),
	OUTPUT("OUTPUT"),
	VARIABLE("LOCAL VARIABLE"),
	
	LOOKUP("LOOKUP"),
	LOOKUP_OUTPUT("LOOKUP/OUTPUT"),
	LOOKUP_RETURN_OUTPUT("LOOKUP/RETURN/OUTPUT"),
	INPUT_OUTPUT_MASTER("INPUT/OUTPUT/MASTER"),
	INPUT_OUTPUT("INPUT/OUTPUT"), 
	GENERATED_KEY_OUTPUT("GENERATED KEY/OUTPUT"),
	GENERATED_COLUMN_ID_OUTPUT("GENERATED COLUMN ID/OUTPUT");
	
	private String portType;
	
	private PortType( String portType ) {
		this.portType = portType;
	}
	
	public String getPortType() {
		return portType;
	}
	
	public String toString() {
		return portType;
	}
	
	public static boolean isInputPort(PortType portType) {
		return ( portType != null && (portType == INPUT 
				|| portType == INPUT_OUTPUT 
				|| portType == INPUT_OUTPUT_MASTER) );
	}
	
	public static boolean isOutputPort(PortType portType) {
		return ( portType != null && (portType == OUTPUT 
				|| portType == INPUT_OUTPUT 
				|| portType == LOOKUP_OUTPUT 
				|| portType == INPUT_OUTPUT_MASTER) );			
	}		
}