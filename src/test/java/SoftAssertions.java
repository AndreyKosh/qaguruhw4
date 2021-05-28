import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertions {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionsTest(){
        open("https://github.com/selenide/selenide");
        $("[data-tab-item=i4wiki-tab]").click();
        $(byText("Show 1 more pages…")).click();
        $$("#wiki-pages-box li a").find(text("SoftAssertions")).click();
        $$("#wiki-body li").shouldHave(itemWithText("Using JUnit5 extend test class:"));
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }
}
