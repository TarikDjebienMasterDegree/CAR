package com.miage.RepertoireWebApp.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * Du point de vue du code JAVA, il est possible d'utiliser un filtre JEE
 * qui va forcer le serveur d'applications Java a lire les parametres 
 * de la requete dans l'encodage souhaite et qui va renvoyer les reponses
 * avec le meme encodage.
 * 
 * @author tarik DJEBIEN
 * @version FINAL_RELEASE
 */
public class EncodingFilter implements Filter {
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// DO NOTHING
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(RepertoireWebAppConstants.ENCODING);
		response.setContentType(RepertoireWebAppConstants.CONTENT_TYPE + RepertoireWebAppConstants.ENCODING);
		chain.doFilter(request, response);
	}

	public void destroy() {
		// DO NOTHING
	}

}
