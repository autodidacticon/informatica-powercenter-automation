package net.orangemile.informatica.powercenter.domain.sap;

public class SAPProgramFlowObject {

	private String refSourceName;
	private String refDbdName;
	private String refSourceInstanceName;
	private String type;	// (SOURCE | FUNCTION | CODEBLOCK | NONE)
	private String joinBitMap;
	private String order;
	private String dsqInstanceName;
	
	public String getDsqInstanceName() {
		return dsqInstanceName;
	}
	public void setDsqInstanceName(String dsqInstanceName) {
		this.dsqInstanceName = dsqInstanceName;
	}
	public String getJoinBitMap() {
		return joinBitMap;
	}
	public void setJoinBitMap(String joinBitMap) {
		this.joinBitMap = joinBitMap;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getRefDbdName() {
		return refDbdName;
	}
	public void setRefDbdName(String refDbdName) {
		this.refDbdName = refDbdName;
	}
	public String getRefSourceInstanceName() {
		return refSourceInstanceName;
	}
	public void setRefSourceInstanceName(String refSourceInstanceName) {
		this.refSourceInstanceName = refSourceInstanceName;
	}
	public String getRefSourceName() {
		return refSourceName;
	}
	public void setRefSourceName(String refSourceName) {
		this.refSourceName = refSourceName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
