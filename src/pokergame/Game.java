package pokergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Card card = new Card();
		Scanner in = new Scanner(System.in);
		Player[] player = new Player[2];
		System.out.println("**********开始创建扑克牌**********");
		System.out.println("**********扑克牌创建成功**********");
		System.out.println(Arrays.toString(card.getNewCards()));  //把牌全部显示出来；
		System.out.println("**********开始洗牌**********");
		String[] cardsRandom = card.RandomCard();
		System.out.println(Arrays.toString(cardsRandom));  //显示洗牌结果；
		System.out.println("**********洗牌结束**********");
		System.out.println("***********创建玩家**********");
		
		for(int i=0;i<player.length;i++){
			System.out.println("请输入第" + (i+1) + "玩家的ID和姓名");
			System.out.println("请输入ID：");
			int id1=in.nextInt();
			System.out.println("请输入姓名：");
			String name1=in.next();
			Player player1=new Player(id1,name1);
			player[i]=player1;
		}
		
		/**
		 *显示游戏玩家的名字
		 */
		for(int i=0;i<player.length;i++){
			System.out.println("***欢迎玩家："+player[i].getName());
		}
		
		System.out.println("***********开始发牌**********");
		for(int i=0;i<4;i++){
			System.out.println("玩家"+player[i%2].getName()+"-拿牌");
			Random random= new Random();
			int index=random.nextInt(cardsRandom.length);
			player[i%2].setCards(cardsRandom[index]);
		}
		
		System.out.println("***********发牌结束**********");
		System.out.println("***********开始游戏**********");
		String[] cardsCom = new String[2];
		for(int i=0;i<2;i++){
			cardsCom[i]=player[i].getMaxCard();
			System.out.println("玩家："+player[i].getName()+"最大手牌为"+player[i].getMaxCard());
		}
		
		int result=maxcard(cardsCom);
		
		if(result==1){
			System.out.println("**************玩家："+player[0].getName()+"获胜！**************");
		}
		else if(result==-1){
			System.out.println("**************玩家："+player[1].getName()+"获胜！**************");
		}
		else{
			System.out.println("**************玩家平局！**************");
		}
		
		System.out.println("**********玩家的手牌为：");
		for(int i=0;i<2;i++){
			System.out.println(player[i].getName()+":["+player[i].getCards().get(0)+","+player[i].getCards().get(1)+"]");
		}
	}

	private static int maxcard(String[] cardsCom) {
		Map<String,Integer> cardCompare= new HashMap<>();
		cardCompare.put("黑桃",4);
		cardCompare.put("红桃",3);
		cardCompare.put("梅花",2);
		cardCompare.put("方片",1);
		
		int winner;
		int a=0;
		int b=0;
		
		a=transfer(cardsCom[0]);
		b=transfer(cardsCom[1]);
		
		if(a>b)
			winner=1;
		else if(a<b)
			winner=-1;
		else{
			String card1=cardsCom[0].substring(0,2);
			String card2=cardsCom[1].substring(0,2);
			
			if(cardCompare.get(card1)>cardCompare.get(card2))
				winner=1;
			else if(cardCompare.get(card1)<cardCompare.get(card2))
				winner=-1;
			else 
				winner=0;
		}
		
		return winner;
	}

	private static int transfer(String str) {
		int a = 0;
		if(str.substring(2).equals("J"))
			a = 11;
		else if(str.substring(2).equals("Q"))
			a = 12;
		else if(str.substring(2).equals("K"))
			a = 13;
		else if(str.substring(2).equals("A"))
			a = 1;
		else
			a = Integer.parseInt(str.substring(2));
		return a;
		
	}

}
