package com.simplyshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplyshop.model.User;
import com.simplyshop.service.UserService;
import com.simplyshop.service.UserServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public UserServlet() {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		User user = userService.get(email);
		System.out.println(">> doGet " + user);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">> doPost " + this.getClass().getSimpleName());

		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		userService.save(user);
		
		response.sendRedirect("index.jsp");
	}

}
