package docs;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize ="1263x601";
    }

    @Test
    void successfullTest() {
        String name = "Alex";
     open( "/text-box");
     executeJavaScript("$('footer').remove()");
     executeJavaScript("$('#fixedban').remove()");

     $("[id=userName]").setValue(name);
     $("[id=userEmail]").setValue("test@test.ru");
     $("[id=currentAddress]").setValue("Penkova,20");
     $("[id=permanentAddress]").setValue("Tverskaya,1");
     $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name),text("test@test.ru"),
                text("Penkova,20"), text("Tverskaya,1"));

    }


}
