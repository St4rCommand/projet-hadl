package fr.miage.archicomposant.meta.derived;

import fr.miage.archicomposant.meta.base.ElementArchitectural;
import fr.miage.archicomposant.meta.behaviour.InterfaceState;
import fr.miage.archicomposant.meta.behaviour.Observable;
import fr.miage.archicomposant.meta.behaviour.Observer;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Component
 *
 * System component
 */
public class Component extends ElementArchitectural implements Observer {

    protected Map<String, Port> ports = new HashMap<>();

    public Component(Configuration configuration) {
        super(configuration);
    }

    public void addPort(String name, Port port) {
        port.addObserver(this);
        this.ports.put(name, port);
    }

    /**
     * Find a port by its name
     *
     * @param name String
     * @return Port
     */
    public Port getPort(String name) {
        return this.ports.get(name);
    }

    /**
     * Action when a port receive a message
     *
     * @param observable Observable
     */
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

    /**
     * Processing when a port component receive a request message
     *
     * @param request Request
     * @param portRequest Port
     */
    protected void processRequest(Request request, Port portRequest) {
        portRequest.transmit(new Response(request.getMessage()));
    }

    /**
     * Processing when a port component receive a response message
     *
     * @param response Response
     * @param portResponse Port
     */
    protected void processResponse(Response response, Port portResponse) {
        System.out.println(response);
    }
}
