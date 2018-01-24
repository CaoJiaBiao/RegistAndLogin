package cao.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import cao.bean.User;
import cao.utils.UUIDUtils;
import cao.Dao.UserDao;

public class UserService {
	UserDao dao = new UserDao();
	public User loginByUser(User user) throws NoSuchAlgorithmException,SQLException {
		//User u = dao.loginByUsernameAndPassword(user);
		//return u;
		return null;
	}
	public void insertUser(User user) {
		dao.insertUser(user);
	}
	public boolean findNameIsExist(User user) {
		boolean result = true;
		user.setUid(UUIDUtils.getUID());
		try {
			result = dao.findNameIsExist(user.getUsername());//如果数据库中存在，就返回假
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
	public boolean LoginByNameAndPassword(User user) {
		UserDao dao = new UserDao();
		boolean result = false;
		try {
			result = dao.loginByUsernameAndPassword(user);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}
}
