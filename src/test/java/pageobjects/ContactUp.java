package pageobjects;

import org.openqa.selenium.WebDriver;

import static locators.ContactUpLocator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactUp extends PageBase {

    private WebDriver driver;


    public ContactUp(WebDriver driver) {
        super(driver);
    }

    public void selectChoose(String text) {
        selectListForText(SELECT_LIST, text);
    }
    public void writeEmail(String text) {
        typeText(TXT_EMAIL, text);
    }

    public void writeOrder(String text) {
        typeText(TXT_ORDER, text);
    }

    public void writeMensaje(String text) {
        typeText(TXT_MENSSAGE, text);
    }


    public void ClickBoton() {
        clickElement(BTN_SEND);
    }

    public void validateTextMessage(String text){
         assertEquals(getText(GET_TEXT_FOUND),text);
    }

}
