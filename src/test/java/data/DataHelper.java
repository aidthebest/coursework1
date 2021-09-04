package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    public static String getApproveCard() {
        return "4444 4444 4444 4441";
    }

    public static String getDeclineCard() {
        return "4444 4444 4444 4442";
    }

    public static String getRandomCardNumber() {
        Faker faker = new Faker(new Locale("en"));
        return faker.business().creditCardNumber();
    }

    public static String getCardHolder() {
        Faker faker = new Faker(new Locale("en"));
        var firstname = faker.name().firstName();
        var lastname = faker.name().lastName();
        return firstname + " " + lastname;
    }

    ;

    public static String getYear() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
        var localDate = LocalDate.now().format(formatter);
        int x = (int) (Math.random() * (6));
        return String.valueOf((Integer.parseInt(localDate) + x));
    }

    public static String getMonth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        var localDate = LocalDate.now().format(formatter);
        Random random = new Random();
        if (DataHelper.getYear().equals(String.valueOf(LocalDate.now().getYear()))) {
            return String.format("%02d", random.nextInt(12 - Integer.parseInt(localDate)) + Integer.parseInt(localDate));
        } else {
            return String.format("%02d", random.nextInt(11) + 1);
        }
    }

    public static String getCvc() {
        Faker faker = new Faker(new Locale("en"));
        return faker.numerify("###");
    }

    public static String getFakeCvc() {
        Faker faker = new Faker(new Locale("en"));
        return faker.numerify("##");
    }

    public static String getFakeValue() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().password(1, 15, true, true, true);
    }
}

