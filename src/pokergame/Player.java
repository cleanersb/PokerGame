package pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
	private int id;
	private String name;
    ArrayList<String> cards = new ArrayList<>();
	
    //�޲������캯��
	public Player(){
		
	}
	
	//�в������캯��
	public Player(int id,String name){
		this.setId(id);
		this.setName(name);
		
	}
	
	//��ȡ������Ϣ
	public ArrayList<String> getCards(){
		return cards;
	}
	
	//����������Ϣ
	public void setCards(String card){
		cards.add(card);
	}
	
	//��ȡid
	public int getId() {
		return id;
	}

	//����id
	public void setId(int id) {
		this.id = id;
	}

	//��ȡ����
	public String getName() {
		return name;
	}

	//��������
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ��ȡ��������ֵ��
	 * @return
	 */
	public String getMaxCard(){
		Map<String,Integer> cardCompare= new HashMap<>();
		cardCompare.put("����",4);
		cardCompare.put("����",3);
		cardCompare.put("÷��",2);
		cardCompare.put("��Ƭ",1);
		
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
	 * ��J��K��Q��Aת��Ϊ11 13 12 1 �⼸����������Ƚϣ�
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
