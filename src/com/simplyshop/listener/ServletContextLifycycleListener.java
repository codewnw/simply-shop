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
		String dropTables = sce.getServletContext().getInitParameter("dropTables");
		String createTables = sce.getServletContext().getInitParameter("createTables");

		if (dropTables.equalsIgnoreCase("Yes")) {
			System.out.println("Droping tables.");
			DbUtil.dropTables();
		} else {
			System.out.println("No need to drop the tables");
		}

		if (createTables.equalsIgnoreCase("Yes")) {
			System.out.println("Creating tables.");
			DbUtil.createTables();
		} else {
			System.out.println("Table creation not required.");
		}
	}

}
