package steps;

import static config.DataSetter.configuration;

import base.BaseStep;
import context.Usuario;
import helpers.StepHelper;
import helpers.XMLHelper;
import pages.HomePage;
import pages.LoginPage;

public class GenerarInvitacionStep extends BaseStep {
	
	public static void Run(String rol, String testName) {
		log.Log.startTestCase(testName);
		log.Log.info("Navegar al sitio");
		Usuario usr = XMLHelper.object.getUsuario();
		NavigateToSite(configuration.getAmbiente_testing()+ "/" + rol);
		CurrentPage = (new LoginPage().GetInstance(LoginPage.class));
		StepHelper.takeScreenShot(driver, testName);
		CurrentPage.As(LoginPage.class).loginUsser(usr.getEmail(), usr.getPassword());
		CurrentPage = (new HomePage().GetInstance(HomePage.class));
		CurrentPage.As(HomePage.class).entrarMenuInvitaciones();
		StepHelper.takeScreenShot(driver, testName);
		
		log.Log.endTestCase(testName);

	}

}
