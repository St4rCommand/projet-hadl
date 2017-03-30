package fr.miage.archicomposant.detailserveur.SecurityManager;

import fr.miage.archicomposant.detailserveur.DetailServeurConfiguration;
import fr.miage.archicomposant.meta.derived.*;

import javax.xml.soap.Detail;

/**
 * Created by romain on 30/03/17.
 */
public class SecurityManager extends Composant {



    public SecurityManager(Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void processRequest(Request request, Port portRequest) {

        if (this.ports.get(DetailServeurConfiguration.SECURITY_MANAGER_PORT_SECURITY_AUTH).equals(portRequest)) {
            System.out.println("[INFO] - SecurityManager   - Demande d'ouverture de la bdd pour "+request);
            this.ports.get(DetailServeurConfiguration.SECURITY_MANAGER_PORT_CHECK_QUERY).transmit(request);
            return;
        }

        super.processRequest(request, portRequest);
    }

    @Override
    protected void processResponse(Response response, Port portResponse) {

        if (this.ports.get(DetailServeurConfiguration.SECURITY_MANAGER_PORT_CHECK_QUERY).equals(portResponse)) {
            System.out.println("[INFO] - SecurityManager   - Autorisation accordée");
            this.ports.get(DetailServeurConfiguration.SECURITY_MANAGER_PORT_SECURITY_AUTH).transmit(response);
            return;
        }
    }
}
