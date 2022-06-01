package kounyuu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Option;
import dao.SerchoptionDAO;
import tool.Action;

public class SerchoptionAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {
		HttpSession session=request.getSession();
		if (session.getAttribute("customer")==null) {
			return "/grasys/preview-error-login.jsp";
		}
		int itemid=Integer.parseInt(request.getParameter("itemid"));   //万が一nullになった時のためにエラー処理が必要。
    	if (itemid==0) {
			return "/grasys/item-error.jsp";                      //エラー処理
     	}
		SerchoptionDAO dao=new SerchoptionDAO();
		Option option=dao.serch(itemid);                   //ここのサーチをDAO内で変更する。 全ての出品情報をリスト化させる
    	session.setAttribute("option", option);            //セッションにオプションを登録する

		return "/grasys/purchase-in.jsp";
}
}
