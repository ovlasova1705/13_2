package tests;


import org.junit.jupiter.api.Test;

public class TestFormWithFaker extends TestBase{
    @Test
    void successfullTest() {

        registrationFormPage.openPage()
                .setFirstName(Student.firstName)
                .setLastName(Student.lastName)
                .setUserEmail(Student.email)
                .setGender(Student.gender)
                .setUserNumber(Student.userNumber)
                .setDateOfBirth(Student.Day, Student.Month, Student.Year)
                .setSubject(Student.Subject)
                .setHobbies(Student.hobby)
                .uploadFile(Student.fileName)
                .setAddress(Student.currentAddress)
                .setState(Student.state)
                .setCity(Student.city)
                .submitForm()
                .checkFormOpened("Thanks for submitting the form")
                .checkResult("Student Name", Student.firstName + " " + Student.lastName)
                .checkResult("Student Email", Student.email)
                .checkResult("Gender", Student.gender)
                .checkResult("Mobile", Student.userNumber)
                .checkResult("Date of Birth", Student.Day + " " + Student.Month + " " + Student.Year)
                .checkResult("Subjects", Student.Subject)
                .checkResult("Hobbies", Student.hobby)
                .checkResult("Picture", Student.fileName)
                .checkResult("Address", Student.currentAddress)
                .checkResult("State and City", Student.state + " " + Student.city);
    }

}
