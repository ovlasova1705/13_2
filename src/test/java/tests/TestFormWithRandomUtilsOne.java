package tests;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class TestFormWithRandomUtilsOne extends TestBase{
    @Test
    void successfullTest() {
        //open("/automation-practice-form");
        //$(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //executeJavaScript("$('footer').remove()");
        //executeJavaScript("$('#fixedban').remove()");
        //$("#firstName").setValue("Olga");
        // $("#lastName").setValue("Vlasova");
        //$("#userEmail").setValue("test@test.ru");
        //$("#userEmail").setValue("test@test.ru");
        //$("#userNumber").setValue("8999999999");
        //$("#genterWrapper").$(byText("Female")).click();
        //$("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").selectOption("October");
        //$(".react-datepicker__year-select").selectOption("1987");
        //$(byText("17")).click();
        //$("#subjectsInput").sendKeys("Chemistry");
        //$("#subjectsInput").pressEnter();
        //$("#hobbiesWrapper").$(byText("Music")).click();
        //$("#uploadPicture").uploadFile (new File("src/test/resources/ToolsQA.png"));
        //$("#currentAddress").setValue("qwerty");
        //$("#state").click();
        //$(byText("NCR")).click();
        //$("#city").click();
        //$(byText("Delhi")).click();

        //$("#submit").click();

        //$("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

          /*$(".table-responsive").shouldHave(text("Olga"),
                text("Vlasova"),
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

        String firstName = getRandomString(10);
        String lastName = getRandomString(10);
        String email = getRandomEmail();

        registrationFormPage.openPage()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setUserEmail(email)
        .setGender("Female")
        .setUserNumber("8999999999")
        .setDateOfBirth("17", "October", "1987")
        .setSubject("Chemistry")
        .setHobbies("Music")
        .uploadFile("src/test/resources/ToolsQA.png")
        .setAddress("qwerty")
        .setState("NCR")
        .setCity("Delhi")
        .submitForm()
        .checkFormOpened("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender","Female")
                .checkResult("Mobile","8999999999")
                .checkResult("Date of Birth","17 October,1987")
                .checkResult("Subjects","Chemistry")
                .checkResult("Hobbies","Music")
                .checkResult("Picture","ToolsQA.png")
                .checkResult("Address","qwerty")
                .checkResult("State and City","NCR Delhi");


    }

}
