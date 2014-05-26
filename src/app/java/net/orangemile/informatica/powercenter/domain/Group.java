package net.orangemile.informatica.powercenter.domain;

public class Group implements Cloneable {



	private String name;
	private String description;
	private String order;
	private String type;
	private String expression;
	
	// Group constructor, added by Duane Crowe on 10/28/2009
	public Group(String name, String description, String order, String type,
			String expression) {
		super();
		this.name = name;
		this.description = description;
		this.order = order;
		this.type = type;
		this.expression = expression;
	}
	
	public Group(){
	}
	
	
	
	public Group(String name, String description, String order, String type) {
		super();
		this.name = name;
		this.description = description;
		this.order = order;
		this.type = type;
	}
	
	public Group(String name,  String order, String type) {
		super();
		this.name = name;
		this.description = name;
		this.order = order;
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
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
