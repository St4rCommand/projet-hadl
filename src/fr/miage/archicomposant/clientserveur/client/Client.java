package fr.miage.archicomposant.clientserveur.client;

import fr.miage.archicomposant.clientserveur.ClientServeurConfiguration;
import fr.miage.archicomposant.meta.derived.*;

/**
 * Created on 03/02/17.
 */
public class Client extends Component {

    public Client(Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void processResponse(Response response, Port portResponse) {
        System.out.println("Réponse finale : "+response.getMessage());
    }

    public void start(String request) {
        this.getPort(ClientServeurConfiguration.CLIENT_PORT_NAME).transmit(new Request(request, this.getPort(ClientServeurConfiguration.CLIENT_PORT_NAME)));
    }
}
