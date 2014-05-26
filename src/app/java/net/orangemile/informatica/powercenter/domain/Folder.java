package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

public class Folder implements Cloneable {

	private String name;
	private String description;
	private Shared shared;
	private String owner;
	private String group;
	private String permissions;
	private String uuid;
	
	private ArrayList<FolderVersion> folderVersionList;
	private ArrayList<Scheduler> schedulerList;
	private ArrayList<Task> taskList;
	private ArrayList<Source> sourceList;
	private ArrayList<Target> targetList;
	private ArrayList<Transformation> transformationList;
	private ArrayList<Mapplet> mappletList;
	private ArrayList<Mapping> mappingList;
	private ArrayList<Shortcut> shortcutList;
	
	public Folder() {}
	
	public Folder( String name ) {
		this.name = name;
	}
	
	public ArrayList<FolderVersion> getFolderVersionList() {
		return folderVersionList;
	}
	public void setFolderVersionList(ArrayList<FolderVersion> folderVersionList) {
		this.folderVersionList = folderVersionList;
	}
	public ArrayList<Mapping> getMappingList() {
		return mappingList;
	}
	public void setMappingList(ArrayList<Mapping> mappingList) {
		this.mappingList = mappingList;
	}
	public ArrayList<Mapplet> getMappletList() {
		return mappletList;
	}
	public void setMappletList(ArrayList<Mapplet> mappletList) {
		this.mappletList = mappletList;
	}
	public ArrayList<Scheduler> getSchedulerList() {
		return schedulerList;
	}
	public void setSchedulerList(ArrayList<Scheduler> schedulerList) {
		this.schedulerList = schedulerList;
	}
	public ArrayList<Shortcut> getShortcutList() {
		return shortcutList;
	}
	public void setShortcutList(ArrayList<Shortcut> shortcutList) {
		this.shortcutList = shortcutList;
	}
	public ArrayList<Source> getSourceList() {
		return sourceList;
	}
	public void setSourceList(ArrayList<Source> sourceList) {
		this.sourceList = sourceList;
	}
	public ArrayList<Target> getTargetList() {
		return targetList;
	}
	public void setTargetList(ArrayList<Target> targetList) {
		this.targetList = targetList;
	}
	public ArrayList<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(ArrayList<Task> taskList) {
		this.taskList = taskList;
	}
	public ArrayList<Transformation> getTransformationList() {
		return transformationList;
	}
	public void setTransformationList(ArrayList<Transformation> transformationList) {
		this.transformationList = transformationList;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public Shared getShared() {
		return shared;
	}
	public void setShared(Shared shared) {
		this.shared = shared;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	public void addFolderVersion(FolderVersion folderVersion) {
		if ( folderVersionList == null ) {
			folderVersionList = new ArrayList<FolderVersion>();
		}
		folderVersionList.add( folderVersion );
	}

	public void addScheduler( Scheduler scheduler ) {
		if ( schedulerList == null ) {
			schedulerList = new ArrayList<Scheduler>();
		}
		schedulerList.add( scheduler );
	}

	public void addTask( Task task ) {
		if ( taskList == null ) {
			taskList = new ArrayList<Task>();
		}
		taskList.add( task );
	}

	public void addSource( Source source ) {
		if ( sourceList == null ) {
			sourceList = new ArrayList<Source>();
		}
		sourceList.add( source );
	}

	public void addTarget( Target target ) {
		if ( targetList == null ) {
			targetList = new ArrayList<Target>();
		}
		targetList.add( target );
	}

	public void addTransformation( Transformation transformation ) {
		if ( transformationList == null ) {
			transformationList = new ArrayList<Transformation>();
		}
		transformationList.add( transformation );
	}

	public void addMapplet( Mapplet mapplet ) {
		if ( mappletList == null ) {
			mappletList = new ArrayList<Mapplet>();
		}
		mappletList.add( mapplet );
	}

	public void addMapping(Mapping mapping) {
		if ( mappingList == null ) {
			mappingList = new ArrayList<Mapping>();
		}
		mappingList.add( mapping );
	}

	public void addShortcut( Shortcut shortcut ) {
		if ( shortcutList == null ) {
			shortcutList = new ArrayList<Shortcut>();
		}
		shortcutList.add( shortcut );
	}	
	public enum Shared {
		SHARED,
		NOTSHARED;	
	}
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			throw new RuntimeException(e);
		}
	}
	
	public Source getSource( String name ) {
		for ( Source s : sourceList ) {
			if ( s.getName().equalsIgnoreCase(name) ) {
				return s;
			}
		}
		return null;
	}
	
	public Target getTarget( String name ) {
		for ( Target t : targetList ) {
			if ( t.getName().equalsIgnoreCase(name) ) {
				return t;
			}
		}
		return null;
	}
}
