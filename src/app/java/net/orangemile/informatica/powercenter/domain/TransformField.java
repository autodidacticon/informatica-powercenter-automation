package net.orangemile.informatica.powercenter.domain;


import java.util.ArrayList;

import net.orangemile.informatica.powercenter.domain.constant.PortType;
import net.orangemile.informatica.powercenter.domain.constant.SortDirection;


public class TransformField implements Field, Cloneable {

	private String name;
	private String description;
	private String dataType;
	private PortType portType;
	private int precision;
	private int scale;
	private String pictureText;
	private String defaultValue;
	private String expression;
	private String expressionType;
	private String expressionDescription;
    private int fieldNumber;
    private String refSourceField;
    private String mappletGroup;
    private String refField;
    private String refTransformation;
    private String refInstanceType;
    private String sequenceGeneratorValue;
    private String group;
    private String outputGroup;
    private Boolean isSortKey;
    private SortDirection sortDirection; 
    private Boolean ignoreNullInputs;
    private Boolean ignoreInCompare;
    
    public TransformField() {}
    
    public TransformField(Field f) {
    	this.name = f.getName();
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	this.portType = PortType.INPUT_OUTPUT;
    }
    
    public TransformField( String name, String dataType, int precision, int scale, PortType portType ) {
    	this.name = name;
    	this.dataType = dataType;
    	this.precision = precision;
    	this.scale = scale;
    	this.portType = portType;
    }
    
    private ArrayList<TransformFieldAttr> transformFieldAttrList;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getExpressionDescription() {
		return expressionDescription;
	}

	public void setExpressionDescription(String expressionDescription) {
		this.expressionDescription = expressionDescription;
	}

	public String getExpressionType() {
		return expressionType;
	}

	public void setExpressionType(String expressionType) {
		this.expressionType = expressionType;
	}

	public int getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Boolean isIgnoreInCompare() {
		return ignoreInCompare;
	}

	public void setIgnoreInCompare(Boolean ignoreInCompare) {
		this.ignoreInCompare = ignoreInCompare;
	}

	public boolean isIgnoreNullInputs() {
		return ignoreNullInputs;
	}

	public void setIgnoreNullInputs(boolean ignoreNullInputs) {
		this.ignoreNullInputs = ignoreNullInputs;
	}

	public boolean isSortKey() {
		return isSortKey;
	}

	public void setSortKey(boolean isSortKey) {
		this.isSortKey = isSortKey;
	}

	public String getMappletGroup() {
		return mappletGroup;
	}

	public void setMappletGroup(String mappletGroup) {
		this.mappletGroup = mappletGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutputGroup() {
		return outputGroup;
	}

	public void setOutputGroup(String outputGroup) {
		this.outputGroup = outputGroup;
	}

	public String getPictureText() {
		return pictureText;
	}

	public void setPictureText(String pictureText) {
		this.pictureText = pictureText;
	}

	public PortType getPortType() {
		return portType;
	}

	public void setPortType(PortType portType) {
		this.portType = portType;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getRefField() {
		return refField;
	}

	public void setRefField(String refField) {
		this.refField = refField;
	}

	public String getRefInstanceType() {
		return refInstanceType;
	}

	public void setRefInstanceType(String refInstanceType) {
		this.refInstanceType = refInstanceType;
	}

	public String getRefSourceField() {
		return refSourceField;
	}

	public void setRefSourceField(String refSourceField) {
		this.refSourceField = refSourceField;
	}

	public String getRefTransformation() {
		return refTransformation;
	}

	public void setRefTransformation(String refTransformation) {
		this.refTransformation = refTransformation;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getSequenceGeneratorValue() {
		return sequenceGeneratorValue;
	}

	public void setSequenceGeneratorValue(String sequenceGeneratorValue) {
		this.sequenceGeneratorValue = sequenceGeneratorValue;
	}

	public SortDirection getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortDirection sortDirection) {
		this.sortDirection = sortDirection;
	}

	public ArrayList<TransformFieldAttr> getTransformFieldAttrList() {
		return transformFieldAttrList;
	}

	public void setTransformFieldAttrList(ArrayList<TransformFieldAttr> transformFieldAttrList) {
		this.transformFieldAttrList = transformFieldAttrList;
	}
	
	public void addTransformFieldAttr( TransformFieldAttr transformFieldAttr ) {
		if ( transformFieldAttrList == null ) {
			transformFieldAttrList = new ArrayList<TransformFieldAttr>();
		}
		transformFieldAttrList.add( transformFieldAttr );
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
