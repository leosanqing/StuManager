package cn.swu.stormleo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.stormleo.dao.StuDao;
import cn.swu.stormleo.dao.UserDao;
import cn.swu.stormleo.daoImpl.StuDaoImpl;
import cn.swu.stormleo.daoImpl.UserDaoImpl;
import cn.swu.stormleo.domain.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String userName =  request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("UserName"+userName+"password"+password);

		UserDao dao=new UserDaoImpl();
		boolean isSuccess=dao.login(userName, password);
		if(isSuccess)
		{
			// response.getWriter().write("Success");
			
			StuDao stuDao=new StuDaoImpl();
			List <Student>list=stuDao.findAll();
			
			
			// 把信息存到服务器
			request.getSession().setAttribute("list", list);
			
			// 重定向跳到学生列表
			response.sendRedirect("stu_list.jsp");
			
		}else {
			response.getWriter().write("false");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
