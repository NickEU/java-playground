package tf.nick.hyperskill.patterns.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * Concrete observer - Gamer
**/
class Gamer implements Observer {
    private final String name;
    private final Set<String> games = new HashSet<>();

    public Gamer(String name) {
        this.name = name;
    }

    @Override
    public void update(String game) {
        buyGame(game);
    }

    public void buyGame(String game) {
        String response = games.add(game)
            ? name + " says : \"Oh, Rockstar releases new game " + game + " !\""
            : "What? They've already released this game ... I don't understand";
        System.out.println(response);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
