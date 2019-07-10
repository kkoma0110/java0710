package com.wt.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.dao.IUserDAO;
import com.wt.dao.impl.UserDAOImpl;
import com.wt.po.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserDAO dao = new UserDAOImpl();  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if(method==null||method.equals("findAll")) {
			findAll(request,response);
		}
		else if(method.equals("addUser")) {
			addUser(request,response);
		}
		else if(method.equals("delete")) {
			delete(request,response);
		}	
		else if(method.equals("edit")) {
			edit(request,response);
		}else if(method.equals("change")) {
			change(request,response);
		}
		
	}

	private void change(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		String birthdayStr = request.getParameter("birthday");
		String moneyStr = request.getParameter("money");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = sdf.parse(birthdayStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User user = new User();
		user.setUid(uid);
		user.setUname(uname);
		user.setBirthday(birthday);
		user.setMoney(Double.parseDouble(moneyStr));
		
		dao.update(user);
		response.sendRedirect("UserServlet.do");
	}
	

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		User user = dao.findOne(uid);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		dao.delete(uid);
		response.sendRedirect("UserServlet.do");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> userList = dao.findAll();
		request.setAttribute("userList",userList);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		try {
			String uname = request.getParameter("uname");
			String birthdayStr = request.getParameter("birthday");
			String moneyStr = request.getParameter("money");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date birthday = sdf.parse(birthdayStr);
			
			
			User user = new User();
			user.setUname(uname);
			user.setBirthday(birthday);
			user.setMoney(Double.parseDouble(moneyStr));
			
			dao.save(user);
			response.sendRedirect("UserServlet.do");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
