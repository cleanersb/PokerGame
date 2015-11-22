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
		System.out.println("**********��ʼ�����˿���**********");
		System.out.println("**********�˿��ƴ����ɹ�**********");
		System.out.println(Arrays.toString(card.getNewCards()));  //����ȫ����ʾ������
		System.out.println("**********��ʼϴ��**********");
		String[] cardsRandom = card.RandomCard();
		System.out.println(Arrays.toString(cardsRandom));  //��ʾϴ�ƽ����
		System.out.println("**********ϴ�ƽ���**********");
		System.out.println("***********�������**********");
		
		for(int i=0;i<player.length;i++){
			System.out.println("�������" + (i+1) + "��ҵ�ID������");
			System.out.println("������ID��");
			int id1=in.nextInt();
			System.out.println("������������");
			String name1=in.next();
			Player player1=new Player(id1,name1);
			player[i]=player1;
		}
		
		/**
		 *��ʾ��Ϸ��ҵ�����
		 */
		for(int i=0;i<player.length;i++){
			System.out.println("***��ӭ��ң�"+player[i].getName());
		}
		
		System.out.println("***********��ʼ����**********");
		for(int i=0;i<4;i++){
			System.out.println("���"+player[i%2].getName()+"-����");
			Random random= new Random();
			int index=random.nextInt(cardsRandom.length);
			player[i%2].setCards(cardsRandom[index]);
		}
		
		System.out.println("***********���ƽ���**********");
		System.out.println("***********��ʼ��Ϸ**********");
		String[] cardsCom = new String[2];
		for(int i=0;i<2;i++){
			cardsCom[i]=player[i].getMaxCard();
			System.out.println("��ң�"+player[i].getName()+"�������Ϊ"+player[i].getMaxCard());
		}
		
		int result=maxcard(cardsCom);
		
		if(result==1){
			System.out.println("**************��ң�"+player[0].getName()+"��ʤ��**************");
		}
		else if(result==-1){
			System.out.println("**************��ң�"+player[1].getName()+"��ʤ��**************");
		}
		else{
			System.out.println("**************���ƽ�֣�**************");
		}
		
		System.out.println("**********��ҵ�����Ϊ��");
		for(int i=0;i<2;i++){
			System.out.println(player[i].getName()+":["+player[i].getCards().get(0)+","+player[i].getCards().get(1)+"]");
		}
	}

	private static int maxcard(String[] cardsCom) {
		Map<String,Integer> cardCompare= new HashMap<>();
		cardCompare.put("����",4);
		cardCompare.put("����",3);
		cardCompare.put("÷��",2);
		cardCompare.put("��Ƭ",1);
		
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
