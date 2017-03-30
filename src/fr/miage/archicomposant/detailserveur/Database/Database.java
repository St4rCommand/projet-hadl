package fr.miage.archicomposant.detailserveur.Database;

import fr.miage.archicomposant.detailserveur.DetailServeurConfiguration;
import fr.miage.archicomposant.meta.derived.*;

/**
 * Created by romain on 30/03/17.
 */
public class Database extends Composant {

    private String userAllowed;
    private String[] users = {
            "rhunault",
            "acalvo"
    };

    public Database(Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void processRequest(Request request, Port portRequest) {

        if (this.ports.get(DetailServeurConfiguration.DATABASE_PORT_SECURITY_MANAGEMENT).equals(portRequest)) {
            System.out.println("[INFO] - Database          - Ouverture de la bdd pour " + request);
            this.userAllowed = (String) request.getMessage();
            portRequest.transmit(new Response(true));
            return;
        }

        if (this.ports.get(DetailServeurConfiguration.DATABASE_PORT_QUERY_INT).equals(portRequest)) {
            System.out.println("[INFO] - Database          - Execution de la requête de " + request);

            if (request.getMessage().equals(userAllowed)) {
                portRequest.transmit(new Response(users));
                return;
            }

            portRequest.transmit(new Response(false));
        }
    }
}
