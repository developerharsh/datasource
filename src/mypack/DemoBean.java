package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public int modifyData(User user) throws SQLException 
	{
		String pass="abc";
		conn = dataSource.getConnection();
		SQL = "update login set userpassword='abc' where username=?";
		pst = conn.prepareStatement(SQL);
		//pst.setString(1, pass);
		pst.setString(1, user.getUserName());
		
		return pst.executeUpdate();
	}

	@Override
	public int removeData(User user) throws SQLException 
	{
		conn = dataSource.getConnection();
		SQL = "delete from login where username=?";
		pst = conn.prepareStatement(SQL);
		pst.setString(1, user.getUserName());
		
		return pst.executeUpdate();
	}

	@Override
	public User findData(User user) throws SQLException {
		conn = dataSource.getConnection();
		ResultSet rs;
		SQL = "select * from login where username = ?";
		pst = conn.prepareStatement(SQL);
		pst.setString(1, user.getUserName());
		
		rs = pst.executeQuery();
		rs.next();
		user.setUserPassword(rs.getString("userpassword"));
		return user;
	}

	@Override
	public List<User> findAllData() throws SQLException {
		
		List<User> listUser = new ArrayList<User>();
		conn = dataSource.getConnection();
		SQL = "select * from login";
		pst = conn.prepareStatement(SQL);
		ResultSet rs;
		rs=pst.executeQuery();
		
		while(rs.next())
		{
			User user = new User();
			user.setUserName(rs.getString(1));
			user.setUserPassword(rs.getString(2));
			listUser.add(user);
		}
		
		return listUser;
	}

	
	

	


}
