package ru.tandser.polling;

import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.util.Matcher;

import java.util.Objects;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;

public class EstablishmentTestData {

    public static Establishment establishment1           = new Establishment(1,    "Dovetail",        "103 W 77th St, New York, NY 10024",      "+1 212-362-3800", "http://www.dovetailnyc.com",    null, null,  TRUE, 0);
    public static Establishment establishment2           = new Establishment(2,    "The Smith",       "1900 Broadway, New York, NY 10023",      "+1 212-496-5700", "http://thesmithrestaurant.com", null, null,  TRUE, 0);
    public static Establishment establishment3           = new Establishment(3,    "Marea",           "240 Central Park S, New York, NY 10019", "+1 212-582-5100", "http://www.marea-nyc.com",      null, null,  TRUE, 0);
    public static Establishment establishment4           = new Establishment(4,    "Ai Fiori",        "400 5th Ave #2, New York, NY 10018",     "+1 212-613-8660", "http://aifiorinyc.com",         null, null,  TRUE, 0);
    public static Establishment newEstablishment         = new Establishment(null, "Gramercy Tavern", "42 E 20th St, New York, NY 10003",       "+1 212-477-0777", "http://www.gramercytavern.com", null, now(), TRUE, 0);
    public static Establishment updatedEstablishment     = new Establishment(1,    "Dovetail",        "103 W 77th St, New York, NY 10024",      "+1 212-362-3800", "http://www.dovetailnyc.com",    null, now(), TRUE, 0);
    public static Establishment nonExistentEstablishment = new Establishment(0,    "Vaucluse",        "100 E 63rd St, New York, NY 10065",      "+1 646-869-2300", "http://vauclusenyc.com",        null, null,  TRUE, 0);
    public static Establishment conflictedEstablishment  = new Establishment(2,    "The Smith",       "1900 Broadway, New York, NY 10023",      "+1 212-496-5700", "http://thesmithrestaurant.com", null, now(), TRUE, 1);

    public static final Matcher<Establishment> ESTABLISHMENT_MATCHER = new Matcher<>(Establishment.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getName(),    actual.getName())    &&
                                   Objects.equals(expected.getAddress(), actual.getAddress()) &&
                                   Objects.equals(expected.getPhone(),   actual.getPhone())   &&
                                   Objects.equals(expected.getWebsite(), actual.getWebsite()) &&
                                   Objects.equals(expected.getEnabled(), actual.getEnabled())));

    private EstablishmentTestData() {}
}