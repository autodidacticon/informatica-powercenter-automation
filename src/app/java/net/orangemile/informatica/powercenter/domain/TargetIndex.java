package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

public class TargetIndex implements Cloneable {

	private String name;
	private String unique;
	private String description;
	
	private ArrayList<TargetIndexField> targetIndexFieldList;
	
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
	public String getUnique() {
		return unique;
	}
	public void setUnique(String unique) {
		this.unique = unique;
	}
	public ArrayList<TargetIndexField> getTargetIndexFieldList() {
		return targetIndexFieldList;
	}
	public void setTargetIndexFieldList(ArrayList<TargetIndexField> targetIndexFieldList) {
		this.targetIndexFieldList = targetIndexFieldList;
	}
	
	public void addTargetIndexField( TargetIndexField targetIndexField ) {
		if ( targetIndexFieldList == null ) {
			targetIndexFieldList = new ArrayList<TargetIndexField>();
		}
		targetIndexFieldList.add(targetIndexField);
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
