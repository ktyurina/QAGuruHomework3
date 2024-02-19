package guru.qa;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;
public class SelenideDragAndDropTest {
    @Test
    void actionsDragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
    @Test
    void dragAndDropBoxesTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

}
