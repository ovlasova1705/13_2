package backUp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestFormTests_BackUp {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1263x601";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfullTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Vlasova");
        $("#userEmail").setValue("test@test.ru");
        //$("#gender-radio-3").parent ().click();
        //$("[for=gender-radio-3]".click();
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1987");
        $(byText("17")).click();
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

        $(".xample-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        /*$(".table-responsive").shouldHave(text("Olga Vlasova"),
                text("test@test.ru"),
                text("Female"),
                text("8999999999"),
                text("17 October,1987"),
                text("Chemistry"),
                text("Music"),
                text("ToolsQA.png"),
                text("qwerty"),
                text("NCR Delhi")
        );*/
        checkTable ("Date of Birth", "05 June,2022");
    }
    void checkTable(String key, String value){
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
    }
}

