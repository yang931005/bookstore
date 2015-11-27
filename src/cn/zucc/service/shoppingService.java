package cn.zucc.service;

import java.util.List;

import cn.zucc.dao.shoppingDao;
import cn.zucc.entity.Book;
import cn.zucc.entity.Shopping;

public class shoppingService {

	shoppingDao shoppingDao = new shoppingDao();
	public void addshopping(Shopping shopping){
		shoppingDao.addShopping(shopping);
	}
	public boolean find(String name,int oid){
		if(shoppingDao.findshopping(name,oid)==null){
			return true;
		}
		return false;
		
	}
	public void deleteshopping(String bookname){
		shoppingDao.deleteshopping(bookname);
	}
	public List<Shopping> findshoppingByOid(int oid){
		return shoppingDao.findall(oid);
	}
	
	public Book findbookname(String name){
		return shoppingDao.findBookByname(name);
	}
	public void delete(int oid){
		shoppingDao.delshopping(oid);
	}
}
