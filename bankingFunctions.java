package Loginpkg;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class bankingFunctions{
	
	Connection con;
	java.sql.Statement st;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public boolean connect()  {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/proj?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			System.out.println("okkkk");
			return true;
		} catch (SQLException e) {
			System.out.println("error");
			return false;
		}
	}
	
	public String loginCheck(String id,String pass) throws SQLException {
		st=con.createStatement();
		ResultSet rs=(ResultSet)((java.sql.Statement) st).executeQuery("select * from login where id='"+id+"' and pass='"+pass+"'");
		String sol = null;
		System.out.println(rs.isBeforeFirst());
		if(rs.isBeforeFirst()) {
			try {
				while (rs.next()) {
				    sol = rs.getString("id");
				    System.out.println(sol);
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			rs=(ResultSet)((java.sql.Statement) st).executeQuery("select Designation from emp where id='"+id+"'");
			if(rs.isBeforeFirst()) {
				try {
					while (rs.next()) {
					    sol = rs.getString("Designation");
					    System.out.println(sol);
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.print(sol);
				return sol;
			}else {
				return "wrong";
			}
		}
		return "wrong";
	}
}