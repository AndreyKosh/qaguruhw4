import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $$("div.column").first().shouldHave(text("A"));
        $$("div.column").last().shouldHave(text("B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        $$("div.column").first().shouldHave(text("B"));
        $$("div.column").last().shouldHave(text("A"));
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }
}
