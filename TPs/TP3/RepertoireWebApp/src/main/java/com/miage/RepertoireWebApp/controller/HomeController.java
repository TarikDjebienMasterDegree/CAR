package com.miage.RepertoireWebApp.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miage.RepertoireWebApp.entity.Personne;
import com.miage.RepertoireWebApp.exception.CarnetNotFoundException;

public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Recuperation de tous les carnets avec leur personnes.
		String[] lesCarnetsDisponibles = LoginController.getBeanRepertoireService().listerCarnets();

		if(lesCarnetsDisponibles != null) {

			// Construction du model de donnees a afficher sur la home page.
			Map<String, List<Personne>> lesAnnuaires = new TreeMap<String, List<Personne>>();

			for(String Carnet : lesCarnetsDisponibles){
				int idCarnet = Integer.valueOf(Carnet).intValue();
				List<Personne> lesPersonnesDuCarnet = new LinkedList<Personne>();
				try {
					String[] lesNomsDesPersonnes = LoginController.getBeanRepertoireService().listerPersonnes(idCarnet);
					if (lesNomsDesPersonnes!=null) {
						for(String nomPersonne : lesNomsDesPersonnes) {
							lesPersonnesDuCarnet.add(LoginController.getBeanRepertoireService().chercherPersonne(idCarnet, nomPersonne));
						}
						lesAnnuaires.put(Carnet, lesPersonnesDuCarnet);
					} else {
						lesAnnuaires.put(Carnet, null);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (CarnetNotFoundException e) {
					e.printStackTrace();
				}
			}

			// Structure de donnée contenant tout les carnets et leur personnes respectives
			req.setAttribute("lesAnnuaires", lesAnnuaires);

			// Message qui affiche le nombre de carnet disponibles sur le serveur sur la page d'acceuil
			req.setAttribute("nbreCarnetsDisponibles", lesCarnetsDisponibles.length);
		} else {
			req.setAttribute("nbreCarnetsDisponibles", 0);
		}

		// Redirection vers la seconde page
		req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
