package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

    public static String getCvc() {
        Faker faker = new Faker(new Locale("en"));
        return faker.numerify("###");
    }

    public static String getFakeCvc() {
        Faker faker = new Faker(new Locale("en"));
        return faker.numerify("##");
    }

    public static String getFakeHolder() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().password(1, 15, true, true, true);
    }

    public static String getFakeCardNumber() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().password(1, 15, true, true, true);
    }

    @Value
    public static class DateInfo {
        String month;
        String year;
    }

    public static DateInfo generateDate(int monthShift) {
        var cardDate = LocalDate.now().plusMonths(monthShift);
        return new DateInfo(cardDate.format(DateTimeFormatter.ofPattern("MM")),
                cardDate.format(DateTimeFormatter.ofPattern("yy")));
    }
}


;

//    public static String getYear() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
//        int validYearAdd = (int) (Math.random() * (6));
//        return LocalDate.now().plusYears(validYearAdd).format(formatter);
//    }
//
//    public static String getInvalidYearAbove() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
//        int minDifference = 6;
//        int maxDifference = 94;
//        maxDifference -= minDifference;
//        int year = (int) ((Math.random() * ++maxDifference) + minDifference);
//        return LocalDate.now().plusYears(year).format(formatter);
//    }
//
//    public static String getInvalidYearBefore() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
//        int randomYear = Integer.parseInt(LocalDate.now().format(formatter));
//        int minusYear = (int) (Math.random() * (randomYear + 1));
//        return LocalDate.now().minusYears(minusYear).format(formatter);
//    }
//
//
//    public static String getyearTEST(int year) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy");
//        return LocalDate.now().plusYears(year).format(formatter);
//    }
//
//    public static String getMonthTEST(int month) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
//        return LocalDate.now().plusMonths(month).format(formatter);
//    }

//
//    public static String getMonth() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
//        var localDate = LocalDate.now().format(formatter);
//        Random random = new Random();
//        if (DataHelper.getYear().equals(String.valueOf(LocalDate.now().getYear()))) {
//            return String.format("%02d", random.nextInt(12 - Integer.parseInt(localDate)) + Integer.parseInt(localDate));
//        } else {
//            return String.format("%02d", random.nextInt(11) + 1);
//        }
//    }
//
//    public static String getInvalidMonth() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
//        var localDate = LocalDate.now().format(formatter);
//        Random random = new Random();
//        if (DataHelper.getMonth().equals(String.valueOf(LocalDate.now().getMonth())) &&
//                DataHelper.getYear().equals(String.valueOf(LocalDate.now().getYear()))) {
//            return String.format("%02d", (Integer.parseInt(localDate) - (random.nextInt(12 - Integer.parseInt(localDate)))));
//        } else {
//            return String.format("%02d", random.nextInt(87) + 13);
//        }
//    }
