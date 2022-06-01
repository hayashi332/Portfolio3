package rireki;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.Purchase;
import dao.RirekiDAO;
import tool.Action;

public class RirekiAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {

			HttpSession session=request.getSession();

			if (session.getAttribute("customer")==null) {
				return "/grasys/preview-error-login.jsp";
			}

	    	Customer customer = (Customer)session.getAttribute("customer");
	    	int id = customer.getId();


			RirekiDAO dao=new RirekiDAO();
			List<Purchase> list=dao.search(id);
			if(list==null) {
				return "/grasys/norireki.jsp";
			}
			session.setAttribute("rireki", list);

			return "/grasys/rireki.jsp";
		}
	}
