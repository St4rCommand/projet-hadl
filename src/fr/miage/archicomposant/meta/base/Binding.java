package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.behaviour.Observer;
import fr.miage.archicomposant.meta.derived.Port;
import fr.miage.archicomposant.meta.derived.Role;

/**
 * Created by romain on 30/03/17.
 */
public class Binding implements Observer {

    protected Port port1;
    protected Port port2;
    protected Message lastMessage;

    public Binding (Port port1, Port port2) {
        this.port1 = port1;
        this.port2 = port2;

        port1.addObserver(this);
        port2.addObserver(this);
    }

    @Override
    public void actualiser(Observable observable) {

        if (! (observable instanceof Port)) {
            return;
        }

        if (this.port2.getState() == InterfaceState.MESSAGE_TO_SEND && !this.port2.getMessageToSend().equals(this.lastMessage)) {
            this.lastMessage = this.port2.getMessageToSend();
            this.port1.transmit(this.port2.getMessageToSend());
        } else if (this.port1.getState() == InterfaceState.MESSAGE_TO_SEND && !this.port1.getMessageToSend().equals(this.lastMessage)) {
            this.lastMessage = this.port1.getMessageToSend();
            this.port2.transmit(this.port1.getMessageToSend());
        } else if (this.port1.getState() == InterfaceState.MESSAGE_RECEIVED && !this.port1.getMessageReceived().equals(this.lastMessage)) {
            this.lastMessage = this.port1.getMessageReceived();
            this.port2.receive(this.port1.getMessageReceived());
        } else if (this.port2.getState() == InterfaceState.MESSAGE_RECEIVED && !this.port2.getMessageReceived().equals(this.lastMessage)) {
            this.lastMessage = this.port2.getMessageReceived();
            this.port1.receive(this.port2.getMessageReceived());
        }
    }
}