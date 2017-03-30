package fr.miage.archicomposant.detailserveur.ConnectionManager;

import fr.miage.archicomposant.detailserveur.DetailServeurConfiguration;
import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.derived.*;

/**
 * Created by romain on 30/03/17.
 */
public class ConnectionManager extends Composant {

    private String user = "";

    public ConnectionManager(Configuration configuration) {
        super(configuration);
    }

    @Override
    public void actualiser(Observable observable) {

        if (! (observable instanceof Port)) {
            return;
        }

        Port port = (Port) observable;

        if (
                this.ports.get(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_EXTERNAL_SOCKET).equals(port)
                && port.getState() == InterfaceState.MESSAGE_RECEIVED
                && port.getMessageReceived() instanceof Request) {
            this.executeRequest((Request) port.getMessageReceived());
        }

        super.actualiser(observable);
    }

    public void executeRequest(Request request) {
        this.user = (String) request.getMessage();
        this.ports.get(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_SECURITY_CHECK_NAME).transmit(new Request(this.user));
    }

    @Override
    protected void processResponse(Response response, Port portResponse) {
        if(this.ports.get(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_SECURITY_CHECK_NAME).equals(portResponse)) {
            System.out.println("[INFO] - ConnectionManager - Execution de la requête");
            this.ports.get(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_DB_QUERY_NAME).transmit(new Request(this.user));
            return;
        }

        if(this.ports.get(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_DB_QUERY_NAME).equals(portResponse)) {

            String[] users = (String[]) response.getMessage();

            String result = "";

            for (String localUser: users) {
                result += result + localUser + " ";
                System.out.println(localUser);
            }

            System.out.println("[INFO] - ConnectionManager - Résultat de la requête : "+result);
            this.ports.get(DetailServeurConfiguration.CONNECTION_MANAGER_PORT_EXTERNAL_SOCKET).transmit(response);

            return;
        }

//        super.processResponse(response, portResponse);
    }
}