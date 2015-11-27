package cn.zucc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zucc.entity.Book;
import cn.zucc.entity.Item;
import cn.zucc.entity.User;
import cn.zucc.util.Page;

public class itemDao extends baseDao{

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
	public void addItem(Item item){
		try {
			Init();
			String sql="insert into Items (oId,bId,createDate,count,price,total_Price,username)values(?,?,?,?,?,?,?)";
			ps=cn.prepareStatement(sql);
			ps.setInt(1,item.getOid());
			ps.setInt(2,item.getBid());
			ps.setString(3,item.getCreatDate());
			ps.setInt(4, item.getCount());
			ps.setDouble(5, item.getPrice());
			ps.setDouble(6, item.getTotalPrice());
			ps.setString(7,item.getUsername());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ìí¼ÓÊ§°Ü");
			e.printStackTrace();
		}finally{
			myclose();
		}
		
	}
	public List<Item> findall (int oId){
		List<Item> list = new ArrayList<Item>();
		try {
			Init();
			String sql = "select * from items where oId=?";
			ps=cn.prepareStatement(sql);
			ps.setInt(1, oId);
			rs=ps.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setBid(rs.getInt("bId"));
				item.setIid(rs.getInt("iId"));
				item.setOid(rs.getInt("oId"));
				item.setCount(rs.getInt("count"));
				item.setCreatDate(rs.getString("createDate"));
				item.setPrice(rs.getDouble("price"));
				item.setTotalPrice(rs.getDouble("total_Price"));
				list.add(item);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
		return list;
		
	}
	
	public void delitem(int id){
			try {
				Init();
				String sql = "delete from items where bId = ?";
				ps=cn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("É¾³ýÊ§°Ü");
				e.printStackTrace();
			}finally{
				myclose();
			}
	}
	public List<Item> findItemByName(String name,int pageNo){
		List<Item> list = new ArrayList<Item>();
		try {
			Init();
			String sql = "select * from items where username=? limit ?,?";
			ps=cn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, pageNo);
			ps.setInt(3, Page.pageSize);
			rs=ps.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setBid(rs.getInt("bId"));
				item.setIid(rs.getInt("iId"));
				item.setOid(rs.getInt("oId"));
				item.setCount(rs.getInt("count"));
				item.setCreatDate(rs.getString("createDate"));
				item.setPrice(rs.getDouble("price"));
				item.setTotalPrice(rs.getDouble("total_Price"));
				item.setUsername(rs.getString("username"));
				list.add(item);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			myclose();
		}
		return list;
	}
}
