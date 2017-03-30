package fr.miage.archicomposant.meta.base;

/**
 * Class Message
 *
 * Message that spread through the network
 */
public abstract class Message {

    protected Object message;

    public Message(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public String toString() {

        return this.message.toString();
    }
}
