package fr.miage.archicomposant.clientserveur.rpc;

import fr.miage.archicomposant.meta.Connecteur;

/**
 * Created on 03/02/17.
 */
public class RpcConnecteur extends Connecteur {

    private RpcGlue glue        = new RpcGlue();
    private RpcRole roleRequis  = new RpcRole();
    private RpcRole roleFourni  = new RpcRole();
}
