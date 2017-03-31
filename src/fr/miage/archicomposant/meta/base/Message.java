package fr.miage.archicomposant.meta.base;

import fr.miage.archicomposant.meta.derived.Port;

/**
 * Class Message
 *
 * Message that spread through the network
 */
public abstract class Message {

    protected Port originPort;
    protected Object message;

    public Message(Object message, Port port) {
        this.message = message;
        this.originPort = port;
    }

    public Object getMessage() {
        return message;
    }

    public Port getOriginPort() {
        return originPort;
    }

    public String toString() {

        return this.message.toString();
    }
}
