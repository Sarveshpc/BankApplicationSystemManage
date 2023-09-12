package FoodApp_pro.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FoodApp_pro.dao.MenuDao;
import FoodApp_pro.dto.Menu;

@WebServlet("/delete")
public class DeleteMenuController extends HttpServlet {
	
	
	     @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	// TODO Auto-generated method stub
	 	int id = Integer.parseInt(req.getParameter("id"));	
		MenuDao dao = new MenuDao();
		boolean result = dao.deleteMenu(id);
		
		if(result) {
			
			List<Menu> Menus = dao.getAllMenus();
			req.setAttribute("menus", Menus);
			RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
			


