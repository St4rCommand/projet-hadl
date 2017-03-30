package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.behaviour.Observer;
import fr.miage.archicomposant.meta.derived.Role;

/**
 * Class Glue
 *
 * Link between two roles
 */
public class Glue implements Observer {

    protected Role roleRequis;
    protected Role roleFourni;

    public Glue(Role roleRequis, Role roleFourni) {
        this.roleFourni = roleFourni;
        this.roleRequis = roleRequis;

        this.roleRequis.addObserver(this);
        this.roleFourni.addObserver(this);
    }

    /**
     * Watch roles. If one receive a message, give the message to the other
     *
     * @param observable Observable
     */
    @Override
    public void actualiser(Observable observable) {


        if (! (observable instanceof Role)) {
            return;
        }

        Role role = (Role) observable;

        if (role.getState() != InterfaceState.MESSAGE_RECEIVED) {
            return;
        }

        if (role.equals(roleFourni)) {
            this.roleRequis.transmit(this.roleFourni.getMessageReceived());
        }

        if (role.equals(roleRequis) && role.getState() == InterfaceState.MESSAGE_RECEIVED) {
            this.roleFourni.transmit(this.roleRequis.getMessageReceived());
        }

    }
}
