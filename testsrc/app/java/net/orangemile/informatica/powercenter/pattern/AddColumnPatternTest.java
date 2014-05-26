package net.orangemile.informatica.powercenter.pattern;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.FileWriter;

import net.orangemile.informatica.powercenter.domain.Powermart;
import net.orangemile.informatica.powercenter.domain.TargetField;
import net.orangemile.informatica.powercenter.jibx.XMLUtil;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddColumnPatternTest {

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
	public void testExecute() throws Exception {
		String fileName = "Y:/m_STG_2_SERVICER_FEES.xml";
		Powermart powermart = (Powermart) XMLUtil.fromXml(new FileReader(fileName) );
		
		String sampleFieldName = "PREP_FEE_REMITTED";
		String endTarget = "D_SERVICER_FEES";
		TargetField field = new TargetField("field42", "DECIMAL", 14, 4);
		AddColumnPattern dtl = new AddColumnPattern(powermart, endTarget, sampleFieldName, field, null);
		dtl.execute();
		
		String xml = XMLUtil.toXml(powermart);	
		FileWriter fio = new FileWriter(fileName);
		fio.write( xml );
		fio.close();
	}

}
