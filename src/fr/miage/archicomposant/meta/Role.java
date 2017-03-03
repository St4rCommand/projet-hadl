package fr.miage.archicomposant.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E130160D on 03/02/17.
 */
public class Role extends Interface implements Observable {

    protected List<Observer> observers = new ArrayList<>();

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
