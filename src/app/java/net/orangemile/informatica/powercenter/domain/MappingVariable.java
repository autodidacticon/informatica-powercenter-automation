package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.AggregateFunction;

public class MappingVariable implements Cloneable {

	private String name;
	private String description;
	private String dataType;
	private String precision;
	private String scale;
	private String defaultValue;
	private AggregateFunction aggFunction; 
	private Boolean userDefined;
	private Boolean isParam;
	
	public AggregateFunction getAggFunction() {
		return aggFunction;
	}
	public void setAggFunction(AggregateFunction aggFunction) {
		this.aggFunction = aggFunction;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrecision() {
		return precision;
	}
	public void setPrecision(String precision) {
		this.precision = precision;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}	
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}
	public boolean isParam() {
		return isParam;
	}
	public void setParam(boolean isParam) {
		this.isParam = isParam;
	}
	public Boolean isUserDefined() {
		return userDefined;
	}
	public void setUserDefined(Boolean userDefined) {
		this.userDefined = userDefined;
	}	
}
