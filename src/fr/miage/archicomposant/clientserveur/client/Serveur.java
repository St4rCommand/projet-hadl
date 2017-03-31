package fr.miage.archicomposant.clientserveur.client;

import fr.miage.archicomposant.meta.derived.*;

/**
 * Created by romain on 30/03/17.
 */
public class Serveur extends Component {
    public Serveur(Configuration configuration) {
        super(configuration);
    }

    @Override
    protected void processRequest(Request request, Port portResponse) {
    }
}
