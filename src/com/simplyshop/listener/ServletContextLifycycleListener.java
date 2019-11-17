package com.simplyshop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.simplyshop.dao.util.DbUtil;

@WebListener
public class ServletContextLifycycleListener implements ServletContextListener {

	public ServletContextLifycycleListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		String createTables = sce.getServletContext().getInitParameter("createTables");
		if (createTables.equalsIgnoreCase("Yes")) {
			System.out.println("Creating tables.");
			DbUtil.createTables();
		} else {
			System.out.println("Table creation not required.");
		}
	}

}
