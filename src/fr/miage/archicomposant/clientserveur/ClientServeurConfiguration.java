package fr.miage.archicomposant.clientserveur;

import fr.miage.archicomposant.clientserveur.client.Client;
import fr.miage.archicomposant.clientserveur.client.Serveur;
import fr.miage.archicomposant.detailserveur.ConnectionManager.ConnectionManager;
import fr.miage.archicomposant.detailserveur.DetailServeurConfiguration;
import fr.miage.archicomposant.meta.base.Attachment;
import fr.miage.archicomposant.meta.base.Binding;
import fr.miage.archicomposant.meta.derived.Composant;
import fr.miage.archicomposant.meta.derived.Configuration;
import fr.miage.archicomposant.meta.derived.Connecteur;
import fr.miage.archicomposant.meta.derived.Port;

/**
 * Created on 03/02/17.
 */
public class ClientServeurConfiguration extends Configuration {

    public static final String CLIENT_PORT_NAME = "serveur";
    public static final String SERVEUR_PORT_NAME = "client";

    public ClientServeurConfiguration(Configuration configurationParent) {
        super(configurationParent);

        // Définition du client
        Client client = new Client(this);
        client.addPort(CLIENT_PORT_NAME, new Port());
        this.elements.put("client", client);

        // Définition du rpc
        Connecteur rpc = new Connecteur(this);
        this.elements.put("rpc", rpc);

        // Définition du serveur
        Composant serveur = new Serveur(this);
        serveur.addPort(SERVEUR_PORT_NAME, new Port());
        this.elements.put("serveur", serveur);

        // Définition des attachements
        this.attachments.add(new Attachment(client.getPort(CLIENT_PORT_NAME), rpc.getRole(1)));
        this.attachments.add(new Attachment(serveur.getPort(SERVEUR_PORT_NAME), rpc.getRole(2)));

        // Définition du detailServeur
        Configuration detailServeur = new DetailServeurConfiguration(this);
        this.elements.put("detailServeur", detailServeur);

        // Définition du binding
        Binding binding = new Binding(
            serveur.getPort(SERVEUR_PORT_NAME),
            ((ConnectionManager) detailServeur.getElementArchitectural(DetailServeurConfiguration.CONNECTION_MANAGER_NAME)).getPort(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_EXTERNAL_SOCKET)
        );

        client.start();
    }
}
