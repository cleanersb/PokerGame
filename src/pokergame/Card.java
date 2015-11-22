package pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Card {
	private String number;
	private String color;
	
	public Card(){
		
	}
	public Card(String number,String color){
		this.number=number;
		this.color=color;
	}

	/**
	 * ����һ����
	 */
	public ArrayList<Card> createCards(){
		String[] cardNumber = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] cardColor = new String[]{"����","��Ƭ","÷��","����"};
		ArrayList<Card> cards = new ArrayList<>();
		
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				Card card= new Card();
				card.color=cardColor[i];
				card.number=cardNumber[j];
				cards.add(card);
			}
		}
		
		return cards;

	}
	
	/**
	 * ���ÿһ���Ƶ���Ϣ����Ϊÿһ������һ���ַ������ͣ����Է���һ���ַ������飻
	 * @return
	 */
	public String[] getNewCards(){
		//System.out.println("daxiao:"+createCards().size());
		String[] newCardGroup = new String[createCards().size()];    //************
		for(int i = 0;i < createCards().size();i ++){
			newCardGroup[i] =  createCards().get(i).color +createCards().get(i).number ;
		}
		return newCardGroup;
	}
	
	/**
	 * Create random cards
	 * @return
	 */
	public String[] RandomCard(){
		Random random = new Random();
		//�洢����˳���Ƶ����飻
		String[] cardsArray = getNewCards();  //***********
		String swapCard = null;
		for(int i = 0;i < cardsArray.length;i ++){
			int index = random.nextInt(cardsArray.length);
			swapCard = cardsArray[i];
			cardsArray[i] = cardsArray[index];
			cardsArray[index] = swapCard;
		
		}
		return cardsArray;
	}

}
