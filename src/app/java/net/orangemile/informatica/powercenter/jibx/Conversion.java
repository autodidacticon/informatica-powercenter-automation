package net.orangemile.informatica.powercenter.jibx;

import net.orangemile.informatica.powercenter.domain.constant.PortType;

public class Conversion {

	public static String serializeYesNo(Boolean value) {
		return (value != null && value)?"YES":"NO";
	}
	
	public static Boolean deserializeYesNo(String text) {
		return ( text != null && text.equalsIgnoreCase("YES") );
	}

	public static PortType deserializePortType( String portType ) {
		for ( PortType p : PortType.values() ) {
			if ( p.getPortType().equalsIgnoreCase(portType)) {
				return p;
			}
		}
		throw new RuntimeException("PortType " + portType + " not found");
	}
	
	public static String serializePortType( PortType portType ) {
		if ( portType == null ) {
			return null;
		}
		return portType.getPortType();
	}
}
