package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.behaviour.Observer;
import fr.miage.archicomposant.meta.derived.Port;
import fr.miage.archicomposant.meta.derived.Role;

/**
 * Class Attachment
 *
 * Link between a role and a port
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

    /**
     * Transmit message from port to role or from role to port
     *
     * @param observable Observable
     */
    @Override
    public void actualiser(Observable observable) {
        if (observable instanceof Role && this.role.getState() == InterfaceState.MESSAGE_TO_SEND) {
            this.port.receive(this.role.getMessageToSend());
        } else if (observable instanceof Port && this.port.getState() == InterfaceState.MESSAGE_TO_SEND) {
            this.role.receive(this.port.getMessageToSend());
        }
    }
}
