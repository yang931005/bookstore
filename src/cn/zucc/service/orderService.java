package cn.zucc.service;


import java.util.List;
import cn.zucc.dao.orderDao;
import cn.zucc.entity.Book;
import cn.zucc.entity.Order;
import cn.zucc.entity.Shopping;

public class orderService {

	orderDao orderDao = new orderDao();
	public Order findorderbyname(String name,int state){
		return orderDao.findorderByName(name,state);
	} 
	public void addorder(Order order){
		orderDao.addorder(order);
	}
	public Shopping findsById(int id){
		return orderDao.findShoppingById(id);
	}
	public void updateState(int oid){
		orderDao.updatestate(oid);
	}
	public List<Order> findorders(String name,int state){
		return orderDao.findorders(name, state);
	}
	public Book findbook(int id){
		return orderDao.findBooks(id);
	}
	public int pagecount(String name){
		return orderDao.findPagecount(name);
	}
}
