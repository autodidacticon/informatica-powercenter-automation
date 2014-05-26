package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.ReferenceType;
import net.orangemile.informatica.powercenter.domain.constant.ObjectType;

public class Shortcut implements Cloneable {

	private String name;
	private String dbdName;
	private String repositoryName;
	private String refObjectName;
	private String referencedDbd;
	private ReferenceType referenceType;
	private ObjectType objectType;
	private String objectSubType;
	private String folderName;
	private String folderVersionName;
	private String comments;
	private String versionNumber;
	private String templateId;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDbdName() {
		return dbdName;
	}
	public void setDbdName(String dbdName) {
		this.dbdName = dbdName;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}
	public String getFolderVersionName() {
		return folderVersionName;
	}
	public void setFolderVersionName(String folderVersionName) {
		this.folderVersionName = folderVersionName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getObjectSubType() {
		return objectSubType;
	}
	public void setObjectSubType(String objectSubType) {
		this.objectSubType = objectSubType;
	}
	public ObjectType getObjectType() {
		return objectType;
	}
	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}
	public String getReferencedDbd() {
		return referencedDbd;
	}
	public void setReferencedDbd(String referencedDbd) {
		this.referencedDbd = referencedDbd;
	}
	public ReferenceType getReferenceType() {
		return referenceType;
	}
	public void setReferenceType(ReferenceType referenceType) {
		this.referenceType = referenceType;
	}
	public String getRefObjectName() {
		return refObjectName;
	}
	public void setRefObjectName(String refObjectName) {
		this.refObjectName = refObjectName;
	}
	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
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
