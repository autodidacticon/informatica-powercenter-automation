package net.orangemile.informatica.powercenter.jibx;

import java.io.Reader;
import java.io.StringWriter;

import net.orangemile.informatica.powercenter.domain.Powermart;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.ICharacterEscaper;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

/**
 * @author Orange Mile, Inc
 */
public class XMLUtil {

	/**
	 * Generates the XML from the given powermart object
	 * @param powermart
	 * @return
	 */
	public static String toXml(Powermart powermart) {
		ICharacterEscaper esc = new XMLCharacterEscape();
		return getXml(powermart, Powermart.class, "ISO-8859-1", "POWERMART", "powrmart.dtd", esc);	
	}
	
	/**
	 * Generates the Powermart object from the given data reader
	 * @param reader 
	 * @return
	 */
	public static Powermart fromXml(Reader reader) {
		Powermart object = null;
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Powermart.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			object = (Powermart) uctx.unmarshalDocument(reader, null);
		} catch (JiBXException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return object;
	}
	
	/**
	 * Generates the xml from the given object
	 * @param object
	 * @param bindingClass
	 * @param encoding 
	 * @param docTypeName 
	 * @param docTypeSys 
	 * @param characterEscape
	 * @return
	 * @throws XMLBindingException
	 */
	public static String getXml(Object object, Class bindingClass, String encoding, String docTypeName, String docTypeSys, ICharacterEscaper characterEscape ) {
		String xml = null;
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(bindingClass);
			IMarshallingContext mctx = bfact.createMarshallingContext();
			StringWriter sw = new StringWriter();
			mctx.setIndent(6, null, ' ');
			if ( characterEscape != null ) {
				mctx.setOutput(sw, characterEscape );
			} else {
				mctx.setOutput(sw);
			}
			mctx.startDocument(encoding, false);
			if ( docTypeName != null ) {
				mctx.getXmlWriter().writeDocType(docTypeName, docTypeSys, null, null);
			}
			mctx.marshalDocument(object);
			xml = sw.getBuffer().toString();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return xml;
	}
	
}
