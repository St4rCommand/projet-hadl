package fr.miage.archicomposant.detailserveur;

import fr.miage.archicomposant.detailserveur.ConnectionManager.ConnectionManager;
import fr.miage.archicomposant.detailserveur.Database.Database;
import fr.miage.archicomposant.detailserveur.SecurityManager.SecurityManager;
import fr.miage.archicomposant.meta.base.Attachment;
import fr.miage.archicomposant.meta.derived.Composant;
import fr.miage.archicomposant.meta.derived.Configuration;
import fr.miage.archicomposant.meta.derived.Connecteur;
import fr.miage.archicomposant.meta.derived.Port;

/**
 * Created by romain on 29/03/17.
 */
public class DetailServeurConfiguration extends Configuration {

    public static final String CONNECTION_MANAGER_NAME = "connectionManager";
    public static final String CONNECTION_MANAGER_PORT_SECURITY_CHECK_NAME = "security_check";
    public static final String CONNECTION_MANAGER_PORT_DB_QUERY_NAME = "db_query";
    public static final String CONNECTION_MANAGER_PORT_EXTERNAL_SOCKET = "external_socket";
    public static final String SECURITY_MANAGER_PORT_SECURITY_AUTH = "security_auth";
    public static final String SECURITY_MANAGER_PORT_CHECK_QUERY = "check_query";
    public static final String DATABASE_PORT_SECURITY_MANAGEMENT = "security_management";
    public static final String DATABASE_PORT_QUERY_INT = "query_int";

    public DetailServeurConfiguration(Configuration configurationParent) {
        super(configurationParent);

        // Définition du ConnectionManager
        Composant connectionManager = new ConnectionManager(this);
        connectionManager.addPort(CONNECTION_MANAGER_PORT_SECURITY_CHECK_NAME, new Port());
        connectionManager.addPort(CONNECTION_MANAGER_PORT_DB_QUERY_NAME, new Port());
        connectionManager.addPort(CONNECTION_MANAGER_PORT_EXTERNAL_SOCKET, new Port());
        this.elements.put(CONNECTION_MANAGER_NAME, connectionManager);

        // Définition du ClearenceRequest
        Connecteur clearenceRequest = new Connecteur(this);
        this.elements.put("clearenceRequest", clearenceRequest);

        // Définition du SecurityManager
        Composant securityManager = new SecurityManager(this);
        securityManager.addPort(SECURITY_MANAGER_PORT_SECURITY_AUTH, new Port());
        securityManager.addPort(SECURITY_MANAGER_PORT_CHECK_QUERY, new Port());
        this.elements.put("securityManager", securityManager);

        // Définition du SecurityManager
        Connecteur securityQuery = new Connecteur(this);
        this.elements.put("securityQuery", securityQuery);

        // Définiton de la Database
        Composant database = new Database(this);
        database.addPort(DATABASE_PORT_SECURITY_MANAGEMENT, new Port());
        database.addPort(DATABASE_PORT_QUERY_INT, new Port());
        this.elements.put("database", database);

        // Définition du SqlQuery
        Connecteur sqlQuery = new Connecteur(this);
        this.elements.put("sqlQuery", sqlQuery);

        // Définition des attachments
        this.attachments.add(new Attachment(
                connectionManager.getPort(CONNECTION_MANAGER_PORT_SECURITY_CHECK_NAME),
                clearenceRequest.getRole(1)
                ));
        this.attachments.add(new Attachment(
                connectionManager.getPort(CONNECTION_MANAGER_PORT_DB_QUERY_NAME),
                sqlQuery.getRole(1)
        ));
        this.attachments.add(new Attachment(
                securityManager.getPort(SECURITY_MANAGER_PORT_SECURITY_AUTH),
                clearenceRequest.getRole(2)
        ));
        this.attachments.add(new Attachment(
                securityManager.getPort(SECURITY_MANAGER_PORT_CHECK_QUERY),
                securityQuery.getRole(1)
        ));
        this.attachments.add(new Attachment(
                database.getPort(DATABASE_PORT_SECURITY_MANAGEMENT),
                securityQuery.getRole(2)
        ));
        this.attachments.add(new Attachment(
                database.getPort(DATABASE_PORT_QUERY_INT),
                sqlQuery.getRole(2)
        ));
    }
}
