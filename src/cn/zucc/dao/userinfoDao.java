package cn.zucc.dao;

import java.sql.SQLException;

import cn.zucc.entity.User;



public class userinfoDao extends baseDao{

	public void addUser(User user){
		try {
			Init();
			String sql="insert into userinfo (username,password,email) values (?,?,?)";
			ps=cn.prepareStatement(sql);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassword());
			ps.setString(3, user.getEmail());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ÃÌº” ß∞‹");
			e.printStackTrace();
		}finally{
			myclose();
		}
		
	}
	public User finduserbyname(String name){
		User user = null;
		try {
			Init();
			String sql = "select * from userinfo where userName = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1,name );
			rs=ps.executeQuery();
			if(rs.next()){
				user = new User() ;
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
