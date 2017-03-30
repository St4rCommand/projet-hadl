package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.behaviour.Observer;
import fr.miage.archicomposant.meta.derived.Role;

/**
 * Created on 03/02/17.
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
