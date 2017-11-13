package com.miage.RepertoireWebApp.dao;

import com.miage.RepertoireWebApp.entity.Carnet;
import com.miage.RepertoireWebApp.exception.CarnetNotFoundException;

/**
 * Contrat d'un Data Access Object pour une entite Carnet
 * On retrouve alors les opérations CRUD.
 * 
 * @author tarik
 * @version 1.0
 */
public interface ListeRepertoires {
	
	/**
	 * Ajouter un carnet dans le serveur.
	 *
	 * @param personne Le carnet a ajouter.
	 *
	 */
	public boolean ajouterCarnet ();

	/**
	 * Retirer un carnet dans la BDD.
	 *
	 */
	public boolean retirerCarnet (String idCarnet) throws CarnetNotFoundException;

	/**
	 * Rechercher un carnet dans la BDD.
	 *
	 */
	public Carnet chercherCarnet (String idCarnet) throws CarnetNotFoundException;

	/**
	 * Lister les ids des carnets.
	 *
	 * @return Un tableau des noms des carnets.
	 *
	 */
	public String[] listerCarnets ();

}
