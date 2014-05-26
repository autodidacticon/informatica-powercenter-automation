package net.orangemile.informatica.powercenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.orangemile.informatica.powercenter.domain.constant.PortType;

import net.orangemile.informatica.powercenter.domain.constant.DataType;
import net.orangemile.informatica.powercenter.domain.SourceField;

import net.orangemile.informatica.powercenter.InformaticaSupport;

import net.orangemile.informatica.powercenter.domain.*;
import net.orangemile.informatica.powercenter.jibx.XMLUtil;

public class MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void text() throws Exception {
		Powermart powermart = new Powermart();
		Repository rep = new Repository( "RepositoryDev" );
		rep.setCodePage("Latin1");		
		powermart.addRepository(rep);
    	Folder folder = new Folder( "DevFolder" );
    	rep.addFolder( folder );
    	
    	// create mapping
    	Mapping mapping = new Mapping("TestMapping");
		folder.addMapping( mapping );
		
		// Utility helper
		InformaticaSupport infaSupport = new InformaticaSupport(mapping, folder);
		
		// build source
		Source source = new Source( "Table1" );
        source.setDatabaseType("Sybase");
        source.setDbdName("Server1Instance");
    	source.addSourceField( new SourceField("field1", "varchar", 10, 0) );
    	source.addSourceField( new SourceField("field2", "varchar", 10, 0) );
    	infaSupport.addSource(source);
    	
        // SQ (Sorce Qualifier)
        String sqName = "SQ_Table1";
        ArrayList<TransformField> fields = new ArrayList<TransformField>();
        List<TableAttribute> attribs = new ArrayList<TableAttribute>();        
        fields.add( new TransformField("field1", DataType.STRING.toString(), 16, 0, PortType.INPUT_OUTPUT) );        
        Transformation sqTransformation = infaSupport.sourceQualifier(sqName, sqName, sqName, fields, attribs );
        
        // linking source to Source Qualifier (SQ)
        infaSupport.connectByName( source, sqTransformation );

        // build target
		Target target = new Target("STG_Table1") ;
		target.setDatabaseType("ODBC");
        target.addTargetField( new TargetField("field1", "varchar", 10, 0 ) );
        infaSupport.addTarget(target);
        
        // link SQ to target
        infaSupport.connectByName( sqTransformation, target );
        
        String xml = XMLUtil.toXml(powermart);
        System.out.println( xml );
	}
}
