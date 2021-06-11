package Loginpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transfer_Function {
	
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
		get_connection();
		r=cn.createStatement();
		String query = "SELECT cash FROM user where id='"+id+"'";
		return r.executeQuery(query);
	}

	
	public boolean update_user_cash(String id,int b) throws SQLException {
		get_connection();
		r=cn.createStatement();
		r.execute("update user set cash='"+b+"' where id='"+id+"'");
		return true;
	}
	
	public Boolean transfer(String sender,String receiver,String amount) {
		String sol = null;
		int a=Integer.valueOf(amount);
		
		ResultSet rs = null;
		try {
			rs= user_cash(sender);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while (rs.next()) {
			    sol = rs.getString("cash");
			    
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			int b=Integer.valueOf(sol);
			if(b>a&& (b-a)>50) {
				b=b-a;
				update_user_cash(sender, b);
			}
			else {
				return false;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		a=Integer.valueOf(amount);
		try {
			rs = user_cash(receiver);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while (rs.next()) {
			    sol = rs.getString("cash");
			    
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			int b=Integer.valueOf(sol);
			b=b+a;
			update_user_cash(receiver, b);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
}
