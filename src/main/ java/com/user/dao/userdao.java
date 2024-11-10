package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class userdao {
	private String jdbcURL ="jdbc:Mysql://localhost:30006/userapp";
	private String jdbcUserName = "root";
	private String jdbcPassword="root";
	
	private static final String INSERT_USER_SQL ="INSERT INTO users"+"(uname,email,country,passwd) VALUSE "+"(?,?,?,?);";
	private static final String SELECT_USER_BY_ID ="SELECT * FROM USERS WHERE ID=?;";
	private static final String SELECT_ALL_USERS="SELECT* FROM USERS;";
	private static final String DELETE_USER_SQL="DELETE FROM USER WHERE ID=?;";
	private static final String UPDATE_USER_SQL="UPDATE USERS SET UNAME=?,EMAIL=?,COUNTRY=?,PASSWORD=? WHERE ID=?;";
	public userdao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.musql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL,jdbcUserName,jdbcPassword);
		}
		catch(SQLException | ClassNotFoundException  e) {
			
			e.printStackTrace();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return connection;
		
	}
	
	
	public void insertuser(User user) {
		
		Userdao dao = new userdao();
		try(Connection connection= dao.getConnection()){
			
			PreparedStatement preparedStatement= connection.preparedStatement(INSERT_USER_SQL);
			preparedStatement.setString(1,user.getName());
			preparedStatement.setString(2,)
			
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
