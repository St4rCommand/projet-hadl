package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.Message;

/**
 * Class Request
 *
 * Message send
 */
public class Request extends Message {

    public Request(Object message, Port port) {
        super(message, port);
    }
}
