package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.derived.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * ElementArchitectural
 *
 * We use composite pattern
 */
public abstract class ElementArchitectural {

    protected List<Properties> properties = new ArrayList<>();
    protected List<Interface> interfaces = new ArrayList<>();
    protected Configuration configurationParent;

    public ElementArchitectural(Configuration configurationParent) {
        this.configurationParent = configurationParent;
    }

    public void addPropriete(Properties properties) {
        this.properties.add(properties);
    }

    public void addInterface(Interface inter) {
        this.interfaces.add(inter);
    }
}
