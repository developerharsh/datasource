package mypack;

import java.sql.SQLException;
import java.util.List;

public interface Demo 
{
	int addData(User user) throws SQLException;
	int modifyData(User user) throws SQLException;
	int removeData(User user) throws SQLException;
	User findData(User user) throws SQLException;
	List<User> findAllData() throws SQLException;
}
