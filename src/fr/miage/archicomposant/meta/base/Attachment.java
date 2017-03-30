package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.behaviour.Observer;
import fr.miage.archicomposant.meta.derived.Port;
import fr.miage.archicomposant.meta.derived.Role;

/**
 * Created on 03/03/17.
 */
public class Attachment implements Observer {
    protected Port port;
    protected Role role;

    public Attachment (Port port, Role role) {
        this.role = role;
        this.port = port;

        port.addObserver(this);
        role.addObserver(this);
    }

    @Override
    public void actualiser(Observable observable) {
        if (observable instanceof Role && this.role.getState() == InterfaceState.MESSAGE_TO_SEND) {
            this.port.receive(this.role.getMessageToSend());
        } else if (observable instanceof Port && this.port.getState() == InterfaceState.MESSAGE_TO_SEND) {
            this.role.receive(this.port.getMessageToSend());
        }
    }
}
