package net.orangemile.informatica.powercenter.pattern;

import net.orangemile.informatica.powercenter.domain.Box;
import net.orangemile.informatica.powercenter.domain.Field;

public interface AddColumnPatternCallback {

	public void callback( Box box, Field newField, String exampleFieldName);
	
}
