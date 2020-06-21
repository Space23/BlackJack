package fr.josse.blackjack;

public class Cards {
    static int cards[]; // card by unique id
    static String cards_m[]; // cards_mark
    static String cards_s[]; // cards_status
    final int RANK = 13; // ãƒžãƒ¼ã‚¯ã?®ç¨®é¡žã?”ã?¨ã?®ã‚«ãƒ¼ãƒ‰ã?®æ•°
    int MAX = RANK * 4; // ã‚«ãƒ¼ãƒ‰ã?®æ•°

    // String[] mark = { "â™¥", "â™ ", "â™£", "â™¦" };

    // â™¥ã€€â™ ã€€â—†ã€€â™£ â?¤ã€€â™¦
    void cards() { // initiate cards!
		   // 1-53ã?®IDã?§ç®¡ç?†ã?•ã‚Œã?Ÿã‚«ãƒ¼ãƒ‰ã?«
		   // ãƒžãƒ¼ã‚¯ã‚’ä»˜ã?‘ã?¦ãƒˆãƒ©ãƒ³ãƒ—ã‚«ãƒ¼ãƒ‰ã?«ã?™ã‚‹

	cards = new int[MAX + 1]; // card 52 +1. 0ã?¯ã‚¸ãƒ§ãƒ¼ã‚«ãƒ¼ï¼ˆä½¿ã‚?ã?ªã?„ï¼‰
	for (int i = 0; i < cards.length; i++) {
	    cards[i] = i;
	}
    }

    void cards_m() {
	cards();
	// ãƒˆãƒ©ãƒ³ãƒ—ã‚«ãƒ¼ãƒ‰
	cards_m = new String[MAX + 1];
	String[] mark = { "â™¥", "â™ ", "â™£", "â™¦" };

	for (int i = 0; i < RANK * 4 + 1; i++) {
	    if (i < RANK + 1) {
		cards_m[i] = "â™¥" + cards[i];
	    } else if (i < RANK * 2) {
		cards_m[i] = "â™ " + (cards[i] - RANK);
	    } else if (i < RANK * 3) {
		cards_m[i] = "â™£" + (cards[i] - RANK * 2);
	    } else {
		cards_m[i] = "â™¦" + (cards[i] - RANK * 3);
	    }
	}

	for (int i = 1; i < 5; i++) {
	    cards_m[i * RANK - 2] = mark[i - 1] + "J";
	}
	for (int i = 1; i < 5; i++) {
	    cards_m[i * RANK - 1] = mark[i - 1] + "Q";
	}
	for (int i = 1; i < 5; i++) {
	    cards_m[i * RANK] = mark[i - 1] + "K";
	}
	cards_m[0] = ""; // Joker cards_m[0]
    }

    void show() { // show cards by ID
	int i = 0;
	for (int d : cards) {
	    if (i == 1 || i % RANK - 1 == 0)
		System.out.println();
	    System.out.print(d + " ");
	    i++;
	}
    }

    void show_m() { // show cards with symbol.
	cards_s = new String[cards.length];
	for (int i = 0; i < cards.length; i++) {
	    cards_s[i] = cards_m[i];
	}

	int i = 0;
	for (String d : cards_s) {
	    if (i == 1 || i % RANK - 1 == 0)
		System.out.println();
	    System.out.print(d + " ");
	    i++;
	}
    }

    void show_s() { // show cards with symbol and status
	cards_s = new String[cards.length];
	for (int i = 0; i < cards.length; i++) {
	    cards_s[i] = cards_m[i];
	}

	for (int i = 0; i < cards.length; i++) {
	    if (cards[i] == 99)
		cards_s[i] = "@@";
	}

	int i = 0;
	for (String d : cards_s) {
	    if (i == 1 || i % RANK - 1 == 0)
		System.out.println();
	    System.out.print(d + " ");
	    i++;
	}
    }

}
