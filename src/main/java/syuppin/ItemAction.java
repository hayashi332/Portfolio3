package syuppin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.Item;
import dao.ItemDAO;
import tool.Action;

public class ItemAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		HttpSession session=request.getSession();

		int itemid=Integer.parseInt(request.getParameter("itemid"));   //万が一nullになった時のためにエラー処理が必要。
    	if (itemid==0) {
			return "/grasys/item-error.jsp";                      //エラー処理
     	}
		ItemDAO dao=new ItemDAO();
		Item item=dao.serch(itemid);   //ここのサーチをDAO内で変更する。 全ての出品情報をリスト化させる
    	session.setAttribute("item", item);
		if (session.getAttribute("customer")==null) {     //ログインしていないときの処理　（nullpointerの防止）
			return "/grasys/item.jsp";
		}
    	Customer customer = (Customer)session.getAttribute("customer");
    	int id = customer.getId();
	    if(item.getId()==id) {
	    	return "/grasys/hostitem.jsp";
	    }
	    else {
			return "/grasys/item.jsp";
	    }
	}

}
