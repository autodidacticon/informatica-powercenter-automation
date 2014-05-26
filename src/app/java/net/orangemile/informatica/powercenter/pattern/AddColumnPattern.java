package net.orangemile.informatica.powercenter.pattern;

import java.util.List;

import net.orangemile.informatica.powercenter.DataTypeResolver;
import net.orangemile.informatica.powercenter.domain.*;
import net.orangemile.informatica.powercenter.domain.constant.InstanceType;

/**
 * This pattern adds a new field along side the exampleFieldName to the entire mapping. It
 * does this by starting from the last box specified by end box name, and recursively walk back
 * to the front making the necessary changes. 
 * <p>
 * @author Orange Mile, Inc
 */
public class AddColumnPattern {

	protected Powermart powermart;
	protected String exampleFieldName;
	protected String endBoxName;
	
	protected TargetField newField;
	
	protected Mapping mapping;
	protected Folder folder;
	
	protected AddColumnPatternCallback callback;
	
	/**
	 * Constructor
	 * @param powermart
	 * @param endBoxName
	 * @param exampleFieldName
	 * @param newField
	 * @param callback
	 */
	public AddColumnPattern( Powermart powermart, String endBoxName, String exampleFieldName, TargetField newField, AddColumnPatternCallback callback ) {
		this.powermart = powermart;
		this.exampleFieldName = exampleFieldName;
		this.endBoxName = endBoxName;
		this.newField = newField;
		
		this.callback = callback;
	}
	
	
	/**
	 * Primary entry point - makes changes directly to the powermart object
	 * @throws Exception
	 */
	public void execute() throws Exception {		
		Repository rep = powermart.getRepositoryList().get(0);
		folder = rep.getFolderList().get(0);
		mapping = folder.getMappingList().get(0);
		
		Target target = folder.getTargetList().get(0);
		target.addTargetField(newField, exampleFieldName);
		if ( callback != null ) {
			callback.callback(target, newField, exampleFieldName);
		}

		
		List<Connector> connectorList = mapping.getConnectorsTo(endBoxName, exampleFieldName);
		
		recursiveWalk( connectorList );
	}
	
	/**
	 * Performs the recursive walk using the given connectors
	 * @param connectorList
	 */
	protected void recursiveWalk( List<Connector> connectorList ) {
		for ( Connector c : connectorList ) {
			if ( c.getFromInstanceType().equalsIgnoreCase(InstanceType.SOURCE_DEFINITION.getInstanceType()) ) {				
				Instance srcInstance = mapping.getInstance( c.getFromInstance() );
				Source src = folder.getSource( srcInstance.getTransformationName() );										
				SourceField sourceField = new SourceField( newField );
				src.addSourceField(sourceField, exampleFieldName);
				Connector connector = new Connector(sourceField.getName(), c.getFromInstance(), src.getInstanceType(), 
						newField.getName(), c.getToInstance(), c.getToInstanceType() );
				mapping.addConnector(connector);
				if ( callback != null ) {
					callback.callback(src, sourceField, exampleFieldName);
				}
				continue;
			}
			Transformation t = mapping.getTransformation(c.getFromInstance());
			TransformField exampleField = t.getTransformField(exampleFieldName);
			
			TransformField tField = new TransformField(newField);
			DataTypeResolver.toInformaticaType(tField);
			tField.setPortType(exampleField.getPortType());
			t.addTransformField( tField, exampleFieldName );
			
			Connector connector = new Connector(tField.getName(), t.getName(), t.getInstanceType(), 
					newField.getName(), c.getToInstance(), c.getToInstanceType() );
			mapping.addConnector(connector);
			
			// perform anything extra - like change SQL
			if ( callback != null ) {
				callback.callback(t, tField, exampleFieldName);
			}		

			// walk back
			List<Connector> prevConnectors = mapping.getConnectorsTo( c.getFromInstance(), c.getFromField() );
			recursiveWalk( prevConnectors );
		}
	}	
}
