package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Item;

public class ItemDAO extends DAO {
	public Item serch(int itemid)
			throws Exception{
		Item item=null;
		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			"select * from item where itemid=?");
		st.setInt(1, itemid);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			item=new Item();
			item.setId(rs.getInt("id"));
			item.setItemid(rs.getInt("itemid"));                   
			item.setUsername(rs.getString("username"));
			item.setPrice(rs.getInt("price"));
			item.setTitle(rs.getString("title"));
			item.setIntroduction(rs.getString("introduction"));
			item.setGenre(rs.getString("genre"));
		}

		st.close();
		con.close();
		return item;

	}

}
