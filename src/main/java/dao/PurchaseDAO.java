package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PurchaseDAO extends DAO{
	public boolean insert(int id, String sellername, int price,String title) throws Exception {
		Connection con=getConnection();
		con.setAutoCommit(false);

			PreparedStatement st=con.prepareStatement(
				"insert into purchase values(?, ?, ?, ?)");
			st.setInt(1, id);
			st.setString(2,sellername);
			st.setInt(3, price);
			st.setString(4, title);
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

