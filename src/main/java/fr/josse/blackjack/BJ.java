package fr.josse.blackjack;
//GPL

public class BJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0 or Enter.\tカードを一枚�?�?��?��?�よ�?��?");
		System.out.println("1.\t\t�?負�?");

		System.out.println();
		Deal d = new Deal();		//カードを�?る
		Play p = new Play();		//ゲーム開始
		
		d.shaffle();
//		d.initHands();
		d.hands();
		p.play();
	}
}
