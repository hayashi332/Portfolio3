package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OptiontourokuDAO extends DAO{
	public boolean insert(int itemid,String option1,int price1,String option2,int price2,String option3,int price3,
			String option4,int price4,String option5,int price5) throws Exception {
		Connection con=getConnection();
		con.setAutoCommit(false);
			PreparedStatement st=con.prepareStatement(
					"insert into option (itemid,option1,price1,option2,price2,option3,price3,\r\n" +
					"option4,price4,option5,price5) values(?,?,?,?,?,?,?,?,?,?,?)");

			st.setInt(1, itemid);
			st.setString(2, option1);
			st.setInt(3, price1);
			st.setString(4, option2);
			st.setInt(5, price2);
			st.setString(6, option3);
			st.setInt(7, price3);
			st.setString(8, option4);
			st.setInt(9, price4);
			st.setString(10, option5);
			st.setInt(11, price5);

			int line=st.executeUpdate();
			st.close();

			if (line!=1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false;
			}

			con.commit();
			con.setAutoCommit(true);
			con.close();
				return true;
			}
}
