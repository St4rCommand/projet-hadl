package fr.miage.archicomposant.clientserveur.client;

import fr.miage.archicomposant.meta.Composant;

/**
 * Created on 03/02/17.
 */
public class Client extends Composant {

    private ClientPort portFourni       = new ClientPort();
    private ClientPort portRequis       = new ClientPort();
    private CodeSource codeSource       = new CodeSource();
    private Performance performance     = new Performance();
    private Visualisation visualisation = new Visualisation();
}
