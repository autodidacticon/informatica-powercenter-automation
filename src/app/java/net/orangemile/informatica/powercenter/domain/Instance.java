package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;
import java.util.List;

import net.orangemile.informatica.powercenter.domain.constant.BoxType;
import net.orangemile.informatica.powercenter.domain.constant.InstanceType;

public class Instance implements Box, Cloneable {

	private String name;
	private String description;
	private BoxType type;
	private Boolean reusable;
	private String transformationType;
	private String transformationName;
	private String dbdName;
	private String associatedDsq;
	private String associatedDsqType;
	
	private List<TableAttribute> tableAttributeList;
	private List<InitProp> initPropList;
	private List<AssociatedSourceInstance> associatedSourceInstanceList;
		
	public Instance() {}
	
	public Instance(String name, String transformationName, String transformationType, BoxType type ) {
		this.name = name;
		this.transformationName = transformationName;
		this.transformationType = transformationType;
		this.type = type;
	}
	
	/**
	 * constructor for reusable instances
	 * @param name
	 * @param transformationName
	 * @param transformationType
	 * @param type
	 * @param reusable
	 */
	public Instance(String name, String transformationName, String transformationType,
			BoxType type, Boolean reusable ) {
		this.name = name;
		this.transformationName = transformationName;
		this.transformationType = transformationType;
		this.type = type;
		this.reusable = reusable;
	}
	
	public List<InitProp> getInitPropList() {
		return initPropList;
	}
	public void setInitPropList(List<InitProp> initPropList) {
		this.initPropList = initPropList;
	}
	public List<TableAttribute> getTableAttributeList() {
		return tableAttributeList;
	}
	public void setTableAttributeList(List<TableAttribute> tableAttributeList) {
		this.tableAttributeList = tableAttributeList;
	}
	public String getAssociatedDsq() {
		return associatedDsq;
	}
	public void setAssociatedDsq(String associatedDsq) {
		this.associatedDsq = associatedDsq;
	}
	public String getAssociatedDsqType() {
		return associatedDsqType;
	}
	public void setAssociatedDsqType(String associatedDsqType) {
		this.associatedDsqType = associatedDsqType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean isReusable() {
		return reusable;
	}

	public void setReusable(Boolean reusable) {
		this.reusable = reusable;
	}

	public String getTransformationName() {
		return transformationName;
	}
	public void setTransformationName(String transformationName) {
		this.transformationName = transformationName;
	}
	public String getTransformationType() {
		return transformationType;
	}
	public void setTransformationType(String transformationType) {
		this.transformationType = transformationType;
	}
	public BoxType getType() {
		return type;
	}
	

	public void setType(BoxType type) {
		this.type = type;
	}
	
	public void addTableAttribute(TableAttribute tableAttribute) {
		if ( tableAttributeList == null ) {
			tableAttributeList = new ArrayList<TableAttribute>();
		}
		tableAttributeList.add( tableAttribute );
	}

	public void addInitProp( InitProp initProp ) {
		if ( initPropList == null ) {
			initPropList = new ArrayList<InitProp>();
		}
		initPropList.add( initProp );
	}

	public void addAssociatedSourceInstance( AssociatedSourceInstance associatedSourceInstance ) {
		if ( associatedSourceInstanceList == null ) {
			associatedSourceInstanceList = new ArrayList<AssociatedSourceInstance>();
		}
		associatedSourceInstanceList.add( associatedSourceInstance );
	}
	public List<AssociatedSourceInstance> getAssociatedSourceInstanceList() {
		return associatedSourceInstanceList;
	}
	public void setAssociatedSourceInstanceList(
			List<AssociatedSourceInstance> associatedSourceInstanceList) {
		this.associatedSourceInstanceList = associatedSourceInstanceList;
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
	public List<? extends Field> getInputPorts() {
		// TODO Auto-generated method stub
		return null;
	}

	// override this function to get instances to implement
	// Box class, and be able to use connect method from Informatica
	// Support class
	@Override
	public String getInstanceType() {
		
		
		// workaround added by Duane Crowe:
		//	if it is a transformation, the transformation type needs to be
		//  accessed here as the writer will otherwise return "Transformation"
		String instanceType =  this.type.toString();
		if(instanceType.equals("TRANSFORMATION") || true)
			return this.transformationType;
		else return instanceType;
	}

	@Override
	public List<? extends Field> getOutputPorts() {
		// TODO Auto-generated method stub
		return null;
	}	
}
