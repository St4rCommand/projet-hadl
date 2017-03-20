package fr.miage.archicomposant.clientserveur.client;

import fr.miage.archicomposant.meta.derived.Composant;
import fr.miage.archicomposant.meta.derived.Configuration;

/**
 * Created on 03/02/17.
 */
public class Client extends Composant {

    public Client(Configuration configuration) {
        super(configuration);
    }

    public void start() {
        this.portFourni.transmit("Le message qui est envoyé");
    }
}
