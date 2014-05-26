package net.orangemile.informatica.powercenter.domain.sap;

public class SAPCodeBlock {

    private String name;
    private String description;
    private String codeBlock;
    private String dsqInstanceName;
    
	public String getCodeBlock() {
		return codeBlock;
	}
	public void setCodeBlock(String codeBlock) {
		this.codeBlock = codeBlock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDsqInstanceName() {
		return dsqInstanceName;
	}
	public void setDsqInstanceName(String dsqInstanceName) {
		this.dsqInstanceName = dsqInstanceName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
