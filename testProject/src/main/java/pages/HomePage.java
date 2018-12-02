package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {
	
		@FindBy (css = "#main > div > div > div.container-fluid.main-full > div > div > div.col-xs-12.col-md-5 > div > div > div > button")
		private WebElement menuInvitaciones;
		
		private WebElement btnSalir;
		
		private WebElement btnCambiarContrasena;
		
		private WebElement labelUsuario;
		
		
		public void entrarMenuInvitaciones() {
			//wait.until(ExpectedConditions.elementToBeClickable(menuInvitaciones));
			//menuInvitaciones.click();
		}
		
		
		 
}
