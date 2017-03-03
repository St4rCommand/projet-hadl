package fr.miage.archicomposant.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 03/02/17.
 */
public class Configuration extends ElementArchitectural implements Observer {

    protected List<ElementArchitectural> elements = new ArrayList<>();
    protected List<Attachment> attachments = new ArrayList<>();

    public Configuration(Configuration configurationParent) {
        super(configurationParent);
    }

    @Override
    public void actualiser(Observable observable) {
        if (observable instanceof Role) {

        } else if (observable instanceof Port) {
            Port port = (Port) observable;
            System.out.println(port.getMessage());
        }
    }
}
