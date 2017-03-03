package fr.miage.archicomposant.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E130160D on 03/02/17.
 */
public class Port extends Interface implements Observable {
    protected Port Binded ;
    protected Role Attached;
    protected String messsage;
    protected List<Observer> observers = new ArrayList<>();

    public String getMessage() {
        return this.messsage;
    }

    public void setMessage(String message) {
        this.messsage = message;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: this.observers
                ) {
            observer.actualiser(this);
        }
    }
}
