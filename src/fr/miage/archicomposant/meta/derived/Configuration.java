package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.Attachment;
import fr.miage.archicomposant.meta.base.ElementArchitectural;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 03/02/17.
 */
public class Configuration extends ElementArchitectural {

    protected List<ElementArchitectural> elements = new ArrayList<>();
    protected List<Attachment> attachments = new ArrayList<>();

    public Configuration(Configuration configurationParent) {
        super(configurationParent);
    }
}
