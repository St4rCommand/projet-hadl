package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.Interface;
import fr.miage.archicomposant.meta.base.Message;
import fr.miage.archicomposant.meta.behaviour.InterfaceState;

/**
 * Created by E130160D on 03/02/17.
 */
public class Port extends Interface {

    @Override
    public void receive(Message message) {
        this.state = InterfaceState.MESSAGE_RECEIVED;
        this.messageReceived = message;
        this.notifyObservers();
    }
}
