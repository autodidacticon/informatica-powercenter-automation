package net.orangemile.informatica.powercenter.pattern;

import org.apache.log4j.Logger;

import net.orangemile.informatica.powercenter.domain.Box;
import net.orangemile.informatica.powercenter.domain.Field;
import net.orangemile.informatica.powercenter.domain.TableAttribute;
import net.orangemile.informatica.powercenter.domain.Transformation;


/**
 * @author Orange Mile, Inc
 */
public class ChangeSqlAddColumnPatternCallback implements AddColumnPatternCallback {

	// logger
	private static final Logger log = Logger.getLogger( ChangeSqlAddColumnPatternCallback.class );
	
	/**
	 * Called by the AddColumnPatternCallback to change the transformation sql
	 */
	public void callback(Box box, Field newField, String exampleFieldName) {
		if ( box instanceof Transformation ) {
			Transformation tran = (Transformation) box;
			TableAttribute sqlQuery = tran.getTableAttribute("Sql Query");
			if (sqlQuery != null) {
				log.debug("Original Sql: " + sqlQuery.getValue());
				String sql = changeSql(sqlQuery.getValue(), 0, newField, exampleFieldName );
				sqlQuery.setValue(sql);
				log.debug("New Sql: " + sqlQuery.getValue());
			}
		}
	}

	/**
	 * Checks whether the whole word is lowercase
	 * @param str
	 * @return
	 */
	protected boolean isLowerCase( String str ) {
		for ( char c : str.toCharArray() ) {
			if ( Character.isUpperCase(c) ) {
				return false;
			}
		}
		return true;
	}	
	
	/**
	 * Attempts to re-write the SQL to add the new field
	 * @param sql
	 * @param start
	 * @return
	 */
	protected String changeSql( String sql, int start, Field newField, String exampleFieldName ) {
		if ( sql.length() <= start ) {
			return sql;
		}
		int index = sql.toLowerCase().indexOf( exampleFieldName.toLowerCase(), start );
		if ( index == -1 ) {
			return sql;
		}
		char dot = sql.charAt( index - 1 );
		SQLField sqlField = retrieveField(sql.substring(start), dot, exampleFieldName);
		if ( sqlField == null ) {
			throw new RuntimeException("Invalid state - field not found");
		}
		String newColumn = null;
		String newFieldName = newField.getName();
		if ( isLowerCase(sqlField.fieldName) ) {
			newFieldName = newFieldName.toLowerCase();
		}
		if ( sqlField.prefix != null ) {
			newColumn = sqlField.prefix + "." + newFieldName;
		} else {
			newColumn = newFieldName;
		}
		if ( sqlField.asFieldName != null ) {
			int nameIndex = sqlField.asFieldName.indexOf(sqlField.fieldName);
			if ( nameIndex > 0 ) {
				newColumn += " as " + sqlField.asFieldName.substring(0, nameIndex ) + newFieldName;
			}
		}
		int end = index + exampleFieldName.length();
		if ( sqlField.asFieldName != null ) {
			end = sql.indexOf(sqlField.asFieldName, end) + sqlField.asFieldName.length();	// after AS
		}
		String newSql = sql.substring(0, end) + "," + newColumn + sql.substring(end);
		return changeSql(newSql, end + newColumn.length(), newField, exampleFieldName);
	}
		
	/**
	 * Retrieves the location of the example field name in the SQL
	 * @param sql
	 * @param dot
	 * @return
	 */
	protected SQLField retrieveField( String sql, char dot, String exampleFieldName ) {
		String parts [] = sql.split("\\W");
		int i=0;		
		for ( String p : parts ) {
			if ( p.equalsIgnoreCase(exampleFieldName) ) {
				SQLField field = new SQLField();
				field.fieldName = p;
				if ( dot == '.' ) {
					field.prefix = parts[i-1];
				}
				if ( parts[i+1].equalsIgnoreCase("as") ) {
					field.asFieldName = parts[i+2];
				}
				return field;
			}
			i++;
		}
		return null;
	}
	
	/**
	 * Utility place holder for SQL modification 
	 */
	protected static class SQLField {
		public String prefix;
		public String fieldName;
		public String asFieldName;
		public int lastPosition;
	}
	
	
}
