package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.List;

import net.orangemile.informatica.powercenter.domain.constant.InstanceType;

public class Source implements Box, Cloneable {

	private String name;
	private String dbdName;
	private String businessName;
	private String description;
	private String objectVersion;
	private String ownerName;
	private String ibmComp;
	private String databaseType;
	private String databaseSubType;
	private String versionNumber;
	private String crcValue;
	
	private FlatFile flatFile;
	
	private ArrayList<Group> groupList;
	private ArrayList<TableAttribute> tableAttributeList;
	private ArrayList<SourceField> sourceFieldList;
	private ArrayList<MetaDataExtension> metaDataExtensionList;
	
	public Source() {}
	
	public Source( String name ) {
		this.name = name;
	}

	public List<? extends Field> getInputPorts() {
		return new ArrayList<SourceField>();
	}

	public List<? extends Field> getOutputPorts() {
		return sourceFieldList;
	}

	public String getInstanceType() {
		return InstanceType.SOURCE_DEFINITION.getInstanceType();
	}
	
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getCrcValue() {
		return crcValue;
	}
	public void setCrcValue(String crcValue) {
		this.crcValue = crcValue;
	}
	public String getDatabaseSubType() {
		return databaseSubType;
	}
	public void setDatabaseSubType(String databaseSubType) {
		this.databaseSubType = databaseSubType;
	}
	public String getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	public String getDbdName() {
		return dbdName;
	}
	public void setDbdName(String dbdName) {
		this.dbdName = dbdName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIbmComp() {
		return ibmComp;
	}
	public void setIbmComp(String ibmComp) {
		this.ibmComp = ibmComp;
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
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public FlatFile getFlatFile() {
		return flatFile;
	}
	public void setFlatFile(FlatFile flatFile) {
		this.flatFile = flatFile;
	}
	public ArrayList<Group> getGroupList() {
		return groupList;
	}
	public void setGroupList(ArrayList<Group> groupList) {
		this.groupList = groupList;
	}
	public ArrayList<MetaDataExtension> getMetaDataExtensionList() {
		return metaDataExtensionList;
	}
	public void setMetaDataExtensionList(ArrayList<MetaDataExtension> metaDataExtensionList) {
		this.metaDataExtensionList = metaDataExtensionList;
	}
	public ArrayList<SourceField> getSourceFieldList() {
		return sourceFieldList;
	}
	public void setSourceFieldList(ArrayList<SourceField> sourceFieldList) {
		this.sourceFieldList = sourceFieldList;
	}
	public ArrayList<TableAttribute> getTableAttributeList() {
		return tableAttributeList;
	}
	public void setTableAttributeList(ArrayList<TableAttribute> tableAttributeList) {
		this.tableAttributeList = tableAttributeList;
	}	
	
	public void addGroup( Group group ) {
		if ( groupList == null ) {
			groupList = new ArrayList<Group>();
		}
		groupList.add( group );
	}
	
	public void addTableAttribute( TableAttribute tableAttribute ) {
		if ( tableAttributeList == null ) {
			tableAttributeList = new ArrayList<TableAttribute>();
		}
		tableAttributeList.add(tableAttribute);
	}
	
	public void addSourceField( SourceField sourceField ) {
		if ( sourceFieldList == null ) {
			sourceFieldList = new ArrayList<SourceField>();
		}
		sourceFieldList.add( sourceField );
	} 
	
	public SourceField getSourceField( String name ) {
		if ( sourceFieldList == null ) {
			return null;
		}
		for ( SourceField sf : sourceFieldList ) {
			if ( sf.getName().equalsIgnoreCase(name)) {
				return sf;
			}
		}
		return null;
	}

	/**
	 * Adds the given source field after the specified field name
	 * @param sourceField
	 * @param afterSourceFieldName
	 */
	public void addSourceField( SourceField sourceField, String afterSourceFieldName ) {
		if ( sourceFieldList == null ) {
			throw new RuntimeException("SourceFieldList is null");
		}
		for ( int i=0;i<sourceFieldList.size();i++) {
			if ( sourceFieldList.get(i).getName().equalsIgnoreCase(afterSourceFieldName) ) {
				sourceFieldList.add(i + 1, sourceField );
				return;
			}
		}
		throw new RuntimeException("Source Field " + afterSourceFieldName + " not found!");
	} 

	
	public void addMetaDataExtension(MetaDataExtension metaDataExtension) {
		if ( metaDataExtensionList == null ) {
			metaDataExtensionList = new ArrayList<MetaDataExtension>();
		}
		metaDataExtensionList.add( metaDataExtension );
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}	
	
	@Override
	public String toString() {
		return "[" + name + "]";
	}
}
