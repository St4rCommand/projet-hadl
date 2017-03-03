package fr.miage.archicomposant.meta;

/**
 * Created on 03/03/17.
 */
public class Attachment {
    protected Port port;
    protected Role role;

    public Attachment (Port port, Role role) {
        this.role = role;
        this.port = port;
    }
}
