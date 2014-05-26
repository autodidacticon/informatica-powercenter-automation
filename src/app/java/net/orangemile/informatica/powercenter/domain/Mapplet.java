package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

public class Mapplet implements Cloneable {

	private String name;
	private String description;
	private String objectVersion;
	private String isValid;
	private String versionNumber;
	private String crcValue;
	
	private ArrayList<Transformation> transformationList;
	private ArrayList<Instance> instanceList;
	private ArrayList<Connector> connectorList;
	private ArrayList<MappingVariable> mappingVariableList;
	private ArrayList<MetaDataExtension> metaDataExtensionList;
	
	public ArrayList<Connector> getConnectorList() {
		return connectorList;
	}
	public void setConnectorList(ArrayList<Connector> connectorList) {
		this.connectorList = connectorList;
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
	public ArrayList<Instance> getInstanceList() {
		return instanceList;
	}
	public void setInstanceList(ArrayList<Instance> instanceList) {
		this.instanceList = instanceList;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public ArrayList<MappingVariable> getMappingVariableList() {
		return mappingVariableList;
	}
	public void setMappingVariableList(ArrayList<MappingVariable> mappingVariableList) {
		this.mappingVariableList = mappingVariableList;
	}
	public ArrayList<MetaDataExtension> getMetaDataExtensionList() {
		return metaDataExtensionList;
	}
	public void setMetaDataExtensionList(ArrayList<MetaDataExtension> metaDataExtension) {
		this.metaDataExtensionList = metaDataExtension;
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
	public ArrayList<Transformation> getTransformationList() {
		return transformationList;
	}
	public void setTransformationList(ArrayList<Transformation> transformationList) {
		this.transformationList = transformationList;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public void addTransformation( Transformation transformation ) {
		if ( transformationList == null ) {
			transformationList = new ArrayList<Transformation>();
		}
		transformationList.add( transformation );
	}

	public void addInstance( Instance instance ) {
		if ( instanceList == null ) {
			instanceList = new ArrayList<Instance>();
		}
		instanceList.add( instance );
	}

	public void addConnector( Connector connector ) {
		if ( connectorList == null ) {
			connectorList = new ArrayList<Connector>();
		}
		connectorList.add( connector );
	}

	public void addMappingVariable( MappingVariable mappingVariable ) {
		if ( mappingVariableList == null ) {
			mappingVariableList = new ArrayList<MappingVariable>();
		}
		mappingVariableList.add( mappingVariable );
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
