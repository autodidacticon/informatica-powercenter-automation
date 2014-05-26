package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.List;

import net.orangemile.informatica.powercenter.domain.sap.ErpInfo;

public class Mapping implements Cloneable {

	private String name;
	private String description;
	private String objectVersion;
	private String isValid;
	private Boolean isProfileMapping;
	private String versionNumber;
	private String crcValue;
	
	private ArrayList<Transformation> transformationList;
	private ArrayList<Instance> instanceList;
	private ArrayList<Connector> connectorList;
	private ArrayList<MapDependency> mapDependencyList;
	private ArrayList<TargetLoadOrder> targetLoadOrderList;
	private ArrayList<MappingVariable> mappingVariableList;
	private ArrayList<ErpInfo> erpInfoList;
	private ArrayList<MetaDataExtension> metaDataExtensionList;
	
	public Mapping() {}
	
	public Mapping( String name ) {
		this.name = name;
	}
	
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
	public ArrayList<MapDependency> getMapDependencyList() {
		return mapDependencyList;
	}
	public void setMapDependencyList(ArrayList<MapDependency> mapDependencyList) {
		this.mapDependencyList = mapDependencyList;
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
	public ArrayList<TargetLoadOrder> getTargetLoadOrderList() {
		return targetLoadOrderList;
	}
	public void setTargetLoadOrderList(ArrayList<TargetLoadOrder> targetLoadOrderList) {
		this.targetLoadOrderList = targetLoadOrderList;
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

	public void addMapDependency( MapDependency mapDependency ) {
		if ( mapDependencyList == null ) {
			mapDependencyList = new ArrayList<MapDependency>();
		}
		mapDependencyList.add( mapDependency );
	}

	public void addTargetLoadOrder( TargetLoadOrder targetLoadOrder ) {
		if ( targetLoadOrderList == null ) {
			targetLoadOrderList = new ArrayList<TargetLoadOrder>();
		}
		targetLoadOrderList.add( targetLoadOrder );
	}

	public void addMappingVariable( MappingVariable mappingVariable ) {
		if ( mappingVariableList == null ) {
			mappingVariableList = new ArrayList<MappingVariable>();			
		}
		mappingVariableList.add( mappingVariable );
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

	public Boolean isProfileMapping() {
		return isProfileMapping;
	}

	public void setProfileMapping(Boolean isProfileMapping) {
		this.isProfileMapping = isProfileMapping;
	}

	public ArrayList<ErpInfo> getErpInfoList() {
		return erpInfoList;
	}

	public void setErpInfoList(ArrayList<ErpInfo> erpInfoList) {
		this.erpInfoList = erpInfoList;
	}
	
	/****************************************
	 * Utility Methods
	 ****************************************/
	
	/**
	 * Retrieves all the connectors going TO a given instance
	 * @param instanceName 
	 * @return  
	 */
	public List<Connector> getConnectorsTo( String instanceName ) {
		ArrayList<Connector> connectors = new ArrayList<Connector>();
		for ( Connector c : connectorList ) {
			if ( c.getToInstance().equalsIgnoreCase(instanceName) ) {
				connectors.add(c);
			}
		}
		return connectors;
	}
	
	/**
	 * Retrieves all the connectors going FROM a given instance
	 * @param instanceName 
	 * @return  
	 */
	public List<Connector> getConnectorsFrom( String instanceName ) {
		ArrayList<Connector> connectors = new ArrayList<Connector>();
		for ( Connector c : connectorList ) {
			if ( c.getFromInstance().equalsIgnoreCase(instanceName) ) {
				connectors.add(c);
			}
		}
		return connectors;
	}
	
	/**
	 * Gets all the connectors going TO a given instance and a given field
	 * @param instanceName
	 * @param fieldName
	 * @return
	 */
	public List<Connector> getConnectorsTo( String instanceName, String fieldName ) {
		ArrayList<Connector> connectors = new ArrayList<Connector>();
		for ( Connector c : connectorList ) {
			if ( c.getToInstance().equalsIgnoreCase(instanceName) && c.getToField().equalsIgnoreCase(fieldName) ) {
				connectors.add(c);
			}
		}
		return connectors;
	}
	
	/**
	 * Gets all the connectors going TO a given instance and a given field
	 * @param instanceName
	 * @param fieldName
	 * @return
	 */
	public List<Connector> getConnectorsFrom( String instanceName, String fieldName ) {
		ArrayList<Connector> connectors = new ArrayList<Connector>();
		for ( Connector c : connectorList ) {
			if ( c.getFromInstance().equalsIgnoreCase(instanceName) && c.getFromField().equalsIgnoreCase(fieldName) ) {
				connectors.add(c);
			}
		}
		return connectors;
	}
	
	/**
	 * Retrieves a transformation defined in the given mapping with the given name
	 * @param name
	 * @return
	 */
	public Transformation getTransformation( String name ) {
		for( Transformation t : transformationList ) {
			if ( t.getName().equalsIgnoreCase(name) ) {
				return t;
			}			
		}
		return null;
	}
	
	public Instance getInstance( String name ) {
		for ( Instance i : instanceList ) {
			if ( i.getName().equalsIgnoreCase(name) ) {
				return i;
			}
		}
		return null;
	}
}
