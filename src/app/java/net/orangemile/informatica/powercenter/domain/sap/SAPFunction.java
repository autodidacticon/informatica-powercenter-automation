package net.orangemile.informatica.powercenter.domain.sap;

import java.util.List;

public class SAPFunction {

	private String name;
	private String description;
	private List<SAPFunctionParam> sapFunctionParamList;
	private List<SAPTableParam> sapTableParamList;
	
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
	public List<SAPFunctionParam> getSapFunctionParamList() {
		return sapFunctionParamList;
	}
	public void setSapFunctionParamList(List<SAPFunctionParam> sapFunctionParamList) {
		this.sapFunctionParamList = sapFunctionParamList;
	}
	public List<SAPTableParam> getSapTableParamList() {
		return sapTableParamList;
	}
	public void setSapTableParamList(List<SAPTableParam> sapTableParamList) {
		this.sapTableParamList = sapTableParamList;
	}
}

