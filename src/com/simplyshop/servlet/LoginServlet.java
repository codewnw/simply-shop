package com.simplyshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplyshop.model.Login;
import com.simplyshop.model.User;
import com.simplyshop.service.LoginService;
import com.simplyshop.service.LoginServiceImpl;
import com.simplyshop.service.UserService;
import com.simplyshop.service.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;

	private UserService userService;

	public LoginServlet() {
		loginService = new LoginServiceImpl();
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		if (uri.contains("logout")) {
			HttpSession session = request.getSession(false);
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);

		if (loginService.check(login)) {
			User user = userService.get(email);

			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
