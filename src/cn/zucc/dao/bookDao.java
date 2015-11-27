package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.entity.Book;
import cn.zucc.util.Page;

public class bookDao extends baseDao{

	public void addBook(Book book){
		try {
			Init();
			String sql="insert into userinfo (bookName,price,image,stock)values(?,?,?,?)";
			ps=cn.prepareStatement(sql);
			ps.setString(1,book.getBookName());
			ps.setDouble(2,book.getPrice());
			ps.setString(3,book.getImages());
			ps.setInt(4, book.getStock());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ÃÌº” ß∞‹");
			e.printStackTrace();
		}finally{
			myclose();
		}
		
	}
	public List<Book> findAll(int pageNo){
		List<Book> list = new ArrayList<Book>();
		try {
			Init();
			String sql = "select * from books limit ?,?";
			ps=cn.prepareStatement(sql);
			ps.setInt(1, pageNo);
			ps.setInt(2, Page.pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookName(rs.getString("bookName"));
				book.setBid(rs.getInt("bId"));
				book.setPrice(rs.getDouble("price"));
				book.setImages(rs.getString("image"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
		return list;
	}
	public Book findBookById(int id){
		Book book = new Book();
		try {
			Init();
			String sql = "select *from books where bId = ?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1,id );
			rs=ps.executeQuery();
			if(rs.next()){
				book.setBookName(rs.getString("bookName"));
				book.setBid(rs.getInt("bId"));
				book.setPrice(rs.getDouble("price"));
				book.setImages(rs.getString("image"));
				book.setStock(rs.getInt("stock"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
		return book;
		
	}
	public int findPagecount(){
		int count = 0;
			try {
				Init();
				String sql = "select count(*) from books";
				ps = cn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					count =rs.getInt("count(*)");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				myclose();
			}
			return count;
		}
	public int findPagecount(String keyword){
		int count = 0;
			try {
				Init();
				StringBuffer sb = new StringBuffer();
				sb.append("select count(*) from books where bookName like '%");
				sb.append(keyword);
				sb.append("%'");
				ps = cn.prepareStatement(sb.toString());
				rs=ps.executeQuery();
				if(rs.next()){
					count =rs.getInt("count(*)");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				myclose();
			}
			return count;
		}
	public List<Book> findKeyword(String keyword,int pageNo){
		List<Book> list = new ArrayList<Book>();
		try {
			Init();
			StringBuffer sb = new StringBuffer();
			sb.append("select * from books where bookName like '%");
			sb.append(keyword);
			sb.append("%' limit ?,?");
			ps=cn.prepareStatement(sb.toString());
			ps.setInt(1, pageNo);
			ps.setInt(2, Page.pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBid(rs.getInt("bId"));
				book.setBookName(rs.getString("bookName"));
				book.setImages(rs.getString("image"));
				book.setPrice(rs.getDouble("price"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void updateBookNum(int bookid,int stock){
		try {
			Init();
			String sql = "update books set stock=? where bId=? ";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, stock);
			ps.setInt(2, bookid);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
	}

	public List<String> searchbook(String keyword){
		List<String> list = new ArrayList<String>();
		try {
			Init();
			String sql = "select bookName from books where bookName like '%"+keyword+"%'";
			ps=cn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("bookName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
