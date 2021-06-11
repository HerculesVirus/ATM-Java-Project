package Loginpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoanFuntions {
	private Statement r;
	private Connection cn;
	DepositeUser du= new DepositeUser();
	
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
	
	public ResultSet result_loan() throws SQLException {
		get_connection();
		r=cn.createStatement();
		return r.executeQuery("select * from loan ");
	}
	
	private  String now() {
		// TODO Auto-generated method stub  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(); 
		return dtf.format(now);
	}
	
	public boolean loan_database(String loanid,String granty,String amount,String Account,String descrp) throws SQLException {
		get_connection();
		r=cn.createStatement();
		r.execute("insert into loan values('"+loanid+"','"+granty+"','"+amount+"','"+Account+"','"+descrp+"')");
		r.execute("insert into activity values('"+loanid+"',Loan,'"+amount+"','"+now()+"')");
		r.execute("insert into activity values('"+Account+"',Loan,'"+amount+"','"+now()+"')");
		return true;
	}
	
	public void loan_function(String loanid,String granty,String amount,String Account,String descrp) {
		try {
			loan_database(loanid,granty,amount,Account,descrp);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sol = null;
		int a=Integer.valueOf(amount);
		ResultSet rs = null;
		try {
			rs = du.user_cash(Account);
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
			du.update_user_cash(Account, b,amount);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
	
