package FoodApp_pro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import FoodApp_pro.dao.ItemsDao;
import FoodApp_pro.dto.Items;

@WebServlet("/saveorder")
public class ConfirmOrderController extends HttpServlet {
	
	static List<Items> list = new ArrayList<>();
	private Object SaveUserController;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String description = req.getParameter("description");
	    //by using String is convert to int type of data :
		//according to by using Wrapper class :
		
		long price =  Long.parseLong(req.getParameter("price"));
		String Offer = req.getParameter("Offer");
		
		long quantity = Long.parseLong(req.getParameter("quantity"));
		
		Items i1 = new Items();
		i1.setName(name);
		i1.setDescription(description);
		i1.setPrice(price);
		i1.setOffer(Offer);
		i1.setQuantity(quantity);
		
		ItemsDao dao = new ItemsDao();
		Items items2 = dao.saveItems(i1);
		
	     list.add(items2);
	    
	    if(items2 != null) {
	    	
	    	req.setAttribute("list", list);
	    	req.setAttribute("user", SaveUserController.user);
	    	
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("foodorder.jsp");
	    	dispatcher.forward(req, resp);
	    	
	    }
	}
}
	    	
	    	
	    	
	    	
		
		
	
		
	    
		
		
		
	