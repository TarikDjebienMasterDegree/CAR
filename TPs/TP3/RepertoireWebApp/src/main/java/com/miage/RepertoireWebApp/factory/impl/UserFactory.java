package com.miage.RepertoireWebApp.factory.impl;

import com.miage.RepertoireWebApp.entity.User;
import com.miage.RepertoireWebApp.factory.IUserFactory;


public class UserFactory implements IUserFactory {

	public User createUser(String login, String password, String remoteHost, String remoteAddr, String remotePort) {
		return new User(login, password, remoteHost, remoteAddr, remotePort);
	}

}
