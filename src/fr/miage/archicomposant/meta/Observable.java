package fr.miage.archicomposant.meta;

/**
 * Created on 03/03/17.
 */
public interface Observable {

    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers();
}