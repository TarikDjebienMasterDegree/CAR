package com.miage.RepertoireWebApp.factory;

import com.miage.RepertoireWebApp.entity.User;

/**
 * Fabrique de user
 *
 * @author tarik DJEBIEN
 * @version 1.0
 */
public interface IUserFactory {

	/**
	 * Instanciation d'un nouvel objet de type User
	 * @return un nouveau Carnet
	 * @author tarik
	 */
	public User createUser(String login, String password, String remoteHost, String remoteAddr, String remotePort);

}
