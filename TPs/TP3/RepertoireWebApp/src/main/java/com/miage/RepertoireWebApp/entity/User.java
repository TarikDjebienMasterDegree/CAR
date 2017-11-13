package com.miage.RepertoireWebApp.entity;

public class User {
	
	private String login;
	private String password;
	private String remoteHost;
	/**
	 * @return the remoteHost
	 */
	public String getRemoteHost() {
		return remoteHost;
	}

	/**
	 * @param remoteHost the remoteHost to set
	 */
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	/**
	 * @return the remoteAddr
	 */
	public String getRemoteAddr() {
		return remoteAddr;
	}

	/**
	 * @param remoteAddr the remoteAddr to set
	 */
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	/**
	 * @return the remotePort
	 */
	public String getRemotePort() {
		return remotePort;
	}

	/**
	 * @param remotePort the remotePort to set
	 */
	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}

	private String remoteAddr;
	private String remotePort;
	
	public User(){}
	
	public User(String login, String password, String remoteHost, String remoteAddr, String remotePort){
		this.login = login;
		this.password = password;
		this.remoteHost = remoteHost;
		this.remoteAddr = remoteAddr;
		this.remotePort = remotePort;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString(){
		return "User[login: "+login+", password: "+password+", host: "+remoteHost+", IP: "+remoteAddr+", port:"+remotePort+"]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((remoteAddr == null) ? 0 : remoteAddr.hashCode());
		result = prime * result
				+ ((remoteHost == null) ? 0 : remoteHost.hashCode());
		result = prime * result
				+ ((remotePort == null) ? 0 : remotePort.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (remoteAddr == null) {
			if (other.remoteAddr != null) {
				return false;
			}
		} else if (!remoteAddr.equals(other.remoteAddr)) {
			return false;
		}
		if (remoteHost == null) {
			if (other.remoteHost != null) {
				return false;
			}
		} else if (!remoteHost.equals(other.remoteHost)) {
			return false;
		}
		if (remotePort == null) {
			if (other.remotePort != null) {
				return false;
			}
		} else if (!remotePort.equals(other.remotePort)) {
			return false;
		}
		return true;
	}

}
