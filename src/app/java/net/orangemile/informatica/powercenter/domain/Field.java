package net.orangemile.informatica.powercenter.domain;

public interface Field {

	public String getName();
	
	public String getDataType();
	
	public int getPrecision();
	
	public int getScale();
	
	public void setName( String name );
	
	public void setDataType( String dataType );
	
	public void setPrecision( int precision );
	
	public void setScale( int scale );
}
