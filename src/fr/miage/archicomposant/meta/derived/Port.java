package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.Interface;
import fr.miage.archicomposant.meta.base.Message;
import fr.miage.archicomposant.meta.behaviour.InterfaceState;

/**
 * Class Port
 *
 * Component interface
 */
public class Port extends Interface {

    @Override
    public void receive(Message message) {
        // fixme parfois la valeur n'est pas modifiée ...
        this.state = InterfaceState.MESSAGE_RECEIVED;
        this.messageReceived = message;
        this.notifyObservers();
    }
}
