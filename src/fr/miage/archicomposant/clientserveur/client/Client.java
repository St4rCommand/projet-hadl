package fr.miage.archicomposant.clientserveur.client;

import fr.miage.archicomposant.meta.Composant;
import fr.miage.archicomposant.meta.Configuration;

/**
 * Created on 03/02/17.
 */
public class Client extends Composant {

    private ClientPort portFourni       = new ClientPort();
    private ClientPort portRequis       = new ClientPort();
    private CodeSource codeSource       = new CodeSource();
    private Performance performance     = new Performance();
    private Visualisation visualisation = new Visualisation();

    public Client(Configuration configuration) {
        super(configuration);
        this.interfaces.add(this.portFourni);
        this.interfaces.add(this.portRequis);
        this.proprietes.add(this.codeSource);
        this.proprietes.add(this.performance);
        this.proprietes.add(this.visualisation);

        this.portFourni.addObserver(configuration);
    }

    public void start() {
        this.portFourni.setMessage("coucou");
        this.portFourni.notifyObservers();
//        this.portFourni.sendMessage(this.configurationParent);
    }
}
