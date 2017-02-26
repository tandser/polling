package ru.tandser.polling;

import ru.tandser.polling.domain.Establishment;
import ru.tandser.polling.domain.Menu;
import ru.tandser.polling.domain.User;
import ru.tandser.polling.domain.Vote;
import ru.tandser.polling.web.json.JsonConverter;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("Scott Welch");
        user.setEmail("s.welch@gmail.com");
        user.setPassword("Izhyw29");
        user.setRole(User.Role.USER);
        user.setCreated(LocalDateTime.now());
        user.setEnabled(true);

        Establishment establishment1 = new Establishment();
        establishment1.setId(1);
        establishment1.setName("Dovetail");
        establishment1.setAddress("103 W 77th St, New York, NY 10024");
        establishment1.setPhone("+1 212-362-3800");
        establishment1.setWebsite("http://www.dovetailnyc.com");
        establishment1.setCreated(LocalDateTime.now());
        establishment1.setEnabled(true);

        Establishment establishment2 = new Establishment();
        establishment2.setId(2);
        establishment2.setName("The Smith");
        establishment2.setAddress("1900 Broadway, New York, NY 10023");
        establishment2.setPhone("+1 212-496-5700");
        establishment2.setWebsite("http://thesmithrestaurant.com");
        establishment2.setCreated(LocalDateTime.now());
        establishment2.setEnabled(true);

        Menu menu1 = new Menu();
        menu1.setId(1);
        menu1.setAppetizer("Corned beef tongue");
        menu1.setEntree("Cod en papillote");
        menu1.setBeverage("Fresh squeezed juice");
        menu1.setDessert("Meyer lemon meringue pie");
        menu1.setPrice(7800);
        menu1.setCreated(LocalDateTime.now());
        menu1.setEnabled(true);

        Menu menu2 = new Menu();
        menu2.setId(2);
        menu2.setAppetizer("Seared tuna salad");
        menu2.setEntree("Pot of mussels");
        menu2.setBeverage("Organic strawberry lemonade");
        menu2.setDessert("Caramelized apple pie");
        menu2.setPrice(7200);
        menu2.setCreated(LocalDateTime.now());
        menu2.setEnabled(true);

        establishment1.setMenus(Arrays.asList(menu1));
        establishment2.setMenus(Arrays.asList(menu2));

        menu1.setEstablishment(establishment1);
        menu2.setEstablishment(establishment2);

        Vote vote1 = new Vote();
        vote1.setId(1);
        vote1.setMenu(menu1);
        vote1.setUser(user);
        vote1.setRating(4);
        vote1.setCreated(LocalDateTime.now());
        vote1.setEnabled(true);

        Vote vote2 = new Vote();
        vote2.setId(2);
        vote2.setMenu(menu2);
        vote2.setUser(user);
        vote2.setRating(5);
        vote2.setCreated(LocalDateTime.now());
        vote2.setEnabled(true);

        user.setVotes(Arrays.asList(vote1, vote2));

        String json = JsonConverter.toJson(vote1);
        System.out.println(json);
    }
}