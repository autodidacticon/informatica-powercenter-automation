package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

public class Task implements Cloneable {

	private String name;
	private String description;
	private String type;
	private Boolean reusable;
	private String parent;
	private ParentType parentType;
	private String versionNumber;

	private Timer timer;

	private ArrayList<ValuePair> valuePairList;
	
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
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public ParentType getParentType() {
		return parentType;
	}
	public void setParentType(ParentType parentType) {
		this.parentType = parentType;
	}	
	public Boolean isReusable() {
		return reusable;
	}
	public void setReusable(Boolean reusable) {
		this.reusable = reusable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}
	public enum ParentType {
		WORKLET,
		WORKFLOW
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public ArrayList<ValuePair> getValuePairList() {
		return valuePairList;
	}
	public void setValuePairList(ArrayList<ValuePair> valuePairList) {
		this.valuePairList = valuePairList;
	}	
}