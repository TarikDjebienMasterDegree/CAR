package com.miage.RepertoireWebApp.service.impl;

import com.miage.RepertoireWebApp.dao.Repertoire;
import com.miage.RepertoireWebApp.dao.impl.CarnetProxy;
import com.miage.RepertoireWebApp.entity.Carnet;
import com.miage.RepertoireWebApp.entity.Personne;
import com.miage.RepertoireWebApp.exception.CarnetNotFoundException;
import com.miage.RepertoireWebApp.exception.UserNotFoundException;
import com.miage.RepertoireWebApp.factory.IPersonneFactory;
import com.miage.RepertoireWebApp.factory.impl.PersonneFactory;
import com.miage.RepertoireWebApp.service.IRepertoireService;

public class RepertoireServiceImpl implements IRepertoireService {
	
	private CarnetProxy carnet;
	protected IPersonneFactory personneFactory;
	
	public RepertoireServiceImpl(){
		this.carnet = new CarnetProxy();
		this.personneFactory = new PersonneFactory();
	}

	public boolean fixerRepertoire(CarnetProxy repertoire) {
		if(repertoire != null){
			this.carnet = repertoire;
			return true;
		}else{
			return false;
		}
		
	}

	public Repertoire getRepertoire() {
		return getCarnet();
	}

	public Personne createPersonne(String nom, String email, String url, String info) {
		return personneFactory.createPersonne(nom, email, url, info);
	}

	public boolean ajouterPersonne(int idCarnet, Personne creerPersonne) throws CarnetNotFoundException {
		return this.carnet.ajouterPersonne(idCarnet, creerPersonne);
	}
	
	public boolean retirerPersonne(int idCarnet, String nom) throws CarnetNotFoundException {
		return this.carnet.retirerPersonne(idCarnet, nom);
	}

	public boolean modifierPersonne(int idCarnet, Personne creerPersonne) throws CarnetNotFoundException {
		return this.carnet.modifierPersonne(idCarnet, creerPersonne);
	}

	public Personne chercherPersonne(int idCarnet, String nomPersonne) throws CarnetNotFoundException {
		return this.carnet.chercherPersonne(idCarnet, nomPersonne);
	}

	public String[] listerPersonnes(int idCarnet) throws CarnetNotFoundException {
		return this.carnet.listerPersonnes(idCarnet);
	}
	
	public boolean ajouterCarnet() {
		return this.carnet.ajouterCarnet();
	}

	public String[] listerCarnets() {
		return this.carnet.listerCarnets();
	}

	public Carnet chercherCarnet(String idCarnet) throws CarnetNotFoundException {
		return this.carnet.chercherCarnet(idCarnet);
	}

	public boolean retirerCarnet(String idCarnet) throws CarnetNotFoundException {
		return this.carnet.retirerCarnet(idCarnet);
	}

	
	/**
	 * @return the carnet
	 */
	public Repertoire getCarnet() {
		return carnet;
	}

	public void closeConnection() {
		this.carnet.closeSocketConnection();
	}

	public boolean seConnecter(String login, String password) throws UserNotFoundException{
		return this.carnet.authenticate(login,password);
	}

}
