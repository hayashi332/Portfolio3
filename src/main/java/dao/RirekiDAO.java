package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Purchase;

public class RirekiDAO extends DAO {

	public List<Purchase> search(int id) throws Exception {
		List<Purchase> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
				"select * from purchase where id=?");			//SQL文で表示する
		st.setInt(1,id);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {                       //ここでデータベースの情報を回す
			Purchase r=new Purchase();
			r.setSellername (rs.getString("sellername"));
			r.setPrice   	(rs.getInt("price"));
			r.setTitle	    (rs.getString("title"));
			list.add(r);
		}

		st.close();
		con.close();

		return list;

	}
}