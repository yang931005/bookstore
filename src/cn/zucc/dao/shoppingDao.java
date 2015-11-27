package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.entity.Book;
import cn.zucc.entity.Shopping;

public class shoppingDao extends baseDao {
	
	public Book findBookByname(String name){
		Book book = new Book();
		try {
			Init();
			String sql = "select *from books where bookName = ?";
			ps = cn.prepareStatement(sql);
			ps.setString(1,name );
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
	public void addShopping(Shopping shopping){
		try {
			Init();
			String sql="insert into shopping(bookname,image,count,price,oid) values(?,?,?,?,?)";
			ps=cn.prepareStatement(sql);
			ps.setString(1,shopping.getBookName());
			ps.setString(2,shopping.getImages());
			ps.setInt(3,shopping.getCount());
			ps.setDouble(4, shopping.getPrice());
			ps.setInt(5, shopping.getOid());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ìí¼ÓÊ§°Ü");
			e.printStackTrace();
		}finally{
			myclose();
		}
		
	}
	public List<Shopping> findall (int oid){
		List<Shopping> list = new ArrayList<Shopping>();
		try {
			Init();
			String sql = "select * from shopping where oid=?";
			ps=cn.prepareStatement(sql);
			ps.setInt(1, oid);
			rs=ps.executeQuery();
			while(rs.next()){
				Shopping shopping = new Shopping();
				shopping.setBookName(rs.getString("bookname"));
				shopping.setId(rs.getInt("id"));
				shopping.setCount(rs.getInt("count"));
				shopping.setImages(rs.getString("image"));
				shopping.setOid(rs.getInt("oid"));
				shopping.setPrice(rs.getDouble("price"));
				list.add(shopping);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
		return list;
	}
	
	public void delshopping(int oid){
			try {
				Init();
				String sql = "delete from shopping where oid = ?";
				ps=cn.prepareStatement(sql);
				ps.setInt(1, oid);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("É¾³ýÊ§°Ü");
				e.printStackTrace();
			}finally{
				myclose();
			}
	}
	public Shopping findshopping(String name,int oid){
		Shopping shopping = null;
		try {
			Init();
			String sql = "select * from shopping where bookname =? and oid=?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, oid);
			rs=ps.executeQuery();
			if(rs.next()){
				shopping = new Shopping() ;
				shopping.setBookName(rs.getString("bookname"));
				shopping.setId(rs.getInt("id"));
				shopping.setCount(rs.getInt("count"));
				shopping.setImages(rs.getString("image"));
				shopping.setOid(rs.getInt("oid"));
				shopping.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
		return shopping;
		
	}
	public void deleteshopping(String bookname){
		try {
			Init();
			String sql = "delete from shopping where bookname =?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, bookname);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("É¾³ýÊ§°Ü");
			e.printStackTrace();
		}finally{
			myclose();
		}
	}
}
