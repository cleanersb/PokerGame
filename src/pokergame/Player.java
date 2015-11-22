package pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
	private int id;
	private String name;
    ArrayList<String> cards = new ArrayList<>();
	
    //无参数构造函数
	public Player(){
		
	}
	
	//有参数构造函数
	public Player(int id,String name){
		this.setId(id);
		this.setName(name);
		
	}
	
	//获取手牌信息
	public ArrayList<String> getCards(){
		return cards;
	}
	
	//设置手牌信息
	public void setCards(String card){
		cards.add(card);
	}
	
	//获取id
	public int getId() {
		return id;
	}

	//设置id
	public void setId(int id) {
		this.id = id;
	}

	//获取姓名
	public String getName() {
		return name;
	}

	//设置姓名
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取手牌最大的值；
	 * @return
	 */
	public String getMaxCard(){
		Map<String,Integer> cardCompare= new HashMap<>();
		cardCompare.put("黑桃",4);
		cardCompare.put("红桃",3);
		cardCompare.put("梅花",2);
		cardCompare.put("方片",1);
		
		String maxCard=null;
		ArrayList<String> cards=getCards();
		int a=transfer(cards.get(0));
		int b=transfer(cards.get(1));
		
		if(a>b)
			maxCard=cards.get(0);
		else if(a<b)
			maxCard=cards.get(1);
		else{
			String card1=cards.get(0).substring(0,2);
			String card2=cards.get(1).substring(0,2);
			
			if(cardCompare.get(card1)>cardCompare.get(card2))
				maxCard=cards.get(0);
			else if(cardCompare.get(card1)<cardCompare.get(card2))
				maxCard=cards.get(1);
			else 
				maxCard=cards.get(0);
		}
		return maxCard;
	}

	/**
	 * 把J，K，Q，A转换为11 13 12 1 这几个数，方便比较；
	 * @param str
	 * @return
	 */
	private int transfer(String str) {
		int a;
		if(str.substring(2).equals("J"))
			a=11;
		else if(str.substring(2).equals("Q"))
			a=12;
		else if(str.substring(2).equals("K"))
			a=13;
		else if(str.substring(2).equals("A"))
			a=1;
		else
			a=Integer.parseInt(str.substring(2));
		return a;
	}


}
