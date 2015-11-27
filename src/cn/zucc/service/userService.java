package cn.zucc.service;

import cn.zucc.dao.userinfoDao;
import cn.zucc.entity.User;

public class userService {
	
	userinfoDao userdao = new userinfoDao();
	public boolean adduser(User user){
		User user1 = userdao.finduserbyname(user.getUserName());
		if(user1!=null){
			return false;
		}
		userdao.addUser(user);
		return true;
	}
	public boolean userLogin(User user){
		User user1 = userdao.finduserbyname(user.getUserName());
		if(user1!=null&&user.getPassword().equals(user1.getPassword())){
			return true;
		}
		return false;
	}
	public boolean userCheck(String name){
		User users = userdao.finduserbyname(name);
		if(users!=null){
			return false;
		}
		return true;
	}
}
