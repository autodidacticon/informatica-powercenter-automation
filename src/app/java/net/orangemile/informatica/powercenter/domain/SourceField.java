package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

import net.orangemile.informatica.powercenter.domain.constant.Nullable;

public class SourceField implements Field, Cloneable {
    
    private String name;
    private String businessName;
    private String description;
    private String dataType;
    private String keyType;
    private String usage;
    private String usageFlags;
    private String pictureText;
    private String redefines;
    private String referencedTable;
    private String referencedField;
    private String referencedDbd;
    private String offset;
    private String physicalOffset;
    private String physicalLength;
    private String hidden;
    private String group;
    private String shiftState;

    private Nullable nullable;
    private FieldType fieldType;

    private int length;
    private int occurs;
    private int precision;
    private int scale;    
    private int level;
    private int fieldNumber;
    
    private ArrayList<SourceField> sourceFieldList;
    private ArrayList<FieldAttribute> fieldAttributeList;

    public SourceField() {}
    
    public SourceField( Field field ) {
    	this.name = field.getName();
    	this.dataType = field.getDataType();
    	this.precision = field.getPrecision();
    	this.scale = field.getScale();
    }
    
    public SourceField( String name, String dataType, int precision, int scale ) {
    	this.name = name;
    	this.dataType = dataType;
    	this.precision = precision;
    	this.scale = scale;
    }
    
	public ArrayList<FieldAttribute> getFieldAttributeList() {
		return fieldAttributeList;
	}

	public void setFieldAttributeList(ArrayList<FieldAttribute> fieldAttributeList) {
		this.fieldAttributeList = fieldAttributeList;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFieldNumber() {
		return fieldNumber;
	}

	public void setFieldNumber(int fieldNumber) {
		this.fieldNumber = fieldNumber;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nullable getNullable() {
		return nullable;
	}

	public void setNullable(Nullable nullable) {
		this.nullable = nullable;
	}

	public int getOccurs() {
		return occurs;
	}

	public void setOccurs(int occurs) {
		this.occurs = occurs;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getPhysicalLength() {
		return physicalLength;
	}

	public void setPhysicalLength(String physicalLength) {
		this.physicalLength = physicalLength;
	}

	public String getPhysicalOffset() {
		return physicalOffset;
	}

	public void setPhysicalOffset(String physicalOffset) {
		this.physicalOffset = physicalOffset;
	}

	public String getPictureText() {
		return pictureText;
	}

	public void setPictureText(String pictureText) {
		this.pictureText = pictureText;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public String getRedefines() {
		return redefines;
	}

	public void setRedefines(String redefines) {
		this.redefines = redefines;
	}

	public String getReferencedDbd() {
		return referencedDbd;
	}

	public void setReferencedDbd(String referencedDbd) {
		this.referencedDbd = referencedDbd;
	}

	public String getReferencedField() {
		return referencedField;
	}

	public void setReferencedField(String referencedField) {
		this.referencedField = referencedField;
	}

	public String getReferencedTable() {
		return referencedTable;
	}

	public void setReferencedTable(String referencedTable) {
		this.referencedTable = referencedTable;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getShiftState() {
		return shiftState;
	}

	public void setShiftState(String shiftState) {
		this.shiftState = shiftState;
	}

	public ArrayList<SourceField> getSourceFieldList() {
		return sourceFieldList;
	}

	public void setSourceFieldList(ArrayList<SourceField> sourceFieldList) {
		this.sourceFieldList = sourceFieldList;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getUsageFlags() {
		return usageFlags;
	}

	public void setUsageFlags(String usageFlags) {
		this.usageFlags = usageFlags;
	}
	
	public void addSourceField( SourceField sourceFieled ) {
		if ( sourceFieldList == null ) {
			sourceFieldList = new ArrayList<SourceField>();
		}
		sourceFieldList.add( sourceFieled );
	}
	
	public void addFieldAttribute(FieldAttribute fieldAttribute) {
		if ( fieldAttributeList == null ) {
			fieldAttributeList = new ArrayList<FieldAttribute>();
		}
		fieldAttributeList.add( fieldAttribute );
	}
	
	public enum FieldType {
		ELEMITEM
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
