package fr.miage.archicomposant.clientserveur;

import fr.miage.archicomposant.clientserveur.client.Client;
import fr.miage.archicomposant.clientserveur.rpc.RpcConnecteur;
import fr.miage.archicomposant.clientserveur.serveur.Serveur;
import fr.miage.archicomposant.meta.Configuration;

/**
 * Created on 03/02/17.
 */
public class ClientServeurConfiguration extends Configuration {

    public ClientServeurConfiguration(Configuration configurationParent) {
        super(configurationParent);
        Client client = new Client(this);
        this.elements.add(client);
//        this.elements.add(new Serveur(this));
//        this.elements.add(new RpcConnecteur(this));

        client.start();
    }
}
