package cn.zucc.service;

import java.util.List;

import cn.zucc.dao.bookDao;
import cn.zucc.entity.Book;

public class bookService {

	bookDao bookDao = new bookDao();
	public List<Book> findall(int pageNo){
		return bookDao.findAll(pageNo);
	}
	public Book findBookById(int id){
		return bookDao.findBookById(id);
	}
	public int pagecount(){
		return bookDao.findPagecount();
	}
	public List<Book> findBook(String keyword,int pageno){
		return bookDao.findKeyword(keyword, pageno);
	}
	public void update(int bookid,int stock){
		bookDao.updateBookNum(bookid, stock);
	}
	public int pagecount(String keyword){
		return bookDao.findPagecount();
	}
	public List<String> keywordbook(String keyword){
		return bookDao.searchbook(keyword);
	}
}
