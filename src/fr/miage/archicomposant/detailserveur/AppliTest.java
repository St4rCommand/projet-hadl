package fr.miage.archicomposant.detailserveur;

import fr.miage.archicomposant.clientserveur.ClientServeurConfiguration;
import fr.miage.archicomposant.detailserveur.ConnectionManager.ConnectionManager;
import fr.miage.archicomposant.meta.derived.Request;

/**
 * Created by romain on 30/03/17.
 */
public class AppliTest {

    public static void main(String[] args) {
        DetailServeurConfiguration conf = new DetailServeurConfiguration(null);

        ((ConnectionManager) conf.getElementArchitectural(DetailServeurConfiguration.CONNECTION_MANAGER_NAME)).executeRequest(new Request("rhunault"));
    }
}
