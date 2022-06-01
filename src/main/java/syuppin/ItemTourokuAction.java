package syuppin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetitemidDAO;
import dao.ItemtourokuDAO;
import dao.OptiontourokuDAO;
import tool.Action;
public class ItemTourokuAction extends Action{
//getIDでテーブルに入れるIDをとる  usernameもとる。
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		String username=request.getParameter("username");
		String rice=request.getParameter("price");                      //isEmptyに使うためだけのもの
		int price=Integer.parseInt(request.getParameter("price"));
		String title=request.getParameter("title");
		String introduction=request.getParameter("introduction");
		String genre=request.getParameter("genre");



    	if (rice.isEmpty()  || title.isEmpty()|| introduction.isEmpty() || genre.isEmpty() ) {
			return "/grasys/itemtouroku-error-empty.jsp";
		}

		ItemtourokuDAO dao=new ItemtourokuDAO();                //追加した分の要素分ここに追加
		if (dao.insert(id,username, price, title,introduction,genre)==false) {
			return "/grasys/itemtouroku-error-insert.jsp";
		}



		//***************************************
		//ここからオプションに入れる処理　オプション追加daoの起動
		//***************************************
//Integer.parseInt(request.getParameter("price1"));
		String  option1 = request.getParameter("option1");
		String 	price11 = request.getParameter("price1");   //nullの時のエラーが起きないように文字型でとりあえずいれる。
		String  option2 = request.getParameter("option2");
		String  price12 = request.getParameter("price2");
		String  option3 = request.getParameter("option3");
		String 	price13 = request.getParameter("price3");
		String  option4 = request.getParameter("option4");
		String 	price14 = request.getParameter("price4");
		String  option5 = request.getParameter("option5");
		String 	price15 = request.getParameter("price5");
		if((option1.isEmpty()&&!price11.isEmpty()) || (option2.isEmpty()&&!price12.isEmpty()) ||      //値段だけしか書いてない時のエラー処理
				(option3.isEmpty()&&!price13.isEmpty()) || (option4.isEmpty()&&!price14.isEmpty()) || (option5.isEmpty()&&!price15.isEmpty()) ) {
			return "/grasys/itemtouroku-error-optionnull.jsp";
		}


			if(!option1.isEmpty()) {                               //optionが一つでも設定されていれば全てテーブルに入れる
			OptiontourokuDAO dao1 = new OptiontourokuDAO();
			//設定されたitemid1を取り出さないとoptionに入れられない。
			GetitemidDAO dao2 = new GetitemidDAO();
			int itemid=dao2.search(introduction);   //出品情報でitemidを探す。introductionは重複しないものとする。
			if(itemid==0) {                                       //万が一正常に探せなかった場合のエラー
				return "/grasys/itemtouroku-error-optionnull.jsp";
			}
		//ここから何個のオプションを設定するかのif分
			if(option2.isEmpty()) {
				int price1 = Integer.parseInt(request.getParameter("price1"));
				int price2 = 0;
				int price3 = 0;
				int price4 = 0;
				int price5 = 0;
			if (dao1.insert(itemid,option1,price1, option2, price2,option3,price3,option4,price4,option5,price5)==false) {
			return "/grasys/itemtouroku-error-optionnull.jsp";
			}
			}
			else if(option3.isEmpty()) {
				int price1 = Integer.parseInt(request.getParameter("price1"));
				int price2 = Integer.parseInt(request.getParameter("price2"));
				int price3 = 0;
				int price4 = 0;
				int price5 = 0;
			if (dao1.insert(itemid,option1,price1, option2, price2,option3,price3,option4,price4,option5,price5)==false) {
			return "/grasys/itemtouroku-error-optionnull.jsp";
			}
			}
			else if(option4.isEmpty()) {
				int price1 = Integer.parseInt(request.getParameter("price1"));
				int price2 = Integer.parseInt(request.getParameter("price2"));
				int price3 = Integer.parseInt(request.getParameter("price3"));
				int price4 = 0;
				int price5 = 0;
			if (dao1.insert(itemid,option1,price1, option2, price2,option3,price3,option4,price4,option5,price5)==false) {
			return "/grasys/itemtouroku-error-optionnull.jsp";
			}
			}
			else if(option5.isEmpty()) {
				int price1 = Integer.parseInt(request.getParameter("price1"));
				int price2 = Integer.parseInt(request.getParameter("price2"));
				int price3 = Integer.parseInt(request.getParameter("price3"));
				int price4 = Integer.parseInt(request.getParameter("price4"));
				int price5 = 0;
			if (dao1.insert(itemid,option1,price1, option2, price2,option3,price3,option4,price4,option5,price5)==false) {
			return "/grasys/itemtouroku-error-optionnull.jsp";
			}
			}
			else{
				int price1 = Integer.parseInt(request.getParameter("price1"));
				int price2 = Integer.parseInt(request.getParameter("price2"));
				int price3 = Integer.parseInt(request.getParameter("price3"));
				int price4 = Integer.parseInt(request.getParameter("price4"));
				int price5 = Integer.parseInt(request.getParameter("price5"));
			if (dao1.insert(itemid,option1,price1, option2, price2,option3,price3,option4,price4,option5,price5)==false) {
			return "/grasys/itemtouroku-error-optionnull.jsp";
			}
			}
//			if (dao1.insert(itemid,option1,price1, option2, price2,option3,price3,option4,price4,option5,price5)==false) {
//				return "/grasys/itemtouroku-error-optionnull.jsp";
//			}
		}


		return "/grasys/itemtouroku-out.jsp";
	}


}
