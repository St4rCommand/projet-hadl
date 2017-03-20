package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.derived.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 03/02/16.
 */
public abstract class ElementArchitectural {

    protected List<Propriete> proprietes = new ArrayList<>();
    protected List<Interface> interfaces = new ArrayList<>();
    protected Configuration configurationParent;

    public ElementArchitectural(Configuration configurationParent) {
        this.configurationParent = configurationParent;
    }

    public void addPropriete(Propriete propriete) {
        this.proprietes.add(propriete);
    }

    public void addInterface(Interface inter) {
        this.interfaces.add(inter);
    }
}
