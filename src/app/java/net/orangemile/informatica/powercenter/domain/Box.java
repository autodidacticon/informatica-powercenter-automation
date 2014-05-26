package net.orangemile.informatica.powercenter.domain;

import java.util.List;

public interface Box {

	public String getName();
	
	public String getInstanceType();
	
	public List<? extends Field> getInputPorts();
	
	public List<? extends Field> getOutputPorts();	
	
}
