package ru.tandser.polling;

import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.web.json.JsonConverter;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Establishment establishment = new Establishment();
        establishment.setName("Dovetail");
        establishment.setAddress("103 W 77th St, New York, NY 10024");
        establishment.setPhone("+1 212-362-3800");
        establishment.setWebsite("http://www.dovetailnyc.com");
        establishment.setCreated(LocalDateTime.now());
        establishment.setEnabled(Boolean.TRUE);

        String s = JsonConverter.toJson(establishment);

        System.out.println(s);
    }
}