package Loginpkg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Donation_Functions {
	private Statement r;
	private Connection cn;
	
	Transfer_Function tf = new Transfer_Function();
	
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
	public ResultSet getIntId(String name) throws SQLException {
		r=cn.createStatement();
		String query = "select * from donation_insti where name = '"+name+"'";
		return r.executeQuery(query);	
	}
	
	public boolean accountDonation(String id,String name,String Did,String Amount) throws SQLException {
		r=cn.createStatement();
		r.execute("insert into accountdonation values('"+id+"','"+name+"','"+Did+"','"+now()+"','"+Amount+"')");
		r.execute("insert into activity values('"+id+"',Donation,'"+Amount+"','"+now()+"')");
		return true;
	}
	
	private  String now() {
		// TODO Auto-generated method stub  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(); 
		return dtf.format(now);
	}
	
	public boolean unknownDonation(String id,String name,String Did,String Amount) throws SQLException {
		r=cn.createStatement();
		r.execute("insert into makedonation values('"+id+"','"+name+"','"+Did+"','"+now()+"','"+Amount+"')");
		r.execute("insert into activity values('"+id+"',Donation,'"+Amount+"','"+now()+"')");
		return true;
	}
	
	
	public boolean donation(String id,String s,String diD,String Amount) {
		String sol = null;
		int a=Integer.valueOf(Amount);
		ResultSet rs = null;
		try {
			rs=tf.user_cash(id);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			while (rs.next()) {
				    sol = rs.getString("cash");
				    System.out.println(sol);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			int b=Integer.valueOf(sol);
			if(b>a&& (b-a)>50) {
			b=b-a;
			tf.update_user_cash(id, b);
			}
			else {
				return false;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			accountDonation(id,s,diD, Amount);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return true;
	}
	
}
