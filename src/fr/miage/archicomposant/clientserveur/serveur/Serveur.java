package fr.miage.archicomposant.clientserveur.serveur;

import fr.miage.archicomposant.meta.Composant;

/**
 * Created on 03/02/17.
 */
public class Serveur extends Composant {

    private ServeurPort portFourni = new ServeurPort();
    private ServeurPort portRequis = new ServeurPort();
}
