package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.ElementArchitectural;

/**
 * Created on 03/02/17.
 */
public class Composant extends ElementArchitectural {

    protected Port portFourni    = new Port();
    protected Port portRequis    = new Port();

    public Composant(Configuration configuration) {
        super(configuration);
        this.interfaces.add(portFourni);
        this.interfaces.add(portRequis);
    }

    public Port getPortFourni() {
        return this.portFourni;
    }

    public Port getPortRequis() {
        return this.portRequis;
    }
}
