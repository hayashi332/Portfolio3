package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetitemidDAO extends DAO{
	public int search(String introduction) throws Exception {

		Connection con=getConnection();
		int itemid = 0;

		PreparedStatement st=con.prepareStatement(
			"select itemid from item where introduction like ?");
		st.setString(1, "%"+introduction+"%");
		ResultSet rs=st.executeQuery();
		while (rs.next()) {
			itemid = rs.getInt("itemid");
		}
		st.close();
		con.close();

		return itemid;
	}
}
