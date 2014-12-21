/**
 * 
 */
package com.company.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dto.Account;
import com.company.project.exception.UsernameAlreadyInUseException;


//import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author bhargav
 * 
 */
@Repository
public class AccountDao
{

	private JdbcTemplate jdbcTemplate;

	//	private final PasswordEncoder passwordEncoder;

	@Inject
	public AccountDao(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
		//		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void createAccount(Account user) throws UsernameAlreadyInUseException
	{
		try
		{
			jdbcTemplate
					.update(
							"insert into hyg_user (user_id,create_date, userName, password, displayName) values (?, ?, ?, ?, ?)",
							user.getUser_id(), new Date(), user.getUsername(), user.getPassword(), user.getDisplayName());
		}
		catch (final DuplicateKeyException e)
		{
			throw new UsernameAlreadyInUseException(user.getUsername());
		}
	}

	public Account findAccountByUsername(String userName)
	{
		return jdbcTemplate.queryForObject("select userName, displayName, user_id from hyg_user where userName = ?",
				new RowMapper<Account>()
				{
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException
					{
						return new Account(rs.getString("userName"), null, rs.getString("displayName"), rs.getInt("user_id"));
					}
				}, userName);
	}
	
	public List<Account> getAllAccounts(String userName)
	{
		final List<Map<String, Object>> accountList = jdbcTemplate.queryForList("select * from hyg_user");
		
		List<Account> userList = new ArrayList<Account>();

		for (final Map account : accountList)
		{
			 Account accountObj = new Account(account.get("userName").toString(), null, account.get("displayName").toString(), (Integer)account.get("user_id"));
			 userList.add(accountObj);
			}
		
	 return userList;
	 
	}
	

}
