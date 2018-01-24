package cao.web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 创建图片对象
				int width = 80;
				int height = 50;
				BufferedImage img = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_BGR);
				// 美化图片
				Graphics g = img.getGraphics();// 获取画笔

				// 设置颜色
				g.setColor(Color.PINK);
				// g.setColor(Color.TRANSLUCENT);

				// 填充背景
				g.fillRect(0, 0, width, height);
				// 画边框
				// 换个颜色
				g.setColor(Color.BLUE);
				// 注意减去边框的一个像素
				g.drawRect(0, 0, width - 1, height - 1);

				// 给图片上画字
				g.setColor(Color.RED);
				// g.drawString("A", width / 5 * 1, height / 2);
				// g.drawString("B", width / 5 * 2, height / 2);
				// g.drawString("C", width / 5 * 3, height / 2);
				// g.drawString("D", width / 5 * 4, height / 2);
				String msg = "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
				Random rd = new Random();
				StringBuffer sb = new StringBuffer();
				for (int i = 1; i <= 4; i++) {
					int j = rd.nextInt(msg.length());
					// String.valueOf(msg.charAt(j));
					char ch = msg.charAt(j);
					g.drawString(ch + "", width / 5 * i, height / 2);
					sb.append(ch);// 拼好验证码

				}
				// 存入会话域
				request.getSession().setAttribute("checkcode", sb.toString());

				// 画干扰线
				g.setColor(Color.GREEN);

				for (int i = 0; i < 5; i++) {
					int x1 = rd.nextInt(width);
					int x2 = rd.nextInt(width);
					int y1 = rd.nextInt(height);
					int y2 = rd.nextInt(height);
					g.drawLine(x1, y1, x2, y2);

				}

				// 把图片响应回去
				ImageIO.write(img, "jpg", response.getOutputStream());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
