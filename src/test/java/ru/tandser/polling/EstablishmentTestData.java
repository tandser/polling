package ru.tandser.polling;

import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.util.Matcher;
import ru.tandser.polling.web.json.JsonConverter;

import java.util.Iterator;
import java.util.Objects;

import static org.springframework.util.ResourceUtils.getFile;

public class EstablishmentTestData {

    public static Establishment establishment1;
    public static Establishment establishment2;
    public static Establishment establishment3;
    public static Establishment establishment4;
    public static Establishment newEstablishment;
    public static Establishment updatedEstablishment;
    public static Establishment nonExistentEstablishment;
    public static Establishment conflictedEstablishment;

    public static final Matcher<Establishment> ESTABLISHMENT_MATCHER = new Matcher<>(Establishment.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getName(),    actual.getName())    &&
                                   Objects.equals(expected.getAddress(), actual.getAddress()) &&
                                   Objects.equals(expected.getPhone(),   actual.getPhone())   &&
                                   Objects.equals(expected.getWebsite(), actual.getWebsite()) &&
                                   Objects.equals(expected.getEnabled(), actual.getEnabled())));

    private EstablishmentTestData() {}

    public static void loadMocks() throws Exception {
        Iterator<Establishment> mocks = JsonConverter.fromJsonToList(getFile("classpath:mock/establishments.json"), Establishment.class).iterator();

        establishment1           = mocks.next();
        establishment2           = mocks.next();
        establishment3           = mocks.next();
        establishment4           = mocks.next();
        newEstablishment         = mocks.next();
        updatedEstablishment     = mocks.next();
        nonExistentEstablishment = mocks.next();
        conflictedEstablishment  = mocks.next();
    }
}