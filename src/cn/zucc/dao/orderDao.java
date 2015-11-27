package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.entity.Book;
import cn.zucc.entity.Order;
import cn.zucc.entity.Shopping;

public class orderDao extends baseDao{
	public Order findorderByName(String name,int state){
		Order order = null;
			try {
				Init();
				String sql = "select * from orders where username = ? and state = ?";
				ps = cn.prepareStatement(sql);
				ps.setString(1,name );
				ps.setInt(2, state);
				rs=ps.executeQuery();
				if(rs.next()){
					order = new Order() ;
					order.setOid(rs.getInt("oId"));
					order.setUserName(rs.getString("username"));
					order.setState(rs.getInt("state"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				myclose();
			}
			return order;
			
		}
	public void addorder(Order order){
		try {
			Init();
			String sql = "insert into orders(username) value(?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1,order.getUserName());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
	}
	public Shopping findShoppingById(int id){
		Shopping shopping = null;
		try {
			Init();
			String sql = "select * from shopping where id = ?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1,id );
			rs=ps.executeQuery();
			if(rs.next()){
				shopping = new Shopping() ;
				shopping.setId(rs.getInt("id"));
				shopping.setCount(rs.getInt("count"));
				shopping.setBookName(rs.getString("bookname"));
				shopping.setImages(rs.getString("image"));
				shopping.setOid(rs.getInt("oid"));
				shopping.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopping;
	}
	public void updatestate(int id){
		int i = 1;
		try {
			Init();
			String sql = "update orders set state=? where oId=?";
			ps = cn.prepareStatement(sql);
			ps.setInt(1, i);
			ps.setInt(2, id);
			ps.execute();
			// TODO Auto-generated catch block

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
			myclose();
		}
	}
	public List<Order> findorders(String name,int state){
		List<Order> list = new ArrayList<Order>();
		Order order = null;
			try {
				Init();
				String sql = "select * from orders where username = ? and state = ?";
				ps = cn.prepareStatement(sql);
				ps.setString(1,name );
				ps.setInt(2, state);
				rs=ps.executeQuery();
				while(rs.next()){
					order = new Order() ;
					order.setOid(rs.getInt("oId"));
					order.setUserName(rs.getString("username"));
					order.setState(rs.getInt("state"));
					list.add(order);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				myclose();
			}
			return list;
			
		}
	public Book findBooks(int id){
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
	public int findPagecount(String name){
		int count = 0;
			try {
				Init();
				String sql = "select count(*) from items where username = ?";
				ps = cn.prepareStatement(sql);
				ps.setString(1, name);
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
}
