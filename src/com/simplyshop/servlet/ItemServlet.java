package com.simplyshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplyshop.service.ItemService;
import com.simplyshop.service.ItemServiceImpl;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ItemService itemService;

	public ItemServlet() {
		itemService = new ItemServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("items", itemService.getItems());
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
