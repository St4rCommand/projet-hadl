package fr.miage.archicomposant.clientserveur;

import fr.miage.archicomposant.clientserveur.client.Client;
import fr.miage.archicomposant.meta.base.Attachment;
import fr.miage.archicomposant.meta.derived.Composant;
import fr.miage.archicomposant.meta.derived.Configuration;
import fr.miage.archicomposant.meta.derived.Connecteur;

/**
 * Created on 03/02/17.
 */
public class ClientServeurConfiguration extends Configuration {

    public ClientServeurConfiguration(Configuration configurationParent) {
        super(configurationParent);

        // Définition du client
        Client client = new Client(this);
        this.elements.add(client);

        // Définition du rpc
        Connecteur rpc = new Connecteur(this);
        this.elements.add(rpc);

        // Définition du serveur
        Composant serveur = new Composant(this);
        this.elements.add(serveur);


        // Définition des attachements
        this.attachments.add(new Attachment(client.getPortFourni(), rpc.getRoleRequis()));
        this.attachments.add(new Attachment(serveur.getPortRequis(), rpc.getRoleFourni()));

        client.start();
    }
}
