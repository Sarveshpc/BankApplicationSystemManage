package FoodApp_pro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FoodApp_pro.dao.ItemsDao;
import FoodApp_pro.dto.Items;

@WebServlet("/editorder")
public class EditOrderController extends HttpServlet {
	static 	Items Items3;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		long price = Long.parseLong(req.getParameter("price"));
		
		String offer = req.getParameter("Offer");
		long quantity = Long.parseLong(req.getParameter("quantity"));
		
		//if we want to access all attributes get passed :
		//According to a proper smart code deals with us:
		// all data fetch to FE to convert Backend all 
		
		Items i1 = new Items();
		
		i1.setId(id);
		i1.setName(name);
		i1.setDescription(description);
		i1.setPrice(price);
		i1.setOffer(offer);
		i1.setQuantity(quantity);
		
	    ItemsDao dao = new ItemsDao();
	    
	    for(Items Items2  : ConfirmOrderController.list) {
	    	
	    	if(id == Items2.getId()) {
	    		
	    		Items3 = Items2;
	    		//swapp
	    	}
	    }
	    
	    ConfirmOrderController.list.remove(Items3);
	    
	    Items items2 = dao.updateItems(i1);
	    
	    ConfirmOrderController.list.add(items2);
	}
}
	    
	    
	    
	    		
	    		
	    

