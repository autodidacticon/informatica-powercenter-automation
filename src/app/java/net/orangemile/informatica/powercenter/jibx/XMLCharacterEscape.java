package net.orangemile.informatica.powercenter.jibx;

import java.io.IOException;
import java.io.Writer;

import org.jibx.runtime.ICharacterEscaper;

public class XMLCharacterEscape implements ICharacterEscaper {

	public void writeAttribute(String str, Writer io) throws IOException {
		io.write(normalize(str));
	}

	public void writeCData(String str, Writer io) throws IOException {
		io.write(normalize(str));	}

	public void writeContent(String str, Writer io) throws IOException {
		io.write(normalize(str));
	}

	private String normalize( String str ) {
		// &#xD; carriage return
		// &#xA; line feed
		// &#x9; tab
		str = str.replaceAll("\n", "\\&#xD;&#xA;");
		str = str.replaceAll("\t", "&#x9;");
		return str;
	}
	
}
