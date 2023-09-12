package FoodApp_pro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FoodApp_pro.dao.MenuDao;
import FoodApp_pro.dto.Menu;

@WebServlet("/editmenu")
public class EditMenuController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));	
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		long price = Long.parseLong(req.getParameter("price"));
		
		String offer = req.getParameter("offer");
		
		Menu m1 = new Menu();
		
		m1.setId(id);
		m1.setName(name);
		m1.setDescription(description);
		m1.setPrice(price);
		m1.setOffer(offer);
		
		MenuDao dao = new MenuDao();
		
		Menu Menu2 = dao.updateMenu(m1);
		
		if(Menu2 != null) {
			
			List<Menu> Menus = dao.getAllMenus();
			//according to part of collection can be used :
			
			req.setAttribute("menus", Menus);
			RequestDispatcher dispatcher = req.getRequestDispatcher("menu.jsp");
			dispatcher.forward(req, resp);
			
			
		}
			
			
		}
}
		
		
		
		
		


