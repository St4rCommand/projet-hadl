package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E130160D on 03/02/17.
 */
public abstract class Interface implements Observable, Receiver, Transmitter {

    protected Message messageToSend;
    protected Message messageReceived;
    protected List<Observer> observers = new ArrayList<>();
    protected int state;

    public Message getMessageToSend() {
        return messageToSend;
    }

    public Message getMessageReceived() {
        return messageReceived;
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
    public void receive(Message message) {
        this.state = InterfaceState.MESSAGE_RECEIVED;
        this.messageReceived = message;
        this.notifyObservers();
    }

    @Override
    public void transmit(Message message) {
        this.state = InterfaceState.MESSAGE_TO_SEND;
        this.messageToSend = message;
        this.notifyObservers();
    }
}
