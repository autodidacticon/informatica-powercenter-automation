package net.orangemile.informatica.powercenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.orangemile.informatica.powercenter.domain.*;
import net.orangemile.informatica.powercenter.domain.constant.*;

public class InformaticaSupport {

	private Mapping mapping;
	private Folder folder;
	
	public InformaticaSupport( Mapping mapping, Folder folder ) {
		this.mapping = mapping;
		this.folder = folder;
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


	public List<TransformField> toTransformFieldList(List<? extends Field> transformFieldList) {
		return toTransformFieldList(transformFieldList, (TransformFieldCallback) null);
	}
	
	/**
	 * Utility method to convert generic field lists into concrete ones
	 * @param transformFieldList
	 * @param callback 
	 * @param resolver 
	 * @return
	 */
	public List<TransformField> toTransformFieldList(List<? extends Field> transformFieldList,  TransformFieldCallback callback ) {
		List<TransformField> fieldList = new ArrayList<TransformField>();
		for ( Field f : transformFieldList ) {
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
	public List<TransformField> toTransformFieldList(List<? extends Field> transformFieldList, Map<String, String> fromToFieldMap) {
		List<TransformField> fieldList = new ArrayList<TransformField>();
		for ( Field f : transformFieldList ) {
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
	public List<TransformField> toTransformFieldList(List<? extends Field> transformFieldList, String prefix) {
		List<TransformField> fieldList = new ArrayList<TransformField>();
		for ( Field f : transformFieldList ) {
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
	public void addSource( Source source ) {
		Instance instance = new Instance(source.getName(), 
				source.getName(), InstanceType.SOURCE_DEFINITION.getInstanceType(), BoxType.SOURCE);
		instance.setDbdName(source.getDbdName());		
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
		mapping.addInstance(instance);
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
}
