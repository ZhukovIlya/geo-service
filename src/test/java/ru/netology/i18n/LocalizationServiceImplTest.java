package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.entity.Country.*;


class LocalizationServiceImplTest {
//    Написать тесты для проверки возвращаемого текста (класс LocalizationServiceImpl)
//    Проверить работу метода public String locale(Country country)

        @ParameterizedTest
        @EnumSource(Country.class)
        void localeTest(Country country) {
            String expected;
            if (country == Country.RUSSIA) {
                expected = "Добро пожаловать";
            } else {
                expected = "Welcome";
            }
            assertEquals(expected, new LocalizationServiceImpl().locale(country));
        }
}
