package org.ms.authentificationservice.entities;

public class UserRoleData {

	private String username;

	private String roleName;

	public UserRoleData() {

	}

	public UserRoleData(String username, String roleName) {

		this.username = username;

		this.roleName = roleName;

	}

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getRoleName() {

		return roleName;

	}

	public void setRoleName(String roleName) {

		this.roleName = roleName;

	}

}