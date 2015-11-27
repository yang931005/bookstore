package cn.zucc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class baseDao {

	
	PreparedStatement ps = null;
	Connection cn = null;
	ResultSet rs = null;
	public baseDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("¼ÓÔØÇý¶¯Ê§°Ü");
			e.printStackTrace();
		}
	}
	public void myclose(){
		
			try {
				if(ps!=null){
				ps.close();
				}
				if(cn!=null){
					cn.close();
					}
				if(rs!=null){
					rs.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			
	}
	
	
	public void Init() throws SQLException{
		
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");
		
	}
}