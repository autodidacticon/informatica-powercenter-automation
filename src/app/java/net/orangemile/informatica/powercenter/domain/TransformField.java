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
    
    
    public TransformField( String name, String dataType, int precision, int fieldNumber ) {
    	this.name = name;
    	this.dataType = dataType;
    	this.precision = precision;
    	this.fieldNumber = fieldNumber;
    }
	/**
	 * duplicates field with port type INPUT_OUTPUT
	 */
    public TransformField(TransformField f) {
    	this.name = f.getName();
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	this.portType = f.getPortType();//PortType.INPUT_OUTPUT;
    	if( f.hasRefField() )
    		this.refField = f.getRefField();
    	if( f.hasGroup())
    		this.group = f.getGroup();
    	if ( f.hasExpression())
    		this.setExpression(f.getExpression());
    	this.fieldNumber = f.fieldNumber;
    }
    
    
	/**
	 * duplicates field with port type INPUT_OUTPUT
	 * and datatype
	 */
    public TransformField(TransformField f, String datatype) {
    	this.name = f.getName();
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	this.portType = f.getPortType();//PortType.INPUT_OUTPUT;
    	if( f.hasRefField() )
    		this.refField = f.getRefField();
    	if( f.hasGroup())
    		this.group = f.getGroup();
    	if ( f.hasExpression())
    		this.setExpression(f.getExpression());
    	setDataType(datatype);
    }
    
    /**
     * returns true if a field has an expression
     * @return boolean
     */
    private boolean hasExpression() {
		if(this.expression == null)
			return false;
		else if(this.expression.isEmpty())
			return false;
		else return true;
	}

	/**
     * returns true if field has a group
     * @return boolean
     */
	private boolean hasGroup() {
		if(this.group == null)
			return false;
		else if(this.group.isEmpty())
			return false;
		else return true;
	}

	/**
	 * returns true if field has a reference field
	 * @return boolean
	 */
	private boolean hasRefField() {
		if(this.refField == null)
			return false;
		else if(this.refField.isEmpty())
			return false;
		else return true;
	}

	/**
	 * duplicates field with entered port type
	 */
    public TransformField(TransformField f, PortType portType) {
    	this.name = f.getName();
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	this.portType = portType;
    	
    }
    
	/**
	 * duplicates field with new port type and name
	 */
    public TransformField(TransformField f, PortType portType, String name) {
    	this.name = name;
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	this.portType = portType;
    	if ( f.hasExpression())
    		this.setExpression(f.getExpression());
    	
    }
    
    /**
     *	constructor made specifically for routers, automatically naming with group
     */
    public TransformField(Field f, String group, String number) {
    	// get name and add sent number
    	String newName = f.getName()+ number;    	
    	this.name = newName;
    	
    	// copy these strings
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	
    	// put group, refer to param field, and make output field.
    	this.group = group;
    	this.refField = f.getName();
    	this.portType = PortType.OUTPUT;
    }
    /**
     * 
     * @param name
     * @param dataType
     * @param precision
     * @param scale
     * @param portType
     */
    public TransformField( String name, String dataType, int precision, int scale, PortType portType ) {
    	this.name = name;
    	this.dataType = dataType;
    	this.precision = precision;
    	this.scale = scale;
    	this.portType = portType;
    	
    }
    
    public TransformField(Field f) {
    	this.name = f.getName();
    	this.dataType =  f.getDataType();
    	this.precision = f.getPrecision();
    	this.scale = f.getScale();
    	
	}

	private ArrayList<TransformFieldAttr> transformFieldAttrList;

    
    // Getters and setters
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

	public boolean isOutput() {
		if(PortType.isOutputPort(this.portType))
			return true;
		else return false;
	}

	public void makeInputField() {
		this.portType = PortType.INPUT;
		this.group = "INPUT";
		
	}

	public void makeFinalDateTime() {
		if(this.name.endsWith("_TXT") && this.name.contains("DT_TM"))//isNotText(this.name))
			this.name = this.name.substring(0, this.name.length()-4);
		if(this.name.contains("DT_TM")){
			this.dataType = "date/time";
			this.precision = 19;
		}
		
	}

/*	private boolean isNotText(String fieldName) {
		if(fieldName.startsWith("ORG_MRN")||fieldName.startsWith("COMM_MRN")||fieldName.startsWith("FINANCIAL_NBR"))
			return false;
		else return true;
	}*/

	public void makeFinalNumber() {
		if(this.name.endsWith("_IND1") || this.dataType.equals("decimal") || this.name.endsWith("_CD1") 
				|| this.name.endsWith("_FLAG1") || this.name.endsWith("_MASK1")
				|| this.name.endsWith("_CNT1") || this.name.endsWith("_ID1") || this.dataType.equals("number")
				|| this.name.endsWith("_SEQ1") || this.name.endsWith("_NBR1") ){
			this.dataType = "double";
			this.precision = 15;
		}
		
	}

	public void makeFinalString() {
		if(this.name.startsWith("SRC_"))
			;
			//this.name = this.name.substring(4);
	}

	public void truncateName(int i) {
		this.name = this.name.substring(0, this.name.length()-i);
		
	}

	public SourceField toSourceField() {
		String srcDataType = this.getDataType();
		int srcPrecision = this.getPrecision();
		int srcScale = this.getScale();
		
		if( srcDataType.equalsIgnoreCase("double") || srcDataType.equalsIgnoreCase("integer") || srcDataType.equalsIgnoreCase("bigint") 
				|| srcDataType.equalsIgnoreCase("real") || srcDataType.equalsIgnoreCase("decimal") || srcDataType.equalsIgnoreCase("small integer"))
			srcDataType = new String("number");
		else if( srcDataType.equalsIgnoreCase("date/time")) {
			srcDataType = new String("string");
			srcPrecision = 20;
			srcScale = 0;
		}
		SourceField srcField = new SourceField(this.getName(), srcDataType, srcPrecision, srcScale);
		return srcField;
	}

	public boolean needsNumConvert() {
		//TODO remove prints
		//System.out.println(this.name);
		if( !this.name.startsWith("HEALTH_SYSTEM_") && (this.name.matches(".*_ID\\d") || this.name.matches(".*_IND\\d") || this.name.matches(".*_CD\\d") || this.name.matches(".*_FLAG\\d") || this.name.matches(".*_MASK\\d")
				|| this.name.matches(".*_CNT\\d") || this.name.matches(".*_NBR\\d") ) )
				return true;
		else return false;
	}

	public void printField() {
		System.out.println("NAME = " + this.name);
		System.out.println("DATATYPE = " + this.dataType);
	}

	public void printFieldwithComma() {
		System.out.print(this.name + ",");
		
	}

	public void printFieldwithoutComma() {
		System.out.print(this.name);
		
	}

	public boolean isDateTime() {
		if(this.getDataType().toLowerCase().equals("date"))
			return true;
		else return false;
	}

	public boolean isNumber() {
		if(this.getDataType().toLowerCase().equals("number") || this.getDataType().toLowerCase().equals("float"))
			return true;
		else return false;
	}
	
	public boolean isVarchar() {
		if(this.getDataType().toLowerCase().equals("varchar2"))
			return true;
		else return false;
	}
}
