package com.demo.Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.Dao.UserDao;
import com.demo.Vo.User;

import java.io.*;
import java.util.List;

public class UserServlet extends HttpServlet {

	String xmlPath = "classpath:resources/spring/beans.xml";
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
	UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");

		if("addUser".equals(action))
			addUser(request, response);
	}

	public void addUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		List<User> listuser=userDao.findAll();
		boolean flag=false;
		for(User user: listuser){

			if(username.equals(user.getUsername())){
				flag=true;
			}
		}
		if(flag==false){
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			userDao.add(user);
			response.sendRedirect(request.getContextPath()+"/success.jsp");
		}
		else{
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}


		
	}

	

}
