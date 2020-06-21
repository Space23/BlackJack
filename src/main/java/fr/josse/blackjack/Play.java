package fr.josse.blackjack;

import lib.Input;

public class Play extends Deal {

    void play() {
	while (true) {
	    switch (Input.getInt()) {
	    case 0:
		flip('p');
		info();

		if (cal('p') == 21) {
		    sleep(500);
		    System.out.println("!!!!!!!!! BLACKJACK !ï¼?!!!!!\n");
		    winlose();
		    break;
		}

		if (cal('p') > 21)
		    winlose();
		break;
	    case 1:
		winlose();
		break;

	    case 2:
		show();
		break;

	    case 3:
		show_m();
		break;

	    case 4:
		show_s();
		break;
	    }

	    System.out.println();
	}
    }

    void winlose() {
	while (true) {
	    if (cal('p') > 21) {
		sleep(500);
		System.out.println(" ã?‚ã?ªã?Ÿã?®ãƒ?ãƒ¼ã‚¹ãƒˆï¼?!!!!!");
		System.out.println("############COMã?®å‹?ã?¡ã?§ã?™####code1");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') > 21) {
		System.out.print("COMã?®æ‰‹ ");
		comHand(h);
		System.out.println("COMã?®ã‚«ãƒ¼ãƒ‰ã?®å?ˆè¨ˆ= " + cal('c') + " ãƒ?ãƒ¼ã‚¹ãƒˆï¼?");
		cal('c');
		sleep(500);
		System.out.println("      ############ã?‚ã?ªã?Ÿã?®å‹?ã?¡ã?§ã?™####code3");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') > cal('p') && cal('c') < 22) {
		System.out.print("COMã?®æ‰‹ ");
		comHand(h);
		System.out.println("COMã?®ã‚«ãƒ¼ãƒ‰ã?®å?ˆè¨ˆ= " + cal('c'));
		sleep(500);
		System.out.println("############COMã?®å‹?ã?¡ã?§ã?™####code2");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') == cal('p')) {
		System.out.print("COMã?®æ‰‹ ");
		comHand(h);
		System.out.println("COMã?®ã‚«ãƒ¼ãƒ‰ã?®å?ˆè¨ˆ= " + cal('c'));
		System.out.println("å¼•ã??åˆ†ã?‘ã?§ã?™ï¼ˆã?‚ã?ªã?Ÿã?®è² ã?‘ï¼‰");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    System.out.print("COMã?®æ‰‹ ");
	    comHand(h);
	    System.out.println("COMã?®ã‚«ãƒ¼ãƒ‰ã?®å?ˆè¨ˆ= " + cal('c'));
	    sleep(1000);

	    if (cal('c') < cal('p')) {
		flip('c');
	    }


	}
    }

    void sleep(int i) {

	try {
	    Thread.sleep(i);
	} catch (InterruptedException e) {
	    // TODO è‡ªå‹•ç”Ÿæˆ?ã?•ã‚Œã?Ÿ catch ãƒ–ãƒ­ãƒƒã‚¯
	    e.printStackTrace();
	} // ãƒŸãƒªç§’Sleepã?™ã‚‹

    }
}
//@