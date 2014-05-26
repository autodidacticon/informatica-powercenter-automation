package net.orangemile.informatica.powercenter.domain.sap;

import java.util.List;

public class ErpInfo {

	// SAPPROGRAMFLOWOBJECT)*
	private List<SAPFunction> sapFunctionList;
	private List<SAPStructure> sapStructureList;
	private List<SAPProgram> sapProgramList;
	private List<SAPOutputPort> sapOutputPortList;
	private List<SAPVariable> sapVariableList;
	private List<SAPProgramFlowObject> sapProgramFlowObjectList;
	
	public List<SAPFunction> getSapFunctionList() {
		return sapFunctionList;
	}
	public void setSapFunctionList(List<SAPFunction> sapFunctionList) {
		this.sapFunctionList = sapFunctionList;
	}
	public List<SAPOutputPort> getSapOutputPortList() {
		return sapOutputPortList;
	}
	public void setSapOutputPortList(List<SAPOutputPort> sapOutputPortList) {
		this.sapOutputPortList = sapOutputPortList;
	}
	public List<SAPProgramFlowObject> getSapProgramFlowObjectList() {
		return sapProgramFlowObjectList;
	}
	public void setSapProgramFlowObjectList(List<SAPProgramFlowObject> sapProgramFlowObjectList) {
		this.sapProgramFlowObjectList = sapProgramFlowObjectList;
	}
	public List<SAPProgram> getSapProgramList() {
		return sapProgramList;
	}
	public void setSapProgramList(List<SAPProgram> sapProgramList) {
		this.sapProgramList = sapProgramList;
	}
	public List<SAPStructure> getSapStructureList() {
		return sapStructureList;
	}
	public void setSapStructureList(List<SAPStructure> sapStructureList) {
		this.sapStructureList = sapStructureList;
	}
	public List<SAPVariable> getSapVariableList() {
		return sapVariableList;
	}
	public void setSapVariableList(List<SAPVariable> sapVariableList) {
		this.sapVariableList = sapVariableList;
	}		
}
