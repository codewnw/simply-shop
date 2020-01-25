package com.simplyshop.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplyshop.model.Item;
import com.simplyshop.service.ItemService;
import com.simplyshop.service.ItemServiceImpl;

@WebServlet("/checkouts/*")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemService itemService;

	public CheckoutServlet() {
		itemService = new ItemServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Here");
		String uri = request.getRequestURI();
		if (uri.contains("checkouts/ITEM_")) {
			String[] content = uri.split("/");
			int length = content.length;
			System.out.println(content[length - 1]);
			List<Item> items = new ArrayList<>();
			items.add(itemService.getItem(content[length - 1]));
			request.setAttribute("items", items);
			request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);
		} else if (uri.contains("checkouts/items")) {
			String[] ids = request.getParameterValues("itemId");
			List<Item> items = new ArrayList<>();
			for (int i = 0; i < ids.length; i++) {
				items.add(itemService.getItem(ids[i]));
			}

			request.setAttribute("items", items);
			request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);

		} else {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
