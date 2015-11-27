package cn.zucc.service;


import java.util.List;

import cn.zucc.dao.itemDao;
import cn.zucc.entity.Book;
import cn.zucc.entity.Item;

public class itemService {
	itemDao itemDao=new itemDao();
	public Book findBookById(int id){
		return itemDao.findBookById(id);
	}
	public void add(Item item){
		itemDao.addItem(item);
	}
	public List<Item> findall(int oid){
		
		return itemDao.findall(oid);
		
	}
	public void delitem(int id){
		itemDao.delitem(id);
	}
	public List<Item> findByName(String name,int pageno){
		return itemDao.findItemByName(name,pageno);
	}
}
