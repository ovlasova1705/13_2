package docs;

import static utils.RandomUtils.*;

public class RandomUtilExamples {
    public static void main(String[] args){
        System.out.println("Random string 10: " + getRandomString(10));
        System.out.println("Random message 90-100: " + getRandomMessage(90, 100));
        System.out.println("Random Int 3-20: " + getRandomInt(3, 20));
        System.out.println("Random email: " + getRandomEmail());
    }

}
