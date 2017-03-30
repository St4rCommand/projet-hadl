package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.Attachment;
import fr.miage.archicomposant.meta.base.ElementArchitectural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Configuration
 *
 * Configuration with its architectural elements and attachments
 */
public class Configuration extends ElementArchitectural {

    protected Map<String, ElementArchitectural> elements = new HashMap<>();
    protected List<Attachment> attachments = new ArrayList<>();


    public Configuration(Configuration configurationParent) {
        super(configurationParent);
    }

    /**
     * Find an architectural element by its name
     *
     * @param name String
     * @return ElementArchitectural
     */
    public ElementArchitectural getElementArchitectural(String name) {
        return this.elements.get(name);
    }
}
