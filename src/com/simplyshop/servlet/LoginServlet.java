package com.simplyshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplyshop.model.Login;
import com.simplyshop.service.LoginService;
import com.simplyshop.service.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;

	public LoginServlet() {
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);

		if (loginService.check(login)) {
			request.getRequestDispatcher("profile.jsp").forward(request, response);

		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
