package serch;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.ProductDAO;
import tool.Action;

public class ProductAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {

		HttpSession session=request.getSession();
		String keyword=request.getParameter("keyword");
		if (keyword==null) keyword="";

			ProductDAO dao=new ProductDAO();
			List<Item> list=dao.search(keyword);   //ここのサーチをDAO内で変更する。 全ての出品情報をリスト化させる

			session.setAttribute("list", list);       //全ての出品情報のリストをjspで持ってこれるようにsetする。

			return "/grasys/product.jsp";
		}
}
