package net.orangemile.informatica.powercenter.domain.sap;

import java.util.List;

public class SAPFunctionInstance {

	private String functionName;
	private String dsqInstanceName;
	private List<SAPFunctionInstanceParam> sapFunctionInstanceParamList;
	private List<SAPTableInstanceParam> sapTableInstanceParam;
	
	public String getDsqInstanceName() {
		return dsqInstanceName;
	}
	public void setDsqInstanceName(String dsqInstanceName) {
		this.dsqInstanceName = dsqInstanceName;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public List<SAPFunctionInstanceParam> getSapFunctionInstanceParamList() {
		return sapFunctionInstanceParamList;
	}
	public void setSapFunctionInstanceParamList(
			List<SAPFunctionInstanceParam> sapFunctionInstanceParamList) {
		this.sapFunctionInstanceParamList = sapFunctionInstanceParamList;
	}
	public List<SAPTableInstanceParam> getSapTableInstanceParam() {
		return sapTableInstanceParam;
	}
	public void setSapTableInstanceParam(List<SAPTableInstanceParam> sapTableInstanceParam) {
		this.sapTableInstanceParam = sapTableInstanceParam;
	}
}
