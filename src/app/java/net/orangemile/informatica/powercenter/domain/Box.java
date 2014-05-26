package net.orangemile.informatica.powercenter.domain;

import java.util.List;

/**
 * Interface with basic methods common to elements within a mapping such as Sources, Targets and Transformations.
 */
public interface Box {

	public String getName();
	
	public String getInstanceType();
	
	public List<? extends Field> getInputPorts();
	
	public List<? extends Field> getOutputPorts();	
	
}
