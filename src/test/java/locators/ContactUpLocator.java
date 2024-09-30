package locators;

import org.openqa.selenium.By;

public class ContactUpLocator {

   public static final By TXT_EMAIL = By.xpath("//input[@type='email']");

   public static final By BTN_SEND = By.xpath("//button[.='Send']");

   public static final By TXT_ORDER = By.id("id_order");

   public static final By SELECT_LIST = By.id("id_contact");

   public static final By TXT_MENSSAGE = By.xpath("//textarea[@name='message']");

   public static final By  GET_TEXT_FOUND = By.xpath("//p[@class='alert alert-success']");

}
