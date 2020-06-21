package fr.josse.blackjack;
//GPL

public class BJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("0 or Enter.\tã‚«ãƒ¼ãƒ‰ã‚’ä¸€æžšã‚?ã?£ã?¦ã?¿ã‚ˆã?†ï¼?");
		System.out.println("1.\t\tå‹?è² ï¼?");

		System.out.println();
		Deal d = new Deal();		//ã‚«ãƒ¼ãƒ‰ã‚’é…?ã‚‹
		Play p = new Play();		//ã‚²ãƒ¼ãƒ é–‹å§‹
		
		d.shaffle();
//		d.initHands();
		d.hands();
		p.play();
	}
}
