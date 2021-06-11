package Loginpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WithdrawUserAccount {
	private Statement r;
	private Connection cn;
	
	public boolean get_connection()  { 
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost/proj?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		   System.out.println("error connecting");
			e.printStackTrace();
			return false;
		}
	}

	public ResultSet user_cash(String id) throws SQLException {
		r=cn.createStatement();
		String query = "SELECT cash FROM user where id='"+id+"'";
		return r.executeQuery(query);
	}
	
	private  String now() {
		// TODO Auto-generated method stub  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(); 
		return dtf.format(now);
	}
	
	public boolean update_user_cash(String id,int b,String Amount) throws SQLException {
		r=cn.createStatement();
		r.execute("update user set cash='"+b+"' where id='"+id+"'");
		r.execute("insert into activity values('"+id+"',With Draw,'"+Amount+"','"+now()+"')");
		return true;
	}
	
}
