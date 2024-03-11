package ru.netology.delivery;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Салехард", "Анадырь", "Ханты-Мансийск", "Нарьян-Мар", "Москва",
                "Санкт-Петербург", "Екатеринбург", "Самара", "Ярославль"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName() {
        var names = new String[]{"Иван", "Марк", "Петр", "Кирилл"};
        var surnames = new String[]{"Иванов", "Марков", "Петров", "Кириллов"};
        return surnames[new Random().nextInt(surnames.length)] + " " + names[new Random().nextInt(names.length)];
    }
// сначала сделал генерацию имени-фамилии фейкером, при прогоне теста выбил ошибку - форма не принимает букву Ё
// пришлось делать массив и рандомайзер

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

