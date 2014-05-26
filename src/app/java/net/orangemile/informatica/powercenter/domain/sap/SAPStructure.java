package net.orangemile.informatica.powercenter.domain.sap;

import java.util.List;

public class SAPStructure {

	private String name;
	private List<SAPStructureField> sapStructureFieldList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SAPStructureField> getSapStructureFieldList() {
		return sapStructureFieldList;
	}

	public void setSapStructureFieldList(List<SAPStructureField> sapStructureFieldList) {
		this.sapStructureFieldList = sapStructureFieldList;
	}
}
