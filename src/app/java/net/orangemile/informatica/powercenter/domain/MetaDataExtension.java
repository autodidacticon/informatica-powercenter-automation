package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.DataType;

public class MetaDataExtension implements Cloneable {

	private String name;
	private String vendorName;
	private String domainName;
	private DataType dataType;
	private String value;
	private int maxLength;
	private String description;
	private Boolean isShareRead;
	private Boolean isShareWrite;
	private Boolean isClientVisible;
	private Boolean isClientEditable;
	private Boolean isReusable;
	
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}	
	public boolean isClientEditable() {
		return isClientEditable;
	}
	public void setClientEditable(boolean isClientEditable) {
		this.isClientEditable = isClientEditable;
	}
	public boolean isClientVisible() {
		return isClientVisible;
	}
	public void setClientVisible(boolean isClientVisible) {
		this.isClientVisible = isClientVisible;
	}
	public boolean isReusable() {
		return isReusable;
	}
	public void setReusable(boolean isReusable) {
		this.isReusable = isReusable;
	}
	public Boolean isShareRead() {
		return isShareRead;
	}
	public void setShareRead(Boolean isShareRead) {
		this.isShareRead = isShareRead;
	}
	public Boolean isShareWrite() {
		return isShareWrite;
	}
	public void setShareWrite(Boolean isShareWrite) {
		this.isShareWrite = isShareWrite;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
