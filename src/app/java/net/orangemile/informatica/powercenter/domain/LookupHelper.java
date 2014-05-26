package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class LookupHelper {

	private HashMap<String,String> lkpAttribs;
	/**
	 * creates an attribute list for a lookup using the condition
	 * and the table name
	 * @param lkpCondition
	 * @param lkpTableName
	 * @return
	 */
	public LookupHelper() {
		lkpAttribs = new HashMap<String,String>();
	}
	
	public LookupHelper( String lkpTableName ){
		// create needed attributes
		lkpAttribs = new HashMap<String,String>();
        lkpAttribs.put("Lookup condition", "" );
        lkpAttribs.put("Lookup table name", lkpTableName );
        lkpAttribs.put("Lookup caching enabled", "NO" );
        lkpAttribs.put("Lookup Sql Override", "" );
        lkpAttribs.put("Lookup Source Filter", "" );
        lkpAttribs.put("Lookup policy on multiple match", "Use Any Value" );
        lkpAttribs.put("Connection Information", "$Target" );
        lkpAttribs.put("Source Type", "Database" );
        lkpAttribs.put("Lookup caching enabled", "YES");
	}
	
	
	public List<TableAttribute> createAttributeList(String lkpCondition,
			String lkpTableName) {
		lkpAttribs	 = new HashMap<String, String>();
		
		// create needed attributes
        lkpAttribs.put("Lookup condition", lkpCondition );
        lkpAttribs.put("Lookup table name", lkpTableName );
        lkpAttribs.put("Lookup caching enabled", "YES" );
        lkpAttribs.put("Lookup Sql Override", "" );
        lkpAttribs.put("Lookup Source Filter", "" );
        lkpAttribs.put("Lookup policy on multiple match", "Use Any Value" );
        lkpAttribs.put("Connection Information", "$Target" );
        lkpAttribs.put("Source Type", "Database" );

        List<TableAttribute> attribs = new ArrayList<TableAttribute>();
        for( Entry<String,String> e : lkpAttribs.entrySet() ){
        	attribs.add(new TableAttribute(e.getKey(),e.getValue()));
        }
        return attribs;
	}

	public void addAttribute( String name, String value ){
		lkpAttribs.put(name, value);
	}
	
	public List<TableAttribute> getAttributeList() {
		List<TableAttribute> attribs = new ArrayList<TableAttribute>();
        for( Entry<String,String> e : lkpAttribs.entrySet() ){
        	attribs.add(new TableAttribute(e.getKey(),e.getValue()));
        }
        return attribs;
	}
}
