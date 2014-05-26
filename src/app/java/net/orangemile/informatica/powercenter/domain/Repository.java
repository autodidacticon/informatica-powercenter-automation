package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

public class Repository implements Cloneable {

	private String name;
	private String databaseType;
	private String codePage;
	private String version;
	private String parentRepository;
	
	private ArrayList<Folder> folderList;
	
	public Repository() {}
	
	public Repository( String name ) {
		this.name = name;
		this.codePage = "Latin1";
	}
	
	public String getCodePage() {
		return codePage;
	}
	public void setCodePage(String codepage) {
		this.codePage = codepage;
	}
	public String getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentRepository() {
		return parentRepository;
	}
	public void setParentRepository(String parentRepository) {
		this.parentRepository = parentRepository;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public ArrayList<Folder> getFolderList() {
		return folderList;
	}
	public void setFolderList(ArrayList<Folder> folderList) {
		this.folderList = folderList;
	}
	
	public void addFolder( Folder folder ) {
		if ( folderList == null ) {
			folderList = new ArrayList<Folder>();
		}
		folderList.add( folder );
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
