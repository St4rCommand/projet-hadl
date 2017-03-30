package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.ElementArchitectural;
import fr.miage.archicomposant.meta.base.Glue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 03/02/17.
 */
public class Connecteur extends ElementArchitectural {

    protected Map<Integer, Role> roles = new HashMap<>();
    protected Glue glue;

    public Connecteur(Configuration configurationParent) {
        super(configurationParent);
        this.roles.put(1, new Role());
        this.roles.put(2, new Role());
        this.glue = new Glue(this.getRole(1), this.getRole(2));
    }

    public Role getRole(Integer index) {
        return this.roles.get(index);
    }
}
