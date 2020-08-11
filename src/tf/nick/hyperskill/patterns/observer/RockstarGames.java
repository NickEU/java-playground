package tf.nick.hyperskill.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Observable - Rockstar Games
**/
class RockstarGames implements Observable {
    private String releaseGame;
    private final List<Observer> observers = new ArrayList<>();

    public void release(String game) {
        this.releaseGame = game;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            System.out.println("Notification for gamer : " + o);
            o.update(releaseGame);
        }
    }
}
