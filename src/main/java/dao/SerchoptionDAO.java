package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Option;

public class SerchoptionDAO extends DAO{
	public Option serch(int itemid)
			throws Exception{
	    Option option=null;
		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			"select * from option where itemid=?");
		st.setInt(1, itemid);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			option=new Option();
			option.setItemid(rs.getInt("itemid"));
			option.setOption1(rs.getString("option1"));                   
			option.setPrice1(rs.getInt("price1"));
			option.setOption2(rs.getString("option2"));
			option.setPrice2(rs.getInt("price2"));
			option.setOption3(rs.getString("option3"));
			option.setPrice3(rs.getInt("price3"));
			option.setOption4(rs.getString("option4"));
			option.setPrice4(rs.getInt("price4"));
			option.setOption5(rs.getString("option5"));
			option.setPrice5(rs.getInt("price5"));
		}

		st.close();
		con.close();
		return option;

	}
}
