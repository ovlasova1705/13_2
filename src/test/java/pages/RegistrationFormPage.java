package pages;

import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationFormPage setFirstName(String value){
        $("#firstName").setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value){
        $("#lastName").setValue(value);
        return this;
    }
    public RegistrationFormPage setUserEmail(String value){
        $("#userEmail").setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value){
        $("#genterWrapper").$(byText("Female")).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value){
        $("#userNumber").setValue("8999999999");
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value){
        $("#subjectsInput").sendKeys("Chemistry");
        $("#subjectsInput").pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value){
        $("#hobbiesWrapper").$(byText("Music")).click();
        return this;
    }
    public RegistrationFormPage uploadFile(String value){
        $("#uploadPicture").uploadFile (new File("src/test/resources/ToolsQA.png"));
        return this;
    }

    public RegistrationFormPage setAddress(String value){
        $("#currentAddress").setValue("qwerty");
        return this;
    }

    public RegistrationFormPage setState(String value){
        $("#state").click();
        $(byText("NCR")).click();
        return this;
    }

    public RegistrationFormPage setCity(String value){
        $("#city").click();
        $(byText("Delhi")).click();
        return this;
    }

    public RegistrationFormPage submitForm(){
        $("#submit").click();
        return this;
    }
    public RegistrationFormPage checkFormOpened(String value){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }


    public RegistrationFormPage checkResult(String key, String value) {
       resultsTableComponent.checkResult(key,value);
       return this;
    }
}
