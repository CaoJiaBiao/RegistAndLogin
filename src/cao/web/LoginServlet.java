package cao.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import cao.service.UserService;

import cao.bean.User;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean temp1= new UserService().LoginByNameAndPassword(user);
		if (!temp1) {
			//登录失败
			request.setAttribute("login_msg", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			System.out.println("登录成功");
			request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
		}
//		try {
//	
//			if (u != null) {
//
//				// 判断用户是否勾选记住密码
//				if (request.getParameter("rember") != null) {
//					Cookie uc = new Cookie("username", u.getUsername());
//					Cookie pc = new Cookie("password", user.getPassword());
//					// 设置Cookie
//					String time = request.getParameter("rembertime");
//					int timeNum = Integer.parseInt(time);
//					uc.setMaxAge(60 * 60 * 24 * timeNum);
//					pc.setMaxAge(60 * 60 * 24 * timeNum);
//					// 添加cookie
//					response.addCookie(uc);
//					response.addCookie(pc);
//
//				}
//				// 登录成功跳转主页面
//				request.getSession().setAttribute("user", u);
//				response.sendRedirect(request.getContextPath() + "/main.jsp");
//
//			} else {
//
//				// 跳转到登录页面继续登录
//				request.setAttribute("login_msg", "用户名或密码错误");
//				request.getRequestDispatcher("/login.jsp").forward(request,
//						response);
//
//			}
//		} catch (NoSuchAlgorithmException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
