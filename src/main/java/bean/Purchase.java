package bean;

public class Purchase implements java.io.Serializable {
	//ここで履歴画面のゲッタとセッタを管理する{
	private int id;
	private String sellername;
	private int price;
	private String title;

public int getId() {
	return id;

}
public String getSellername() {
	return sellername;

}
public int getPrice() {
	return price;

}
public String getTitle() {
	return title;
}
public void setId(int id) {
	this.id=id;
}

public void setSellername(String sellername) {
	this.sellername=sellername;
}

public void setPrice(int price) {
	this.price=price;

}

public void setTitle(String title) {
	this.title=title;
}

}


