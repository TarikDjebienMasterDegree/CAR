package com.miage.RepertoireWebApp.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miage.RepertoireWebApp.entity.User;
import com.miage.RepertoireWebApp.exception.UserNotFoundException;
import com.miage.RepertoireWebApp.factory.IUserFactory;
import com.miage.RepertoireWebApp.factory.impl.UserFactory;
import com.miage.RepertoireWebApp.service.IRepertoireService;
import com.miage.RepertoireWebApp.service.impl.RepertoireServiceImpl;

/**
 * Servlet de controlle pour la partie d'authentification
 * 
 * @author Djebien Tarik
 *
 */
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 6936671174883079404L;

	public static String HOST = null;
	public static String PORT = null;

	private static IRepertoireService repertoireService;
	private IUserFactory userFactory;
	
	public static IRepertoireService getBeanRepertoireService(){
		return repertoireService!=null?repertoireService:new RepertoireServiceImpl();
	}

	public void init(ServletConfig config) throws ServletException {

		// Recuperation des donnees d'initialisation de la servlet
		HOST = config.getInitParameter("HOST");
		PORT = config.getInitParameter("PORT");

		// Injection des dependances
		
		this.userFactory = new UserFactory();


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		repertoireService = new RepertoireServiceImpl();//Le proxy a etablit la connexion
		
		// Recuperation de donnees depuis un formulaire
		String login = (String) request.getParameter("j_username");
		String password = (String) request.getParameter("j_password");
		String remoteHost = (String) request.getRemoteHost();
		String remoteAddr = (String) request.getRemoteAddr();
		String remotePort = Integer.toString(((int) request.getRemotePort()));
		// Ouverture d'une connexion avec le serveur annuaire
		try {

			User client = connectAnnuaire(login, password, remoteHost, remoteAddr, remotePort);

			// Creation d'une session pour y stocker l'utilisateur 
			HttpSession userHttpSession = request.getSession(true);
			userHttpSession.setAttribute("userInfo", client);
			
			// et ajout de l'id de session dans un cookie.
			this.writeCookie(response, userHttpSession.getId());
			
			response.sendRedirect("buildModel.factory");
			
		} catch (UserNotFoundException e) {

			// Echec de l'authentification, redirection vers la page de login.
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("User[login:").append(login).append(", password:").append(password).append("] not exist.");
			request.setAttribute("authentificationFailed", errorMessage.toString());
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}

	}

	public void destroy() {
		// Fermer les ressources ouvertes s'il y en a ici pour eviter les fuites memoires.
	}

	private User connectAnnuaire(String login, String password, String host, String addr, String port) 
			throws UserNotFoundException {
		boolean userExist = getBeanRepertoireService().seConnecter(login, password);
		return userExist ? userFactory.createUser(login, password, host, addr, port) : null;
	}
	
	private void writeCookie(HttpServletResponse response, String sessionId) {
		String nomCookie = "SessionCAR";
		response.addCookie(new Cookie(nomCookie, sessionId));
	}

}
