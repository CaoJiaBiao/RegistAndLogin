package cao.Dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cao.bean.User;
import cao.utils.MD5Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDao {
	public boolean loginByUsernameAndPassword(User user) throws SQLException,NoSuchAlgorithmException {
		boolean result = false;
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection con = ds.getConnection();
		String sql = "select * from usertable where username=? and password=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, MD5Utils.getMD5(user.getPassword()));
		ResultSet rs = statement.executeQuery();
		result = rs.next();
		return result;

	}
	
	public void insertUser(User user) {
		try {
			ComboPooledDataSource ds = new ComboPooledDataSource();
			Connection connection = ds.getConnection();
			String password = MD5Utils.getMD5(user.getPassword());
			String sql = "insert into usertable(UUID,username,password) values(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUid());
			statement.setString(2, user.getUsername());
			statement.setString(3, password);
			statement.executeUpdate();
			ds.close();
			statement.close();
			
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	
	public boolean findNameIsExist1(String name) throws SQLException {
//		ComboPooledDataSource ds = new ComboPooledDataSource();
//		Connection conn = ds.getConnection();
		String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���mydata
		 String url = "jdbc:mysql://localhost:3306/user";
		//MySQL����ʱ���û���
		String user = "root";
		//MySQL����ʱ������
		String password = "123456";
		//������ѯ�����
		boolean b = false;
		try {
		//������������
	    Class.forName(driver);
		//1.getConnection()����������MySQL���ݿ⣡��
		Connection con = DriverManager.getConnection(url,user,password);
		//Statement statement = con.createStatement();
		String sql = "select * from usertable where username=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet resultSet = statement.executeQuery();
		b = resultSet.next();

		//	ds.close();
			con.close();
			statement.close();
			resultSet.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}
	public boolean findNameIsExist(String name) throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		
		boolean b = false;

		String sql = "select * from usertable where username=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet resultSet = statement.executeQuery();
		b = resultSet.next();
		ds.close();
		statement.close();
		resultSet.close();	
		return !b;
	}
}
