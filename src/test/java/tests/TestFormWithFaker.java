package tests;


import org.junit.jupiter.api.Test;


public class TestFormWithFaker extends TestBase{
    @Test
    void successfullTest() {

        registrationFormPage.openPage()
        .setFirstName(var.firstName)
        .setLastName(var.lastName)
        .setUserEmail(var.email)
        .setGender(var.gender)
        .setUserNumber(var.userNumber)
        .setDateOfBirth(var.Day, var.Month, var.Year)
        .setSubject(var.Subject)
        .setHobbies(var.hobby)
        .uploadFile(var.fileName)
        .setAddress(var.currentAddress)
        .setState(var.state)
        .setCity(var.city)
        .submitForm()
        .checkFormOpened("Thanks for submitting the form")
                .checkResult("Student Name", var.firstName + " " + var.lastName)
                .checkResult("Student Email", var.email)
                .checkResult("Gender", var.gender)
                .checkResult("Mobile", var.userNumber)
                .checkResult("Date of Birth",var.Day+ " "+var.Month+ " "+ var.Year)
                .checkResult("Subjects", var.Subject)
                .checkResult("Hobbies",var.hobby)
                .checkResult("Picture",var.fileName)
                .checkResult("Address", var.currentAddress)
                .checkResult("State and City",var.state +" "+ var.city);
    }

}
