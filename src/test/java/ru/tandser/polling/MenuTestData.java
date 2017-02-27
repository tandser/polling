package ru.tandser.polling;

import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.util.Matcher;

import java.util.Objects;

import static java.lang.Boolean.TRUE;
import static java.time.LocalDateTime.now;
import static ru.tandser.polling.EstablishmentTestData.*;

public class MenuTestData {

    public static Menu menu1           = new Menu(1,    "Corned beef tongue", "Cod en papillote",  "Fresh squeezed juice",        "Meyer lemon meringue pie",   7800, establishment1, null, null,  TRUE, 0);
    public static Menu menu2           = new Menu(2,    "Seared tuna salad",  "Pot of mussels",    "Organic strawberry lemonade", "Caramelized apple pie",      7200, establishment2, null, null,  TRUE, 0);
    public static Menu menu3           = new Menu(3,    "Baccala",            "Tagliolini",        "Sweet greens and lemon",      "Bomboloni",                  6800, establishment3, null, null,  TRUE, 0);
    public static Menu menu4           = new Menu(4,    "Crudo di passera",   "Pollo arrosto",     "Green juice",                 "Gelati",                     7000, establishment4, null, null,  TRUE, 0);
    public static Menu newMenu         = new Menu(null, "Chicken salad",      "Grilled swordfish", "Banana ginger smoothie",      "Sticky toffee parsnip cake", 7900, establishment1, null, now(), TRUE, 0);
    public static Menu updatedMenu     = new Menu(1,    "Corned beef tongue", "Cod en papillote",  "Fresh squeezed juice",        "Meyer lemon meringue pie",   7700, establishment1, null, now(), TRUE, 0);
    public static Menu nonExistentMenu = new Menu(0,    "Salade verte",       "Spaghetti",         "Orange juice",                "Tarte vaucluse",             6700, establishment1, null, null,  TRUE, 0);
    public static Menu conflictedMenu  = new Menu(2,    "Seared tuna salad",  "Pot of mussels",    "Organic strawberry lemonade", "Caramelized apple pie",      7400, establishment2, null, now(), TRUE, 1);

    public static final Matcher<Menu> MENU_MATCHER = new Matcher<>(Menu.class, (expected, actual) ->
            expected == actual || (Objects.equals(expected.getAppetizer(), actual.getAppetizer()) &&
                                   Objects.equals(expected.getEntree(),    actual.getEntree())    &&
                                   Objects.equals(expected.getBeverage(),  actual.getBeverage())  &&
                                   Objects.equals(expected.getDessert(),   actual.getDessert())   &&
                                   Objects.equals(expected.getPrice(),     actual.getPrice())     &&
                                   Objects.equals(expected.getEnabled(),   actual.getEnabled())));

    private MenuTestData() {}
}