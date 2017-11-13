package com.miage.RepertoireWebApp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miage.RepertoireWebApp.entity.Personne;
import com.miage.RepertoireWebApp.exception.CarnetNotFoundException;
import com.miage.RepertoireWebApp.factory.IPersonneFactory;
import com.miage.RepertoireWebApp.factory.impl.PersonneFactory;

public class AnnuaireController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IPersonneFactory personneFactory;

	@Override
	public void init(ServletConfig config) throws ServletException {
		personneFactory = new PersonneFactory();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// AJOUTER UNE FICHE
		boolean addSuccess = this.ajouterFiche(req, resp);

		// MODIFIER UNE FICHE
		boolean updateSuccess = this.modifierFiche(req, resp);

		// SUPPRIMER UNE FICHE
		boolean deleteSuccess = this.supprimerFiche(req, resp);
		
		
		if(addSuccess || updateSuccess || deleteSuccess){
			// REDIRECTION SUR LA HOME PAGE
			req.getRequestDispatcher("buildModel.factory").forward(req, resp);
			return;
		}else{
			// Si le formulaire est mal remplie, on redirige vers la home page avec un message d'erreur.
			req.setAttribute("errorMessage", "Les champs du formulaire doivent être correctement remplie.");
			req.getRequestDispatcher("buildModel.factory").forward(req, resp);
			return;
		}
		
		
		

	}

	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean supprimerFiche(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Recuperation de donnees depuis le formulaire de mise a jour d'une personne
		String delete_nom = (String) req.getParameter("delete_nom");
		String delete_idCarnet = (String) req.getParameter("delete_idCarnet");

		if(isValid(delete_nom) && isValid(delete_idCarnet)) {
			int idCarnet = Integer.parseInt(delete_idCarnet);
			try {
				boolean deleteCallBack = LoginController.getBeanRepertoireService().retirerPersonne(idCarnet, delete_nom);
				req.setAttribute("deleteCallBack", deleteCallBack ? delete_nom+" a été supprimé dans le carnet "+idCarnet+"." : delete_nom+" n'a pas été supprimé.");
			} catch (CarnetNotFoundException e) {
				req.setAttribute("deleteCallBack", "Le carnet"+idCarnet+"n'existe pas.");
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean modifierFiche(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Recuperation de donnees depuis le formulaire de mise a jour d'une personne
		String update_nom = (String) req.getParameter("update_nom");
		String update_email = (String) req.getParameter("update_email");
		String update_url = (String) req.getParameter("update_url");
		String update_info = (String) req.getParameter("update_info");
		String update_idCarnet = (String) req.getParameter("update_idCarnet");

		if(isValid(update_nom) && isValid(update_email) && isValid(update_url) && isValid(update_info) && isValid(update_idCarnet)) {
			int idCarnet = Integer.parseInt(update_idCarnet);
			Personne creerPersonne = personneFactory.createPersonne(update_nom, update_email, update_url, update_info);
			try {
				boolean updateCallBack = LoginController.getBeanRepertoireService().modifierPersonne(idCarnet, creerPersonne);
				req.setAttribute("updateCallBack", updateCallBack ? creerPersonne.toString()+" a été modifié dans le carnet "+idCarnet+"." : creerPersonne.toString()+" n'a pas été modifié.");
			} catch (CarnetNotFoundException e) {
				req.setAttribute("updateCallBack", "Le carnet"+idCarnet+"n'existe pas.");
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean ajouterFiche(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Recuperation de donnees depuis le formulaire d'ajout d'une personne
		String add_nom = (String) req.getParameter("add_nom");
		String add_email = (String) req.getParameter("add_email");
		String add_url = (String) req.getParameter("add_url");
		String add_info = (String) req.getParameter("add_info");
		String add_idCarnet = (String) req.getParameter("add_idCarnet");

		if(isValid(add_nom) && isValid(add_email) && isValid(add_url) && isValid(add_info) && isValid(add_idCarnet)) {
			int idCarnet = Integer.parseInt(add_idCarnet);
			Personne creerPersonne = personneFactory.createPersonne(add_nom, add_email, add_url, add_info);
			try {
				boolean addCallBack = LoginController.getBeanRepertoireService().ajouterPersonne(idCarnet, creerPersonne);
				req.setAttribute("addCallBack", addCallBack ? creerPersonne.toString()+" a été ajouté dans le carnet "+idCarnet+"." : creerPersonne.toString()+"n'a pas été ajouté.");
			} catch (CarnetNotFoundException e) {
				req.setAttribute("addCallBack", "Le carnet"+idCarnet+"n'existe pas.");
				e.printStackTrace();
			}
			return true;
		}else{
			return false;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	private boolean isValid(String param){
		return param != null && !param.equalsIgnoreCase("");
	}

}
