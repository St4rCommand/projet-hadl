package fr.miage.archicomposant.clientserveur;

import fr.miage.archicomposant.clientserveur.client.Client;
import fr.miage.archicomposant.clientserveur.rpc.RpcConnecteur;
import fr.miage.archicomposant.clientserveur.serveur.Serveur;
import fr.miage.archicomposant.meta.Configuration;

/**
 * Created on 03/02/17.
 */
public class ClientServeurConfiguration extends Configuration {

    private Client client;
    private Serveur serveur;
    private RpcConnecteur rpc;

    public ClientServeurConfiguration(Client client, Serveur serveur, RpcConnecteur rpc) {
        this.client = client;
        this.serveur = serveur;
        this.rpc = rpc;
    }
}
