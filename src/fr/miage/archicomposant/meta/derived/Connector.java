package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.ElementArchitectural;
import fr.miage.archicomposant.meta.base.Glue;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Connector
 *
 * Connector uses between components
 */
public class Connector extends ElementArchitectural {

    protected Map<Integer, Role> roles = new HashMap<>();
    protected Glue glue;

    public Connector(Configuration configurationParent) {
        super(configurationParent);
        this.roles.put(1, new Role());
        this.roles.put(2, new Role());
        this.glue = new Glue(this.getRole(1), this.getRole(2));
    }

    public Role getRole(Integer index) {
        return this.roles.get(index);
    }
}
