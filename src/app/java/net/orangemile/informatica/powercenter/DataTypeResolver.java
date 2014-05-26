package net.orangemile.informatica.powercenter;

import net.orangemile.informatica.powercenter.domain.Field;

public class DataTypeResolver {
	
	public static void toInformaticaType( Field field ) {
		String dataType = field.getDataType();
		if ( dataType.equalsIgnoreCase("varbinary") ) {
			field.setDataType("binary");
		} else if ( dataType.equalsIgnoreCase("datetime") || dataType.equalsIgnoreCase("timestamp") ) {
			field.setDataType("date/time");
			field.setScale(0);
			field.setPrecision(19);
		} else if ( dataType.equalsIgnoreCase("smallint") ) {
			field.setDataType("small integer");
		} else if ( dataType.equalsIgnoreCase("numeric") ) {
			field.setDataType("decimal");
		} else if ( dataType.equalsIgnoreCase("varchar")  ) {
			field.setDataType("string");
		} else {
			field.setDataType(field.getDataType().toLowerCase());
		}
	}	

		
}
