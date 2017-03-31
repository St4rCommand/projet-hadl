package fr.miage.archicomposant.detailserveur.Database;

import fr.miage.archicomposant.detailserveur.DetailServeurConfiguration;
import fr.miage.archicomposant.meta.derived.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by romain on 30/03/17.
 */
public class Database extends Component {

    private String userAllowed;
    private Map<String, String> queryResult = new HashMap<>();

    public Database(Configuration configuration) {
        super(configuration);

        queryResult.put("rhunault", "ceci est la réponse pour romain hunault");
        queryResult.put("acalvo", "ceci est la réponse pour alexandre calvo");
    }

    @Override
    protected void processRequest(Request request, Port portRequest) {

        if (this.ports.get(DetailServeurConfiguration.DATABASE_PORT_SECURITY_MANAGEMENT).equals(portRequest)) {
            System.out.println("[INFO] - Database          - Ouverture de la bdd pour " + request);
            this.userAllowed = (String) request.getMessage();
            portRequest.transmit(new Response(true, request.getOriginPort()));
            return;
        }

        if (this.ports.get(DetailServeurConfiguration.DATABASE_PORT_QUERY_INT).equals(portRequest)) {
            System.out.println("[INFO] - Database          - Execution de la requête de " + request);

            if (request.getMessage().equals(userAllowed)) {
                portRequest.transmit(new Response(getResponseMessage((String) request.getMessage()), request.getOriginPort()));
                return;
            }

            portRequest.transmit(new Response(false, request.getOriginPort()));
        }
    }

    private String getResponseMessage(String key) {
        if (queryResult.containsKey(key)) {
            return queryResult.get(key);
        }

        return "il n'y a pas de réponse pour cette requete";
    }
}
