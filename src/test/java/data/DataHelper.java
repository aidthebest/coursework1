package data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataHelper {

    public static String getApproveCard () {
        return "4444 4444 4444 4441";
    }

    public static String getDeclineCard () {
        return "4444 4444 4444 4442";
    }

    public static String getRandomCardNumber () {
        Faker faker = new Faker(new Locale("en"));
        return faker.business().creditCardNumber();
    }

    public static String getCardHolder() {
        Faker faker = new Faker(new Locale("en"));
        var firstname= faker.name().firstName();
        var lastname = faker.name().lastName();
        return firstname+" "+lastname;
    };

    public static String getYear() {
        return String.valueOf(Math.random()*(26-22) + 22);
    }

    public static String getMonth() {
        Random random = new Random();
        return String.format("%02d", random.nextInt(11) + 1);
    }

    public static String getCvc() {
        Faker faker = new Faker(new Locale("en"));
        return faker.numerify("###");
    }

    public static String getFakeCvc() {
        Faker faker = new Faker(new Locale("en"));
        return faker.numerify("##");
    }

    public static String getFakeValue () {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().password(1, 15, true, true, true);
    }
}

