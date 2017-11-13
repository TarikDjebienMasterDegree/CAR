package com.miage.RepertoireWebApp.factory;

import com.miage.RepertoireWebApp.entity.Personne;

/**
 * Fabrique de personne d'un repertoire
 *
 * @author tarik DJEBIEN
 * @version 1.0
 */
public interface IPersonneFactory {

	/**
	 * Instanciation d'un nouvel objet de type Personne
	 * @return une nouvelle Personne
	 * @author tarik
	 */
	public Personne createPersonne(String nom, String email, String url, String info);
	
}