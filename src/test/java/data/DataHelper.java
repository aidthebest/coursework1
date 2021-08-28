package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {



    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.address().cityName();
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }
}
