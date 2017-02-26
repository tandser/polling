package ru.tandser.polling;

import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.util.Matcher;
import ru.tandser.polling.web.json.JsonConverter;

import java.util.Iterator;
import java.util.Objects;

import static org.springframework.util.ResourceUtils.getFile;

public class MenuTestData {

    public static Menu menu1;
    public static Menu menu2;
    public static Menu menu3;
    public static Menu menu4;

    public static final Matcher<Menu> MENU_MATCHER = new Matcher<>(Menu.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getAppetizer(), actual.getAppetizer()) &&
                                   Objects.equals(expected.getEntree(),    actual.getEntree())    &&
                                   Objects.equals(expected.getBeverage(),  actual.getBeverage())  &&
                                   Objects.equals(expected.getDessert(),   actual.getDessert())   &&
                                   Objects.equals(expected.getPrice(),     actual.getPrice())     &&
                                   Objects.equals(expected.getEnabled(),   actual.getEnabled())));

    private MenuTestData() {}

    public static void loadMocks() throws Exception {
        Iterator<Menu> mocks = JsonConverter.fromJsonToList(getFile("classpath:mock/menus.json"), Menu.class).iterator();

        menu1 = mocks.next();
        menu2 = mocks.next();
        menu3 = mocks.next();
        menu4 = mocks.next();
    }
}