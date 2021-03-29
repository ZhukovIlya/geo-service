package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

class MessageSenderImplTest {

//    Написать тесты для проверки языка отправляемого сообщения (класс MessageSender) с использованием Mockito
//    Поверить, что MessageSenderImpl всегда отправляет только русский текст, если ip относится к российскому сегменту адресов.

    @Test
    void sendLanguageENG() {
        Location location = Mockito.mock(Location.class);
        String expedit = "Welcome";
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String actyal = messageSender.send(new HashMap<String, String>() {{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        }});
        assertEquals(expedit, actyal);
    }

    //    Поверить, что MessageSenderImpl всегда отправляет только английский текст, если ip относится к американскому сегменту адресов.

    @Test
    void sendLanguageRU() {
        Location location = Mockito.mock(Location.class);
        String expedit = "Добро пожаловать";
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Добро пожаловать");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String actyal = messageSender.send(new HashMap<String, String>() {{
            put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        }});
        assertEquals(expedit, actyal);
    }



//    Написать тесты для проверки возвращаемого текста (класс LocalizationServiceImpl)
//    Проверить работу метода public String locale(Country country)


}