package cao.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cao.bean.User;
import cao.service.UserService;


@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		user.setUsername(username);
		user.setPassword(password);
		String code1 = request.getParameter("password3");
		String code2 = (String) request.getSession().getAttribute("checkcode");
		if (code1.equalsIgnoreCase(code2)) {
			if (!user.checkUsernameAndpassword()) {
				boolean b =new UserService().findNameIsExist(user);
				if (b) {
					new UserService().insertUser(user);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "用户名已存在");
					request.getRequestDispatcher("/regist.jsp").forward(request, response);

				}
			}else {
				request.setAttribute("msg", "格式不对");
				request.getRequestDispatcher("/regist.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "验证码不正确");
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
