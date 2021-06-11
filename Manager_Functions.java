package Loginpkg;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Manager_Functions {
	private Statement r;
	private Connection cn;
	
	public boolean get_connection() throws SQLException { 
		cn=DriverManager.getConnection("jdbc:mysql://localhost/proj?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		return true;
	}
	
	public boolean delete_emp(String s) throws SQLException {
		r=cn.createStatement();
		r.execute("delete from emp where id ='"+s+"'");
		return true;
	}
	
	public ResultSet result_emp() throws SQLException {
		r=cn.createStatement();
		return r.executeQuery("select * from emp ");
	}
	public ResultSet result_loan() throws SQLException {
		get_connection();
		r=cn.createStatement();
		return r.executeQuery("select * from loan ");
	}
	
	public ResultSet result_user() throws SQLException {
		get_connection();
		r=cn.createStatement();
		return r.executeQuery("select * from user ");
	}
	
	public ResultSet where_emp_id(String s) throws SQLException {
		r=cn.createStatement();
		return r.executeQuery("select * from emp where id='"+s+"'");
	}
	
	public boolean insert_into_database(String id,String name,String father,String Adress,String Des) throws SQLException {
		r=cn.createStatement();
		r.execute("insert into emp values('"+id+"','"+name+"','"+father+"','"+Adress+"','"+Des+"')");
		return true;
	}
	
	public boolean insert_user_value(String id,String name,String father,String Adress,String acnt) throws SQLException {
		r=cn.createStatement();
		r.execute("insert into user values('"+id+"','"+name+"','"+father+"','"+Adress+"','"+acnt+"')");
		return true;
	}
	
	public ResultSet where_user_id(String s) throws SQLException {
		get_connection();
		r=cn.createStatement();
		return r.executeQuery("select * from user where id='"+s+"'");
	}
	
	public ResultSet user_cash(String id) throws SQLException {
		String query = "SELECT cash FROM user where id='"+id+"'";
		return r.executeQuery(query);
	}
	
	public boolean update_user_cash(String id,int b) throws SQLException {
		r=cn.createStatement();
		r.execute("update user set cash='"+b+"' where id='"+id+"'");
		return true;
	}

	public ResultSet where_loan_id(String s) throws SQLException {
		get_connection();
		r=cn.createStatement();
		return r.executeQuery("select * from loanpay where loanid='"+s+"'");
	}
}
