package com.miage.RepertoireWebApp.service;

import com.miage.RepertoireWebApp.dao.Repertoire;
import com.miage.RepertoireWebApp.dao.impl.CarnetProxy;
import com.miage.RepertoireWebApp.entity.Carnet;
import com.miage.RepertoireWebApp.entity.Personne;
import com.miage.RepertoireWebApp.exception.CarnetNotFoundException;
import com.miage.RepertoireWebApp.exception.UserNotFoundException;

public interface IRepertoireService {

	public boolean fixerRepertoire(CarnetProxy repertoire);

	public Repertoire getRepertoire();

	public Personne createPersonne(String nom, String email, String url, String info);

	public boolean ajouterPersonne(int idCarnet, Personne creerPersonne) throws CarnetNotFoundException;

	public boolean modifierPersonne(int idCarnet, Personne creerPersonne) throws CarnetNotFoundException;
	
	public boolean retirerPersonne(int idCarnet, String nom) throws CarnetNotFoundException;

	public Personne chercherPersonne(int idCarnet, String nomPersonne) throws CarnetNotFoundException;

	public String[] listerPersonnes(int idCarnet) throws CarnetNotFoundException;

	public void closeConnection();

	public boolean ajouterCarnet();

	public String[] listerCarnets();

	public Carnet chercherCarnet(String idCarnet) throws CarnetNotFoundException;

	public boolean retirerCarnet(String idCarnet) throws CarnetNotFoundException;

	public boolean seConnecter(String login, String password) throws UserNotFoundException;

}
