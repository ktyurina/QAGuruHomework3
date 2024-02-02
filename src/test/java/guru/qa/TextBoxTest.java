package guru.qa;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import guru.qa.config.TestConfig;

public class TextBoxTest extends TestConfig {
    TextBoxPage textBoxPage = new TextBoxPage();
        @Test
        void fillFormTest() {
            textBoxPage.openPage()
                    .setUserName("Vincent")
                    .setUserEmail("vvv@rrrr.ggg")
                    .setCurrentAddress("FF street 12")
                    .setPermanentAddress("FF street 7")
                    .submit()

                    //Check
                    .checkResult("name", "Vincent")
                    .checkResult("email", "vvv@rrrr.ggg")
                    .checkResult("currentAddress", "FF street 12")
                    .checkResult("permanentAddress", "FF street 7");
        }

    }
