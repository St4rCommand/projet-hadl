package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.Interface;

/**
 * Created by E130160D on 03/02/17.
 */
public class Port extends Interface {
    protected Port Binded ;

    public Port getBinded() {
        return Binded;
    }

    public void setBinded(Port binded) {
        Binded = binded;
    }
}
