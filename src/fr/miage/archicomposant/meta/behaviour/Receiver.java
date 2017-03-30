package fr.miage.archicomposant.meta.behaviour;

import fr.miage.archicomposant.meta.base.Message;

/**
 * Created by romain on 20/03/17.
 */
public interface Receiver {

    void receive(Message message);
}
