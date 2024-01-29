package pages.components;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
public class BaseComponent {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
//        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
    }
}
