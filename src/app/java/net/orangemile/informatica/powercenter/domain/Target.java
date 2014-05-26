package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.List;

import net.orangemile.informatica.powercenter.domain.constant.InstanceType;

public class Target implements Box, Cloneable {

	private String name;
	private String businessName;
	private String description;
	private String objectVersion;
	private String constraint;
	private String tableOptions;
	private String tableType;
	private String databaseType;
	private String versionNumber;
	private String crcValue;

	private FlatFile flatFile;
	private XMLInfo xmlInfo;
	
	private ArrayList<Keyword> keywordList;
	private ArrayList<Group> groupList;
	private ArrayList<TargetField> targetFieldList;
	private ArrayList<TargetIndex> targetIndexList;
	private ArrayList<TableAttribute> tableAttributeList;
	private ArrayList<MetaDataExtension> metaDataExtensionList;

	public Target() {}
	
	public Target( String name ) {
		this.name = name;
	}
	
	public List<? extends Field> getInputPorts() {
		return targetFieldList;
	}
	public List<? extends Field> getOutputPorts() {
		return new ArrayList<TargetField>();
	}
	public String getInstanceType() {
		return InstanceType.TARGET_DEFINITION.getInstanceType();
	}

	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getConstraint() {
		return constraint;
	}
	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}
	public String getCrcValue() {
		return crcValue;
	}
	public void setCrcValue(String crcValue) {
		this.crcValue = crcValue;
	}
	public String getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getTableOptions() {
		return tableOptions;
	}
	public void setTableOptions(String tableOptions) {
		this.tableOptions = tableOptions;
	}
	public String getTableType() {
		return tableType;
	}
	public void setTableType(String tableType) {
		this.tableType = tableType;
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
	public ArrayList<Keyword> getKeywordList() {
		return keywordList;
	}
	public void setKeywordList(ArrayList<Keyword> keywordList) {
		this.keywordList = keywordList;
	}
	public ArrayList<MetaDataExtension> getMetaDataExtensionList() {
		return metaDataExtensionList;
	}
	public void setMetaDataExtensionList(ArrayList<MetaDataExtension> metaDataExtensionList) {
		this.metaDataExtensionList = metaDataExtensionList;
	}
	public ArrayList<TableAttribute> getTableAttributeList() {
		return tableAttributeList;
	}
	public void setTableAttributeList(ArrayList<TableAttribute> tableAttributeList) {
		this.tableAttributeList = tableAttributeList;
	}
	public ArrayList<TargetField> getTargetFieldList() {
		return targetFieldList;
	}
	public void setTargetFieldList(ArrayList<TargetField> targetFieldList) {
		this.targetFieldList = targetFieldList;
	}
	public ArrayList<TargetIndex> getTargetIndexList() {
		return targetIndexList;
	}
	public void setTargetIndexList(ArrayList<TargetIndex> targetIndexList) {
		this.targetIndexList = targetIndexList;
	}
	public XMLInfo getXmlInfo() {
		return xmlInfo;
	}
	public void setXmlInfo(XMLInfo xmlInfo) {
		this.xmlInfo = xmlInfo;
	}

	public void addKeyword( Keyword keyword ) {
		if ( keywordList == null ) {
			keywordList = new ArrayList<Keyword>();
		}
		keywordList.add( keyword );
	}

	public void addGroup( Group group ) {
		if ( groupList == null ) {
			groupList = new ArrayList<Group>();
		}
		groupList.add( group );
	}

	public void addTargetField( TargetField targetField ) {
		if ( targetFieldList == null ) {
			targetFieldList = new ArrayList<TargetField>();
		}
		targetFieldList.add( targetField );
	}

	/**
	 * Adds the given field after the supplied target field name
	 * @param targetField
	 * @param targetFieldName
	 */
	public void addTargetField( TargetField targetField, String targetFieldName ) {
		if ( targetFieldList == null ) {
			throw new RuntimeException("TargetFieldList is null");
		}
		for ( int i=0;i<targetFieldList.size();i++) {
			System.out.println( targetFieldList.get(i).getName());
			if ( targetFieldList.get(i).getName().equalsIgnoreCase(targetFieldName)) {
				targetFieldList.add(i+1,targetField);
				return;
			}
		}
		throw new RuntimeException("Target Field " + targetFieldName + " was not found");
	}
	
	public void addTargetIndex( TargetIndex targetIndex ) {
		if ( targetIndexList == null ) {
			targetIndexList = new ArrayList<TargetIndex>();
		}
		targetIndexList.add( targetIndex );
	}

	public void addTableAttribute( TableAttribute tableAttribute ) {
		if ( tableAttributeList == null ) {
			tableAttributeList = new ArrayList<TableAttribute>();
		}
		tableAttributeList.add( tableAttribute );
	}

	public void addMetaDataExtension( MetaDataExtension metaDataExtension ) {
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
}
