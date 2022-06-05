package tests;

import com.github.javafaker.Faker;
import utils.RandomGen;

public class TestData {

    public final static String FIRST_NAME = "Olga",
   LAST_NAME = "Vlasova";

    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String userNumber = String.valueOf(faker.number().randomNumber(10, true));
    String Year = String.valueOf(faker.number().numberBetween(1900, 2022));
    String Month = RandomGen.randomMonths();
    String Day = "17";
    String Subject = RandomGen.randomSubject();
    String hobby = RandomGen.randomHobby();
    String fileName = "src/test/resources/ToolsQA.png";
    String currentAddress = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";

}
