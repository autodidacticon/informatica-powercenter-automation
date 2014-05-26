package net.orangemile.informatica.powercenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.cerner.powerinsight.edw.mappinggenerator.Activator;
import com.cerner.powerinsight.edw.mappinggenerator.powercenter.FieldSet;
import com.cerner.powerinsight.edw.mappinggenerator.powercenter.NameDatabaseManager;

import net.orangemile.informatica.powercenter.domain.*;
import net.orangemile.informatica.powercenter.domain.constant.*;

/**
 * 
 *informatica support is used to do tasks for general mapping/informatica object creation
 *and management
 *
 *it was the original creators "do it all" class, and could use design revision
 */
public class InformaticaSupport {

	private Mapping mapping;
	private Folder folder;
	private String tableName;
	private String primaryIDName;
	public NameDatabaseManager nameDbMgr;
	
	
	
	public InformaticaSupport( Mapping mapping, Folder folder ) {
		this.mapping = mapping;
		this.folder = folder;
	}
	
	public InformaticaSupport(Mapping inputMapping, Folder inputFolder,
			String tableName, String primaryIDName, NameDatabaseManager ndbman ) {
		this.mapping = inputMapping;
		this.folder = inputFolder;
		this.tableName = tableName;
		this.primaryIDName = primaryIDName;
		// get column names of the target table
    	this.nameDbMgr = ndbman;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public Mapping getMapping() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param sourceInstanceName
	 * @param transformFieldList
	 * @param tableAttributeList
	 * @return 
	 */
	public Transformation sourceQualifier(String name, String description, String sourceInstanceName,
			List<TransformField> transformFieldList, List<TableAttribute> tableAttributeList) {
		return addTransformation(name, description, InstanceType.SOURCE_QUALIFIER, sourceInstanceName, transformFieldList, tableAttributeList);
	}
	

	/**
	 * 
	 * @param name
	 * @param description
	 * @param sourceInstanceName
	 * @param transformFieldList
	 * @param tableAttributeList
	 * @return 
	 */
	public Transformation lookup(String name, String description, String sourceInstanceName,
			List<TransformField> transformFieldList, List<TableAttribute> tableAttributeList) {
		return addTransformation(name, description, InstanceType.LOOKUP_PROCEDURE, sourceInstanceName, transformFieldList, tableAttributeList);
	}
	
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @param sourceInstanceName
	 * @param transformFieldList
	 * @param tableAttributeList
	 * @return 
	 */
	public Transformation router(String name, String description, String sourceInstanceName,
			List<TransformField> transformFieldList, List<TableAttribute> tableAttributeList) {
		return addTransformation(name, description, InstanceType.ROUTER, sourceInstanceName, transformFieldList, tableAttributeList);
	}
	
	public Transformation normalizer( String name, String description, List<SourceField> nrmFields ) {
		Transformation nrm = new Transformation(name, description, InstanceType.NORMALIZER);
		nrm.setReusable(false);
		nrm.setSourceFieldList( new ArrayList<SourceField>(nrmFields) );
		
		boolean first = true;
		TransformField GK = new TransformField();
		ArrayList<TransformField> GCID = new ArrayList<TransformField>();
		for( SourceField field : nrmFields ) {
			int rpt = field.getOccurs();
			String srcDataType = field.getDataType();
			int srcPrecision = field.getPrecision();
			int srcScale = field.getScale();
			
			if( srcDataType.equalsIgnoreCase("double") || srcDataType.equalsIgnoreCase("integer") || srcDataType.equalsIgnoreCase("bigint") 
					|| srcDataType.equalsIgnoreCase("real") || srcDataType.equalsIgnoreCase("number") || srcDataType.equalsIgnoreCase("small integer"))
				srcDataType = new String("decimal");
			else if( srcDataType.equalsIgnoreCase("date/time")) {
				srcDataType = new String("string");
				srcPrecision = 20;
				srcScale = 0;
			}
			if( first && rpt > 1 ){
				GK = new TransformField("GK_"+field.getName(), "bigint", 19,
						0, PortType.GENERATED_KEY_OUTPUT);
				GK.setRefSourceField(field.getName());
			} else if ( rpt > 1 ) {
				TransformField GC = new TransformField("GCID_"+field.getName(),"integer",10,0,PortType.GENERATED_COLUMN_ID_OUTPUT);
				GC.setRefSourceField( field.getName());
				GCID.add(GC);
			}
			for( Integer i = 1; i <= rpt; i++ ){
				TransformField errFld = new TransformField(field.getName()+"_in"+(rpt >1 ? i.toString() : ""), 
						srcDataType, srcPrecision, srcScale, PortType.INPUT);
				errFld.setRefSourceField( field.getName());
				nrm.addTransformField(errFld);
			}
		}
		for( SourceField field : nrmFields ){
			String srcDataType = field.getDataType();
			int srcPrecision = field.getPrecision();
			int srcScale = field.getScale();
			
			if( srcDataType.equalsIgnoreCase("double") || srcDataType.equalsIgnoreCase("integer") || srcDataType.equalsIgnoreCase("bigint") 
					|| srcDataType.equalsIgnoreCase("real")  || srcDataType.equalsIgnoreCase("number") || srcDataType.equalsIgnoreCase("small integer"))
				srcDataType = new String("decimal");
			else if( srcDataType.equalsIgnoreCase("date/time")) {
				srcDataType = new String("string");
				srcPrecision = 20;
				srcScale = 0;
			}
			TransformField errFld = new TransformField( field.getName(), 
					srcDataType, srcPrecision, srcScale, PortType.OUTPUT);
			errFld.setRefSourceField( field.getName());
			nrm.addTransformField(errFld);
		}
		nrm.addTransformField(GK);
		nrm.addTransformFields(GCID);
		ArrayList<TableAttribute> tableAttributes = new ArrayList<TableAttribute>();
		tableAttributes.add(new TableAttribute("Reset", "NO"));
		tableAttributes.add(new TableAttribute("Restart", "NO"));
		tableAttributes.add(new TableAttribute("Tracing Level", "Normal"));
		tableAttributes.add(new TableAttribute("Is Partitionable", "NO"));
		nrm.setTableAttributeList(tableAttributes);
		mapping.addTransformation(nrm);
		mapping.addInstance( new Instance(name,name, InstanceType.NORMALIZER.getInstanceType(), BoxType.TRANSFORMATION, false));
		return nrm;
	}
	
	public Transformation updateStrategy(String name, 
			List<TransformField> transformFieldList, List<TableAttribute> tableAttributeList) {
		return addTransformation(name, name, InstanceType.UPDATE_STRATEGY, name, transformFieldList, tableAttributeList);
	}
	
	public Transformation updateStrategy(Transformation from, String name, String strategy, FieldSet fields, String... exceptNames) {
		Set<String> exceptSet = new HashSet<String>();
		for ( String ename : exceptNames ) {
			exceptSet.add(ename);
		}
		ArrayList<TableAttribute> attributes = new ArrayList<TableAttribute>();
		attributes.add( new TableAttribute( "Update Strategy Expression", strategy));
		attributes.add( new TableAttribute("Forward Rejected Rows", "YES"));
		attributes.add( new TableAttribute( "Tracing Level", "Normal"));
		
		ArrayList<TransformField> outFields = new ArrayList<TransformField>(fields.getFieldList());
		ArrayList<TransformField> removeIndices = new ArrayList<TransformField>();
		for( TransformField field : outFields ) {
			field.setPortType(PortType.INPUT_OUTPUT);
			if( exceptSet.contains(field.getName()) )
				removeIndices.add(field);
		}
		outFields.removeAll(removeIndices);
		FieldSet conn = new FieldSet( outFields );
		Transformation to =  addTransformation(name, name, InstanceType.UPDATE_STRATEGY, name, outFields, attributes);
		connect( from, to, conn );
		return to;
	}	
	
	public Transformation updateStrategy(Transformation from, String name, String strategy, Map<String, String > connections) {
		ArrayList<TransformField> fields = new ArrayList<TransformField>();
		TransformField field;
		for( Entry<String,String> conn : connections.entrySet() ){
			field = from.getTransformField(conn.getKey());
			fields.add(new TransformField( conn.getValue(), field.getDataType(), field.getPrecision(),field.getScale(), PortType.INPUT_OUTPUT ));
		}
		ArrayList<TableAttribute> attributes = new ArrayList<TableAttribute>();
		attributes.add( new TableAttribute( "Update Strategy Expression", strategy));
		attributes.add( new TableAttribute("Forward Rejected Rows", "YES"));
		attributes.add( new TableAttribute( "Tracing Level", "Normal"));
		Transformation upd =  addTransformation(name, name, InstanceType.UPDATE_STRATEGY, name, fields, attributes);
		connect(from, upd, connections);
		return upd;
	}

	/**
	 * 
	 * @param name
	 * @param description 
	 * @param transformFieldList
	 * @param tableAttributeList
	 * @return
	 */
	public Transformation sorter(String name, String description, List<TransformField> transformFieldList, List<TableAttribute> tableAttributeList) {	
		return addTransformation(name, description, InstanceType.SORTER, null, transformFieldList, tableAttributeList);
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param instanceType 
	 * @param sourceInstanceName 
	 * @param transformFieldList
	 * @param tableAttributeList
	 * @return
	 */
	public Transformation addTransformation(String name, String description, InstanceType instanceType, String sourceInstanceName, 
			List<TransformField> transformFieldList, List<TableAttribute> tableAttributeList) {
		Transformation tran = new Transformation(name, description, instanceType);
		tran.setReusable(false);
		tran.setTransformFieldList(transformFieldList);
		tran.setTableAttributeList(tableAttributeList);
		mapping.addTransformation(tran);
		
		Instance instance = new Instance(name, name, instanceType.getInstanceType(), BoxType.TRANSFORMATION);
		if ( sourceInstanceName != null ) {
			instance.addAssociatedSourceInstance(new AssociatedSourceInstance(sourceInstanceName) );
		}
		mapping.addInstance(instance);
		return tran;
	}
	
	public void addTransformation( Transformation tran ){
		mapping.addTransformation(tran);
		Instance instance = new Instance(tran.getName(), tran.getName(), tran.getInstanceType(), BoxType.TRANSFORMATION);
		mapping.addInstance(instance);
	}

	public List<TransformField> toTransformFieldList(List<TransformField> transformFieldList) {
		return toTransformFieldList(transformFieldList, (TransformFieldCallback) null);
	}
	
	/**
	 * Utility method to convert generic field lists into concrete ones
	 * @param transformFieldList
	 * @param callback 
	 * @param resolver 
	 * @return
	 */
	public List<TransformField> toTransformFieldList(List<TransformField> transformFieldList,  TransformFieldCallback callback ) {
		List<TransformField> fieldList = new ArrayList<TransformField>();
		for ( TransformField f : transformFieldList ) {
			TransformField field = new TransformField(f);
			DataTypeResolver.toInformaticaType(field);
			if ( callback != null ) {
				if ( callback.add(field) ) {
					fieldList.add(field);
				}
			} else {
				fieldList.add(field);
			}
		}
		return fieldList;
	}
	
	/**
	 * Utility method to convert generic field lists into concrete ones
	 * @param transformFieldList
	 * @param fromToFieldMap 
	 * @param resolver 
	 * @return
	 */
	public List<TransformField> toTransformFieldList(List<TransformField> transformFieldList, Map<String, String> fromToFieldMap) {
		List<TransformField> fieldList = new ArrayList<TransformField>();
		for ( TransformField f : transformFieldList ) {
			TransformField field = new TransformField(f);
			String toName = fromToFieldMap.get(field.getName());
			if ( toName != null ) {
				field.setName(toName);
			}
			DataTypeResolver.toInformaticaType(field);
			fieldList.add(field);
		}
		return fieldList;
	}
	
	/**
	 * Utility method to convert generic field lists into concrete ones
	 * @param transformFieldList
	 * @param prefix 
	 * @param resolver 
	 * @return
	 */
	public List<TransformField> toTransformFieldList(List<TransformField> transformFieldList, String prefix) {
		
		List<TransformField> fieldList = new ArrayList<TransformField>();
		for ( TransformField f : transformFieldList ) {
			TransformField field = new TransformField(f);			
			field.setName( prefix + field.getName() );
			DataTypeResolver.toInformaticaType(field);
			fieldList.add(field);
		}
		return fieldList;
	}
	
	/**
	 * Associates the given source with the mapping
	 * @param source
	 */
	public void addSource( Source source, TableAttribute... attr ) {
		Instance instance = new Instance(source.getName(), 
				source.getName(), InstanceType.SOURCE_DEFINITION.getInstanceType(), BoxType.SOURCE);
		instance.setDbdName(source.getDbdName());
		for( int i = 0; i < attr.length; i ++ ){
			instance.addTableAttribute(attr[i]);
			source.addTableAttribute(attr[i]);
		}
		folder.addSource( source );
		mapping.addInstance(instance);
	}
		
	public void addTarget( Target target ) {
		addTarget( target, null );
	}
	
	public void addTarget( Target target, List<TableAttribute> tableAttributeList ) {
		Instance instance = new Instance(target.getName(), target.getName(), InstanceType.TARGET_DEFINITION.getInstanceType(), BoxType.TARGET);
		instance.setTableAttributeList(tableAttributeList);
		folder.addTarget(target);
	}
	

	public Instance addSourceInstance(String name, String transformationName) {
		Instance inst = new Instance(name, transformationName,"Source Definition",BoxType.SOURCE);
		mapping.addInstance(inst);
		return inst;
	}
	
	public Source getSource( Target target, String dbdName ) {
		Source source = new Source( target.getName() );
		source.setDatabaseType(target.getDatabaseType());
		source.setDbdName(dbdName);
		for ( TargetField field : target.getTargetFieldList() ) {
			SourceField sf = new SourceField( field.getName(), field.getDataType(), field.getPrecision(), field.getScale() );			
			source.addSourceField(sf);
		}	
		return source;
	}
	/**
	 * Connects the from box to the to box by map of field names, creating new ports on the target box
	 * @param from
	 * @param to
	 * @param list
	 */
	public void connectAddNewPorts( Transformation from, Transformation to, List<TransformField> fields ) {
		FieldSet connections = new FieldSet();
		for( TransformField field : fields ){
			TransformField addFld = new TransformField(field);
			addFld.setPortType(PortType.INPUT_OUTPUT);
			to.addTransformField( addFld );
			connections.addField(addFld);
		}
		connect(from,to,connections);
	}
	public void connectAddNewPorts(Transformation from,Transformation to,
			LinkedHashMap<String, String> connections) {
		for( Entry<String,String> entry :connections.entrySet() ){
			to.addTransformField(new TransformField( from.getTransformField(entry.getKey()) ));
		}
		connect(from,to,connections);
	}

	/**
	 * Connects the from box to the to box by field name, and skips over the from fields
	 * defined in the exceptNames list
	 * @param from
	 * @param to
	 * @param exceptNames
	 */
	public void connectByName( Box from, Box to, String... exceptNames ) {
		Set<String> toFieldSet = new HashSet<String>();
		for ( Field field : to.getInputPorts() ) {
			toFieldSet.add(field.getName());
		}
		Set<String> exceptSet = new HashSet<String>();
		for ( String name : exceptNames ) {
			exceptSet.add(name);
		}
		for ( Field field : from.getOutputPorts() ) {
			if ( toFieldSet.contains(field.getName()) && !exceptSet.contains(field.getName())) {
				Connector c = new Connector(field.getName(), from.getName(), from.getInstanceType(),
						field.getName(), to.getName(), to.getInstanceType() );
				mapping.addConnector(c);			
			}
		}
	}
	
	/**
	 * Connects the from box to the to box by field name, and skips over the from fields
	 * defined in the exceptNames list
	 * @param from
	 * @param to
	 * @param exceptNames
	 */
	public void connectByName( Box from, Instance to, String... exceptNames ) {
		Set<String> exceptSet = new HashSet<String>();
		for ( String name : exceptNames ) {
			exceptSet.add(name);
		}
		for ( Field field : from.getOutputPorts() ) {
			if ( !exceptSet.contains(field.getName())) {
				Connector c = new Connector(field.getName(), from.getName(), from.getInstanceType(),
						field.getName(), to.getName(), to.getInstanceType() );
				mapping.addConnector(c);			
			}
		}
	}
	
	public Transformation connectNewTransformation( Box from, String name, InstanceType type, String... exceptNames) {
		Transformation newTransformation = new Transformation(name, "", type);
		
		for ( Field sField : from.getOutputPorts() ) {
			newTransformation.addTransformField( new TransformField( sField.getName(), sField.getDataType(), 
					sField.getPrecision(), sField.getScale(), PortType.INPUT_OUTPUT));
		}
		
		newTransformation.setReusable(false);
		Instance instance = new Instance( name, name, type.getInstanceType(), BoxType.TRANSFORMATION);
		mapping.addInstance(instance);
		mapping.addTransformation(newTransformation);
		this.connectByName(from, newTransformation );
		return newTransformation;
	}

	public Transformation connectNewTransformation( Box from, String name, InstanceType type, Map<String, String> connections) {
		Transformation newTransformation = new Transformation(name, "", type);
		
		for ( Field sField : from.getOutputPorts() ) {
			String key = sField.getName();
			if( connections.containsKey(key))
			newTransformation.addTransformField( new TransformField( connections.get(key), sField.getDataType(), 
					sField.getPrecision(), sField.getScale(), PortType.INPUT_OUTPUT));
		}
		
		newTransformation.setReusable(false);
		Instance instance = new Instance( name, name, type.getInstanceType(), BoxType.TRANSFORMATION);
		mapping.addInstance(instance);
		mapping.addTransformation(newTransformation);
		this.connect(from, newTransformation, connections );
		return newTransformation;
	}
	
	public Transformation connectNewTransformation(Transformation from,
			String name, InstanceType expression, FieldSet fields) {
		Transformation tran = new Transformation(name, "", expression);
		tran.addTransformFields(fields.getFieldList());
		mapping.addInstance(new Instance(name, name, tran.getInstanceType(), BoxType.TRANSFORMATION));
		mapping.addTransformation(tran);
		connect(from,tran,fields);
		return tran;
	}

	public Transformation connectNewSQ( Source from, String name, String... exceptNames) {
		Transformation newSQ = new Transformation(name, "", InstanceType.SOURCE_QUALIFIER);
		
		for ( Field sField : from.getOutputPorts() ) {
			String dataType = sField.getDataType();
			if( dataType.equals("VARCHAR2"))
				dataType = new String("string");
			else if( dataType.equals("NUMBER"))
				dataType = new String("double");
			else if( dataType.equals("DATE"))
				dataType = new String("date/time");
			TransformField field = new TransformField( sField.getName(), dataType, 
					sField.getPrecision(), 0, PortType.INPUT_OUTPUT);
			field.setDefaultValue("");
			field.setDescription("");
			field.setPictureText("");
			
			newSQ.addTransformField( field );
		}
		newSQ.setReusable(false);
		newSQ.setVersionNumber("1");
		
		ArrayList<TableAttribute> attributes = new ArrayList<TableAttribute>();
		
		attributes.add( new TableAttribute("Sql Query", ""));
		attributes.add( new TableAttribute("User Defined Join", ""));
		attributes.add( new TableAttribute("Source Filter", ""));
		attributes.add( new TableAttribute("Number Of Sorted Ports", "0"));
		attributes.add( new TableAttribute("Tracing Level", "NORMAL"));
		attributes.add( new TableAttribute("Select Distinct", "NO"));
		attributes.add( new TableAttribute("Is Partitionable", "NO"));
		attributes.add( new TableAttribute("Pre SQL", ""));
		attributes.add( new TableAttribute("Post SQL", ""));
		attributes.add( new TableAttribute("Output is deterministic", "NO"));
		attributes.add( new TableAttribute("Output is repeatable", "Never"));
		newSQ.setTableAttributeList(attributes);
		
		mapping.addTransformation(newSQ);
		Instance instance = new Instance( name, name, InstanceType.SOURCE_QUALIFIER.getInstanceType(), BoxType.TRANSFORMATION);
		AssociatedSourceInstance aInstance = new AssociatedSourceInstance(name.substring(3));
		instance.addAssociatedSourceInstance(aInstance);
		mapping.addInstance(instance);
		this.connectByName(from, newSQ );
		return newSQ;
	}
	
	/**
	 * Connects the from box to the to box by field name, and skips over the from fields
	 * defined in the exceptNames list
	 * @param from
	 * @param to
	 * @param fromToFieldNameMap
	 */
	public void connect( Box from, Box to, Map<String, String> fromToFieldNameMap ) {
		for ( Map.Entry<String, String> entry : fromToFieldNameMap.entrySet() ) {			
			Connector c = new Connector(entry.getKey(), from.getName(), from.getInstanceType(),
					entry.getValue(), to.getName(), to.getInstanceType() );
			mapping.addConnector(c);			
		}
	}

	/**
	 * Connects the from box to the to box by field name, and skips over the from fields
	 * defined in the exceptNames list
	 * @param from
	 * @param to
	 * @param fieldNames 
	 * @param fromToFieldNameMap
	 */
	public void connect( Box from, Box to, String... fieldNames ) {
		for ( String name : fieldNames ) {			
			Connector c = new Connector(name, from.getName(), from.getInstanceType(),
					name, to.getName(), to.getInstanceType() );
			mapping.addConnector(c);			
		}
	}
	
	/**
	 * Connects the from box to the to box by field name, and skips over the from fields
	 * defined in the exceptNames list
	 * @param from
	 * @param to
	 * @param fromName 
	 * @param toName 
	 * @param fromToFieldNameMap
	 */
	public void connect( Box from, Box to, String fromName, String toName ) {			
		Connector c = new Connector(fromName, from.getName(), from.getInstanceType(),
				toName, to.getName(), to.getInstanceType() );
		mapping.addConnector(c);			
	}
	
	/**
	 * For manual connection, using the box names and field names.  Created mainly for the 
	 * use of EXTRACT DT TM
	 */
	public void createConnector(String fromBoxName, String toBoxName, String fromField,
			String toField) {
		Connector c = new Connector( fromField, fromBoxName, "Expression", toField, toBoxName, "Expression");
		mapping.addConnector(c);
		
	}

	/**
	 * wrapper for instance
	 * @param instance
	 */
	public void addInstance(Instance instance) {
		this.getMapping().addInstance(instance);
		
	}

	/**
	 * connect 2 boxes for the fieldset
	 * @param from
	 * @param to
	 * @param fieldSet
	 */
	public void connect(Box from,
			Box to, FieldSet fieldSet) {
		for(int i=0; i<fieldSet.size(); i++ )
			connect(from, to, fieldSet.get(i).getName());
	}
	
	/**
	 * connect 2 boxes with two lists of specific fieldsets who's indices match up
	 * @param from
	 * @param to
	 * @param fromFields
	 * @param toFields
	 */
	public void connect(Box from,
			Box to, FieldSet fromFields,
			FieldSet toFields) {
		
		for (int i=0; i<fromFields.size(); i++)
			connect(from, to, fromFields.get(i).getName(), toFields.get(i).getName());
		
	}
	
	

	/**
	 * connector that takes an output set from a router and
	 * connects it to another field, automatically truncating
	 * any added integers
	 * @param from
	 * @param to
	 * @param rtrOutSet
	 */
	public void rtrConnect(Box from,
			Box to, FieldSet rtrOutSet) {
		for(int i =0; i<rtrOutSet.size(); i++){
			String name = rtrOutSet.get(i).getName();
			connect(from,to, name, name.substring(0, name.length()-1));
		}
		
	}

	/**
	 * connector that takes an output set from a router and
	 * connects it to another field, automatically truncating
	 * any added integers
	 * @param from
	 * @param to
	 * @param rtrOutSet
	 */
	public void rtrConnectBack(Box from,
			Box to, FieldSet afterInSet, String number) {
		for(int i =0; i<afterInSet.size(); i++){
			String name = afterInSet.get(i).getName();
			connect(from,to, name + number, name);
		}
	}

	/**
	 * creates a source with a table name, type, db name, and set of fields
	 * @param tableName
	 * @param dbType
	 * @param dbdName
	 * @param srcFieldSet
	 * @return
	 */
	public Source source(String tableName, String dbType, String dbdName,
			FieldSet srcFieldSet) {
		Source src = new Source("SRC_" + tableName);
		src.setDatabaseType(dbType);
		src.setDbdName(dbdName);
		for(int i=0; i< srcFieldSet.size();i++)
			src.addSourceField(srcFieldSet.get(i).toSourceField());
		addSource(src);
		return src;
	}
	
	/**
	 * creates the standard set of mapping variables
	 * TODO: correct this, mappings are not created with all of the correct parameters
	 * @param mappingName
	 */
	public void setLHStandardMappingVars(String mappingName, String fileType){
		mapping.addMappingVariable(new MappingVariable("$$UPDT_USER","40","Informatica"));
		mapping.addMappingVariable(new MappingVariable("$$UPDT_TASK","40",mappingName));
		mapping.addMappingVariable(new MappingVariable("$$RUN_TYPE","10",""));
		mapping.addMappingVariable(new MappingVariable("$$FILE_TYPE","10",fileType));
		mapping.addMappingVariable(new MappingVariable("$$UPDT_SOURCE_i","50",mappingName +"_i"));
		mapping.addMappingVariable(new MappingVariable("$$UPDT_SOURCE_u","50",mappingName +"_u"));
	}

	/**
	 * creates the standard set of mapping variables
	 * TODO: correct this, mappings are not created with all of the correct parameters
	 * @param mappingName
	 */
	public void setStandardMappingVars(String fileType, String tableName){
		mapping.addMappingVariable(new MappingVariable("$$UPDT_USER","40","Informatica"));
		mapping.addMappingVariable(new MappingVariable("$$UPDT_TASK","40",fileType + " CLN"));
		mapping.addMappingVariable(new MappingVariable("$$RUN_TYPE","10",""));
		mapping.addMappingVariable(new MappingVariable("$$FILE_TYPE","10",fileType));
		mapping.addMappingVariable(new MappingVariable("$$LKP_PARENT_ENTITY_NAME","30","'"+tableName+"'"));
		mapping.addMappingVariable(new MappingVariable("$$FILE_NAME","30",tableName));
	}
	
	/**
	 * creates source qualifier automatically from table name
	 */
	public void createSourceQualifier() {
		String sqName = "SQ_" + tableName;
		sourceQualifier(sqName, sqName, sqName, nameDbMgr.getSQFieldSet().getFieldList(), new ArrayList<TableAttribute>());
		
	}

	/**
	 * creates the standard expression transformation that checks for null keys
	 */
	public void nullIndicatorExpressionTransformation() {
		String nullIndTransformationName = "EXP_Null_Ind";
		
		FieldSet nullIndFieldSet = new FieldSet();
		nullIndFieldSet.addExpressionUpdateFields();
		//nullIndFieldSet.setFieldsPortType(PortType.OUTPUT);
		
		List<TableAttribute> tableAttributeList = new ArrayList<TableAttribute>();
		addTransformation(nullIndTransformationName, nullIndTransformationName, InstanceType.EXPRESSION, "", nullIndFieldSet.getFieldList(), tableAttributeList);
		
	}

	public Source get(String name) {
		for( Source source : folder.getSourceList() ) {
			if( source.getName().equals(name)) {
				return source;
			}
		}
		return null;
	}

}
