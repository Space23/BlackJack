package fr.josse.blackjack;

public class Deal extends Cards {
static 	 int h=7;				//æ‰‹æœ­ã?®æ•°ã?®æœ€å¤§
static 	 int[] player = new int[h];		//playerã?®æ‰‹æœ­ã?®é…?åˆ—
static 	 int[] com = new int[h];		//Computerã?®æ‰‹æœ­ã?®é…?åˆ—
static 	 int P = 0;				// player's array number
static 	 int C = 0;
 	 char x;				//playerã?‹computerã?‹ã‚’åŒºåˆ¥ã?™ã‚‹ã?Ÿã‚?ã?®å¼•æ•°

	void flip(char x) {			//ã‚«ãƒ¼ãƒ‰ã‚’ä¸€æžšã‚?ã??ã‚‹
						//å¼•æ•°cã?ªã‚‰Computerã€?pã?ªã‚‰Player
		if (MAX < h*2)
			shaffle();
		for (int i = 0; i < 1; i++) {
			int n = (int) (Math.random() * 52) + 1;
			if (cards[n] != 99) {		//ã?—ã‚‹ã?—ã?¨ã?—ã?¦99ã‚’ä»£å…¥ã?—ã?¦ã?‚ã‚‹
				if (x == 'p') {
					player[P] = n;
					P++;
				}
				if (x == 'c') {
					com[C] = n;
					C++;
				}
				cards[n] = 99;	//ã?—ã‚‹ã?—ã?¨ã?—ã?¦99ã‚’ä»£å…¥
				MAX--;
			} else
				i--;
		}
	}

	void hands() {				// æœ€åˆ?ã?«ã‚«ãƒ¼ãƒ‰ã‚’é…?ã‚‹
		flip('c');
		flip('p');
		flip('c');
		info();
	}

	void shaffle() {			// ã‚«ãƒ¼ãƒ‰ã‚»ãƒƒãƒˆã?® ã‚·ãƒ£ãƒƒãƒ•ãƒ«
		System.out.println("ã‚«ãƒ¼ãƒ‰ã‚’ã‚·ãƒ£ãƒƒãƒ•ãƒ«ã?—ã?¾ã?™");
		MAX = 52;
		cards_m();
	}

	void yourHand() {
		for (int b = 0; b < player.length; b++) {
			if (player[b] != 0)
				System.out.print(cards_m[player[b]] + " ");
		}
		System.out.println();
	}
	void comHand() {
		for (int b = 0; b < com.length; b++) {
			if (com[b] != 0)
				System.out.print(cards_m[com[b]] + " ");
		}
		System.out.println();
	}

	void comHand(int i) {
		for (int b = 0; b < i; b++) {
			if (com[b] != 0)
				System.out.print(cards_m[com[b]] + " ");
		}
		System.out.println();
	}

	void initHands() {			// æ‰‹æœ­ã?®åˆ?æœŸåŒ–
		for (int i = 0; i < player.length; i++) {
			player[i] = 0;
			com[i] = 0;
			P = 0;
			C = 0;
		}
	}

	int cal(char i) {			//æ‰‹æœ­ã?®è¨ˆç®—
		int[] n = player;
		if (i == 'c')			//'c' for computer
			n = com;
		if (i == 'p')			//'p' for player
			n = player;

		int p = 0;
		for (int d : n) {
			if (d == 0)
				p += 0;
			if (d >= 1 && d <= 9)
				p += d;
			if (d >= 10 && d <= 13)
				p += 10;
			if (d >= 14 && d <= 22)
				p += d - RANK;
			if (d >= 23 && d <= 26)
				p += 10;
			if (d >= 27 && d <= 35)
				p += d - RANK * 2;
			if (d >= 36 && d <= 39)
				p += 10;
			if (d >= 40 && d <= 48)
				p += d - RANK * 3;
			if (d >= 49 && d <= 52)
				p += 10;
		}
		return p;
	}

	void info() { // å?„ç¨®æƒ…å ±ã?®è¡¨ç¤ºã€‚ ãƒ‡ãƒ?ãƒƒã‚¯ã‚’å…¼ã?­ã‚‹
	// comment the lines out which you like to know about.
//	 show();
//	 show_s();
//	 System.out.println();
//	 System.out.println("æ®‹ã‚Šã‚«ãƒ¼ãƒ‰= " + MAX);
//	 System.out.println();

		System.out.print("PCã?®æ‰‹ ");
		comHand(1); // è¦ªã?¯ä¸€æžšç›®ã?®ã‚«ãƒ¼ãƒ‰ã? ã?‘è¦‹ã?›ã‚‹
		System.out.print("ã?‚ã?ªã?Ÿã?®æ‰‹ ");
		yourHand(); //å­?ã?®æ‰‹æœ­ã?«å› æ•°ã?¯ã?ªã?„

		System.out.println("ã?‚ã?ªã?Ÿã?®ã‚«ãƒ¼ãƒ‰ã?®å?ˆè¨ˆ= " + cal('p')); // you
	}

}
