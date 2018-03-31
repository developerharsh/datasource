package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class DemoBean implements Demo
{
	private String SQL;
	private Connection conn;
	private PreparedStatement pst;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int addData(User user) throws SQLException {
		
		conn = dataSource.getConnection();
		SQL = "insert into login values (?,?)";
		pst = conn.prepareStatement(SQL);
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getUserPassword());
		
		return pst.executeUpdate();
	}

	@Override
	public int modifyData(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeData(User user) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findData(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllData(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	


}
