package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E130160D on 03/02/17.
 */
public abstract class Interface implements Observable, Receiver, Transmitter {

    protected String messsage;
    protected List<Observer> observers = new ArrayList<>();
    protected int state;

    public String readMessage() {
        this.state = InterfaceState.WAITING;
        return this.messsage;
    }

    @Override
    public int getState() {
        return this.state;
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

    @Override
    public void receive(String message) {
        System.out.println("Message reçu : "+message);
        this.state = InterfaceState.MESSAGE_RECEIVED;
        this.messsage = message;
        this.notifyObservers();
    }

    @Override
    public void transmit(String message) {
        System.out.println("Message à envoyer : "+message);
        this.state = InterfaceState.MESSAGE_TO_SEND;
        this.messsage = message;
        this.notifyObservers();
    }
}
