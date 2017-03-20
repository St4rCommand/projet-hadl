package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.ElementArchitectural;
import fr.miage.archicomposant.meta.base.Glue;

/**
 * Created on 03/02/17.
 */
public class Connecteur extends ElementArchitectural {

    protected Role roleRequis   = new Role();
    protected Role roleFourni   = new Role();
    protected Glue glue         = new Glue(roleRequis, roleFourni);

    public Connecteur(Configuration configurationParent) {
        super(configurationParent);
    }

    public Role getRoleRequis() {
        return this.roleRequis;
    }

    public Role getRoleFourni() {
        return this.roleFourni;
    }
}
