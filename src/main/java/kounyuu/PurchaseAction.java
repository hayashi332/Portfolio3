package kounyuu;
//オプションがあるかどうか確認したうえで押されたitemのpriceをプラスしたものをpriceとしてもってくる？Listで？

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.Item;
import bean.Option;
import dao.PurchaseDAO;
import tool.Action;

public class PurchaseAction  extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		int addprice  = 0;
		int price = 0;
//		int price1 = 0;    繰り返しで簡単に記述できたのでいらない
//		int price2 = 0;
//		int price3 = 0;
//		int price4 = 0;
//		int price5 = 0;

		HttpSession session=request.getSession();
		String option1=null;
//    	String option2 = option.getOption2();     今のレベルの処理では使わない。
//    	String option3 = option.getOption3();
//    	String option4 = option.getOption4();
//    	String option5 = option.getOption5();

    	Customer customer= (Customer)session.getAttribute("customer");
    	int id = customer.getId();

    	String [] price0=request.getParameterValues("price");
    	Item item = (Item)session.getAttribute("item");
//    	int id = item.getId();
    	String sellername = item.getUsername();
    	String title = item.getTitle();
    	int sprice = item.getPrice();
    	Option option = (Option)session.getAttribute("option");

    	try {
    		option1 = option.getOption1();
    		} catch (Exception e) {
    		// 例外の場合の処理
        		PurchaseDAO dao=new PurchaseDAO();
        		price=sprice;
        		if (!dao.insert(id,sellername,price,title)) {
        			return "purchase-error-insert.jsp";
        		}
            	return "/grasys/purchase-out.jsp";

    		}


 //   	String option1 = option.getOption1();
    	if(price0[0]==null&&option1==null) {     //オプションが一つもないとき
    		price=sprice;
    		PurchaseDAO dao=new PurchaseDAO();
    		if (!dao.insert(id,sellername,price,title)) {
    			return "purchase-error-insert.jsp";
    		}
        	return "/grasys/purchase-out.jsp";
    	}

        for (int index = 0; index < price0.length; index ++) {
             addprice += Integer.parseInt(price0[index]);
        }


    	price=sprice+addprice;



    	//*****仮
		PurchaseDAO dao=new PurchaseDAO();
		if (!dao.insert(id,sellername,price,title)) {
			return "purchase-error-insert.jsp";
		}
    	return "/grasys/purchase-out.jsp";
	}
}