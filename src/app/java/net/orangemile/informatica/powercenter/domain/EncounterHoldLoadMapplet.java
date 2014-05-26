/**
 * 
 */
package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Hardcoded Implementation of the Mapplet class, that will create PI_EDW mpt_ENC_HOLDING_LOAD.
 * @author DC018902
 */
public class EncounterHoldLoadMapplet extends Mapplet {

	/**
	 * default constructor
	 */
	public EncounterHoldLoadMapplet() {
		
	}
	
	/**
	 * hard coded mapplet for mpt_ENC_HOLDING_LOAD
	 */
	public EncounterHoldLoadMapplet(boolean boo) {
		// use super constructor
		super();
		
		// create attribute list
		ArrayList<TableAttribute> attributeList = new ArrayList<TableAttribute>();
		
		// generate predefined names and values
		Queue<String> nameQ = generateNameList();
		Queue<String> valueQ = generateValueList();
		
		// feed in attributes
		while(!nameQ.isEmpty()){
			String attName = nameQ.remove();
			String attValue= valueQ.remove();
			attributeList.add( new TableAttribute(attName, attValue) );
		}
		//set attribute list
		this.setTableAttributeList(attributeList);
	}

	private Queue<String> generateNameList() {
		Queue<String> stringList = new LinkedList<String>();
		
		stringList.add("Lookup Sql Override");
		stringList.add("Lookup table name");
		stringList.add("Lookup Source Filter");
		stringList.add("Lookup caching enabled");
		stringList.add("Lookup policy on multiple match");

		return stringList;
	}

	private Queue<String> generateValueList() {
		Queue<String> stringList = new LinkedList<String>();
		
		stringList.add("");
		stringList.add("WH_OTH_QC_KEYS");
		stringList.add("");
		stringList.add("YES");
		stringList.add("Use First Value");
		
		return stringList;
	}



}
