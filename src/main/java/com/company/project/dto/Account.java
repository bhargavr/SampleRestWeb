/**
 * 
 */
package com.company.project.dto;

/**
 * @author bhargav
 * 
 */
public class Account
{

	private String username;

	private String password;

	private String displayName;

	private int user_id;

	public Account( String username,  String password,  String displayName, int user_id)
	{
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.user_id = user_id;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id()
	{
		return user_id;
	}

}
