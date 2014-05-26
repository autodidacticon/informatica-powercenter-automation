package net.orangemile.informatica.powercenter.domain;

import java.util.ArrayList;

import net.orangemile.informatica.powercenter.domain.constant.XMLInfoType;

public class XMLInfo implements Cloneable {

	private ArrayList<XMLText> xmlTextList;
	private XMLInfoType type;
	private String text;
	
	public ArrayList<XMLText> getXmlTextList() {
		return xmlTextList;
	}

	public void setXmlTextList(ArrayList<XMLText> xmlTextList) {
		this.xmlTextList = xmlTextList;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public XMLInfoType getType() {
		return type;
	}

	public void setType(XMLInfoType type) {
		this.type = type;
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
