package fr.miage.archicomposant.meta.base;

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
    }

    @Override
    public void actualiser(Observable observable) {

        if (observable.equals(roleFourni)) {
            this.roleRequis.transmit(this.roleFourni.readMessage());
        }

        if (observable.equals(roleRequis)) {
            this.roleFourni.transmit(this.roleRequis.readMessage());
        }

    }
}
