package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.List;

import net.orangemile.informatica.powercenter.domain.constant.InstanceType;

import net.orangemile.informatica.powercenter.domain.constant.PortType;

public class Transformation implements Box, Cloneable {
		
	private String name;
	private String description;
	private String type;
	private String objectVersion;
	private Boolean reusable;
	private String isVsamNormalizer;
	private String refSourceName;
	private String refDbdName;
	private String templateId;
	private String templateName;
	private String parent;
	private ParentType parentType;
	private String versionNumber;
	private String crcValue;
	
	private List<Group> groupList;
	private List<SourceField> sourceFieldList;
	private List<TransformField> transformFieldList;
	private List<TableAttribute> tableAttributeList;
	private List<InitProp> initPropList;
	private List<MetaDataExtension> metaDataExtensionList;
	private List<TransformFieldAttrDef> transformFieldAttrDefList;
	private List<FieldDependency> fieldDependencyList;
	
	private FlatFile flatFileList;

	public Transformation() {}
	
	public Transformation( String name, String description, InstanceType type ) {
		this.name = name;
		this.description = description;
		this.type = type.getInstanceType();
	}
	
	public List<TransformField> getInputPorts() {
		ArrayList<TransformField> fields = new ArrayList<TransformField>();
		for ( TransformField field : transformFieldList ) {
			if ( PortType.isInputPort(field.getPortType()) ) {
				fields.add( field );
			}
		}
		return fields;
	}

	public List<TransformField> getOutputPorts() {
		ArrayList<TransformField> fields = new ArrayList<TransformField>();
		for ( TransformField field : transformFieldList ) {
			if ( PortType.isOutputPort(field.getPortType()) ) {
				fields.add( field );
			}
		}
		return fields;	
	}

	public String getCrcValue() {
		return crcValue;
	}

	public void setCrcValue(String crcValue) {
		this.crcValue = crcValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FieldDependency> getFieldDependencyList() {
		return fieldDependencyList;
	}

	public void setFieldDependencyList(ArrayList<FieldDependency> fieldDependencyList) {
		this.fieldDependencyList = fieldDependencyList;
	}

	public FlatFile getFlatFileList() {
		return flatFileList;
	}

	public void setFlatFileList(FlatFile flatFileList) {
		this.flatFileList = flatFileList;
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(ArrayList<Group> groupList) {
		this.groupList = groupList;
	}

	public List<InitProp> getInitPropList() {
		return initPropList;
	}

	public void setInitPropList(ArrayList<InitProp> initPropList) {
		this.initPropList = initPropList;
	}

	public String getIsVsamNormalizer() {
		return isVsamNormalizer;
	}

	public void setIsVsamNormalizer(String isVsamNormalizer) {
		this.isVsamNormalizer = isVsamNormalizer;
	}

	public List<MetaDataExtension> getMetaDataExtensionList() {
		return metaDataExtensionList;
	}

	public void setMetaDataExtensionList(ArrayList<MetaDataExtension> metaDataExtensionList) {
		this.metaDataExtensionList = metaDataExtensionList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjectVersion() {
		return objectVersion;
	}

	public void setObjectVersion(String objectVersion) {
		this.objectVersion = objectVersion;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public ParentType getParentType() {
		return parentType;
	}

	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	}

	public String getRefDbdName() {
		return refDbdName;
	}

	public void setRefDbdName(String refDbdName) {
		this.refDbdName = refDbdName;
	}

	public String getRefSourceName() {
		return refSourceName;
	}

	public void setRefSourceName(String refSourceName) {
		this.refSourceName = refSourceName;
	}

	public Boolean isReusable() {
		return reusable;
	}

	public void setReusable(Boolean reusable) {
		this.reusable = reusable;
	}

	public List<SourceField> getSourceFieldList() {
		return sourceFieldList;
	}

	public void setSourceFieldList(List<SourceField> sourceFieldList) {
		this.sourceFieldList = sourceFieldList;
	}

	public List<TableAttribute> getTableAttributeList() {
		return tableAttributeList;
	}

	public void setTableAttributeList(List<TableAttribute> tableAttributeList) {
		this.tableAttributeList = tableAttributeList;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public List<TransformFieldAttrDef> getTransformFieldAttrDefList() {
		return transformFieldAttrDefList;
	}

	public void setTransformFieldAttrDefList(ArrayList<TransformFieldAttrDef> transformFieldAttrDefList) {
		this.transformFieldAttrDefList = transformFieldAttrDefList;
	}

	public List<TransformField> getTransformFieldList() {
		return transformFieldList;
	}

	public void setTransformFieldList(List<TransformField> transformFieldList) {
		this.transformFieldList = transformFieldList;
	}

	public void addTransformField( TransformField transformField ) {
		if ( transformFieldList == null ) {
			transformFieldList = new ArrayList<TransformField>();
		}
		transformFieldList.add( transformField );
	}
	
	public void addTransformFields( List<TransformField> transformFields ){
		if ( transformFieldList == null ) {
			transformFieldList = new ArrayList<TransformField>();
		}
		for( TransformField field : transformFields ) {
			transformFieldList.add(field);
		}
	}
	/**
	 * Adds the given transform field after the given field
	 * @param transformField
	 * @param afterFieldName
	 */
	public void addTransformField( TransformField transformField, String afterFieldName ) {
		if ( transformFieldList == null ) {
			throw new RuntimeException("TransformFieldList is null");
		}
		for ( int i=0;i<transformFieldList.size();i++) {
			if ( transformFieldList.get(i).getName().equalsIgnoreCase(afterFieldName) ) {
				transformFieldList.add(i + 1, transformField);
				return;
			}
		}
		throw new RuntimeException("Field not found - " + afterFieldName );
	}
	
	public TransformField getTransformField( String name ) {
		for ( TransformField field : transformFieldList ) {
			if ( field.getName().equalsIgnoreCase(name) ) {
				return field;
			}
		}
		return null;
	}
	
	public String getInstanceType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	
	public enum ParentType {
		MAPPING, 
		MAPPLET
	}	
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}	
	
	/****************************************
	 * Utility Methods
	 ****************************************/

	/**
	 * Returns the associated table attribute
	 * @param key 
	 * @return 
	 */
	public TableAttribute getTableAttribute( String key ) {
		for ( TableAttribute ta : tableAttributeList ) {
			if ( ta.getName().equalsIgnoreCase(key) ) {
				return ta;
			}
		}
		return null;
	}
}
