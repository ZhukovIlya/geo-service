package ru.netology.geo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class GeoServiceImplTest {
    public static final String LOCALHOST = "127.0.0.1";
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";

//    Написать тесты для проверки определения локации по ip (класс GeoServiceImpl)
//    Проверить работу метода public Location byIp(String ip)

    @Test
    void byIp_LOCALHOST() {
        assertNull(new GeoServiceImpl().byIp(LOCALHOST).getCountry());
    }

    @Test
    void byIp_MOSCOW_IP() {
        assertEquals(RUSSIA, new GeoServiceImpl().byIp(MOSCOW_IP).getCountry());

    }

    @Test
    void byIp_NEW_YORK_IP() {
        assertEquals(USA, new GeoServiceImpl().byIp(NEW_YORK_IP).getCountry());

    }
}