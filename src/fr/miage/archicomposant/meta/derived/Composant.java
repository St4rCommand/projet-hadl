package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.ElementArchitectural;
import fr.miage.archicomposant.meta.base.Interface;
import fr.miage.archicomposant.meta.base.Message;
import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observer;
import fr.miage.archicomposant.meta.behaviour.Observable;

import java.util.*;

/**
 * Created on 03/02/17.
 */
public class Composant extends ElementArchitectural implements Observer {

    protected Map<String, Port> ports = new HashMap<>();

    public Composant(Configuration configuration) {
        super(configuration);
    }

    public void addPort(String name, Port port) {
        port.addObserver(this);
        this.ports.put(name, port);
    }

    public Port getPort(String name) {
        return this.ports.get(name);
    }

    @Override
    public void actualiser(Observable observable) {
        if (! (observable instanceof Port)) {
            return;
        }

        Port port = (Port) observable;

        if (port.getState() != InterfaceState.MESSAGE_RECEIVED) {
            return;
        }

        if (port.getMessageReceived() instanceof Request) {
            processRequest((Request) port.getMessageReceived(), port);
        } else if (port.getMessageReceived() instanceof Response) {
            processResponse((Response) port.getMessageReceived(), port);
        }
    }

    protected void processRequest(Request request, Port portRequest) {
        portRequest.transmit(new Response(request.getMessage()));
    }

    protected void processResponse(Response response, Port portResponse) {
        System.out.println(response);
    }
}
