package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestFormTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1263x601";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfullTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Vlasova");
        $("#userEmail").setValue("test@test.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1987");
        $(byText("17")).click();
        $(".subjects-auto-complete__input").click();
        $("#subjectsInput").sendKeys("Chemistry");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile (new File("src/test/resources/ToolsQA.png"));
        $("#currentAddress").setValue("qwerty");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-body").shouldHave(text("Olga Vlasova"),
                text("test@test.ru"),
                text("Female"),
                text("8999999999"),
                text("17 October,1987"),
                text("Chemistry"),
                text("Music"),
                text("ToolsQA.jpg"),
                text("qwerty"),
                text("NCR Delhi")
        );
    }
}
