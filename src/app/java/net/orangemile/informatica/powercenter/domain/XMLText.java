package net.orangemile.informatica.powercenter.domain;

import net.orangemile.informatica.powercenter.domain.constant.XMLTextType;

public class XMLText implements Cloneable {

	private XMLTextType type;
	private String namespace;
	private String text;

	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public XMLTextType getType() {
		return type;
	}
	public void setType(XMLTextType type) {
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
