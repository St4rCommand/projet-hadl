package fr.miage.archicomposant.meta.behaviour;

/**
 * Created on 03/03/17.
 */
public interface Observable {

    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers();
    int getState();
    String readMessage();
}
