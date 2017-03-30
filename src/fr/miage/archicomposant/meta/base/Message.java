package fr.miage.archicomposant.meta.base;

/**
 * Created by romain on 29/03/17.
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
