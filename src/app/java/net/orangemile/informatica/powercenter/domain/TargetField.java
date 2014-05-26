package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

import net.orangemile.informatica.powercenter.domain.constant.Nullable;

public class TargetField implements Field, Cloneable {

	private String name;
	private String businessName;
	private String description;
	private String dataType;
	private String keyType;
	private int precision;
	private int scale;
	private int fieldNumber;
	private Nullable nullable;
	private String pictureText;
	private String referencedTable;
	private String referencedField;
	private String group;
	private Boolean isFileNameField;
	
	private ArrayList<FieldAttribute> fieldAttributeList;
	
	public TargetField() {}
	
	public TargetField( String name, String dataType, int precision, int scale ) {
		this.name = name;
		this.dataType = dataType;
		this.precision = precision;
		this.scale = scale;
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
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}	
	public Boolean isFileNameField() {
		return isFileNameField;
	}
	public void setFileNameField(Boolean isFileNameField) {
		this.isFileNameField = isFileNameField;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
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
	public ArrayList<FieldAttribute> getFieldAttributeList() {
		return fieldAttributeList;
	}
	public void setFieldAttributeList(ArrayList<FieldAttribute> fieldAttributeList) {
		this.fieldAttributeList = fieldAttributeList;
	}
	
	public void addFieldAttribute( FieldAttribute fieldAttribute ) {
		if ( fieldAttributeList == null ) {
			fieldAttributeList = new ArrayList<FieldAttribute>();
		}
		fieldAttributeList.add( fieldAttribute );
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
