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
		    System.out.println("!!!!!!!!! BLACKJACK !�?!!!!!\n");
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
		System.out.println(" �?��?��?��?��?ースト�?!!!!!");
		System.out.println("############COM�?��?�?��?��?�####code1");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') > 21) {
		System.out.print("COM�?�手 ");
		comHand(h);
		System.out.println("COM�?�カード�?��?�計= " + cal('c') + " �?ースト�?");
		cal('c');
		sleep(500);
		System.out.println("      ############�?��?��?��?��?�?��?��?�####code3");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') > cal('p') && cal('c') < 22) {
		System.out.print("COM�?�手 ");
		comHand(h);
		System.out.println("COM�?�カード�?��?�計= " + cal('c'));
		sleep(500);
		System.out.println("############COM�?��?�?��?��?�####code2");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    if (cal('c') == cal('p')) {
		System.out.print("COM�?�手 ");
		comHand(h);
		System.out.println("COM�?�カード�?��?�計= " + cal('c'));
		System.out.println("引�??分�?��?��?�（�?��?��?��?�負�?�）");
		System.out.println();
		sleep(500);
		initHands();
		hands();
		break;
	    }

	    System.out.print("COM�?�手 ");
	    comHand(h);
	    System.out.println("COM�?�カード�?��?�計= " + cal('c'));
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
	    // TODO 自動生�?�?�れ�?� catch ブロック
	    e.printStackTrace();
	} // ミリ秒Sleep�?�る

    }
}
//@