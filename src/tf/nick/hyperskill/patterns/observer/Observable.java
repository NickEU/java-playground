package tf.nick.hyperskill.patterns.observer;

/**
 * Observable interface
**/
interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
