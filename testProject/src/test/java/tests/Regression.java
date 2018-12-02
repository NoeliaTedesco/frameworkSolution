package tests;

import org.junit.Test;
import components.Hook;
import steps.GenerarInvitacionStep;

public class Regression extends Hook {

	 String rol = "prestadores";
	
		@Test
	    public void generateInvitation() {
	       GenerarInvitacionStep.Run(rol, testName.getMethodName());
	    }
}
