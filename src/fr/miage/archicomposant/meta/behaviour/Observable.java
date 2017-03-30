package fr.miage.archicomposant.meta.behaviour;

import fr.miage.archicomposant.meta.base.Message;

/**
 * Interface Observable
 */
public interface Observable {

    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers();
    int getState();
    Message getMessageToSend();
}
