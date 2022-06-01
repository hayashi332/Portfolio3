package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class ProductDAO extends DAO{
	public List<Item> search(String keyword) throws Exception {
		List<Item> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select itemid,id,title,genre,introduction from item where title like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Item p=new Item();
			p.setTitle(rs.getString("title"));
			p.setGenre(rs.getString("genre"));
			p.setItemid(rs.getInt("itemid"));
			p.setId(rs.getInt("id"));
			p.setIntroduction(rs.getString("introduction"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}
}
