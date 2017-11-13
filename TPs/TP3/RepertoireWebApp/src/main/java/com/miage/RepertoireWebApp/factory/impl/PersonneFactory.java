package com.miage.RepertoireWebApp.factory.impl;

import com.miage.RepertoireWebApp.entity.Personne;
import com.miage.RepertoireWebApp.factory.IPersonneFactory;

public class PersonneFactory implements IPersonneFactory {

	public Personne createPersonne(String nom, String email, String url, String info) {
		return new Personne(nom, email, url, info);
	}

}
