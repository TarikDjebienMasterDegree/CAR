package com.miage.RepertoireWebApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LoginController.getBeanRepertoireService().closeConnection();
		HttpSession sessionUser = req.getSession(false);
		if(sessionUser != null) {
			sessionUser.removeAttribute("userInfo");
			sessionUser.invalidate();
		}
		req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
