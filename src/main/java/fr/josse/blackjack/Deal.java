package fr.josse.blackjack;

public class Deal extends Cards {
static 	 int h=7;				//手札�?�数�?�最大
static 	 int[] player = new int[h];		//player�?�手札�?��?列
static 	 int[] com = new int[h];		//Computer�?�手札�?��?列
static 	 int P = 0;				// player's array number
static 	 int C = 0;
 	 char x;				//player�?�computer�?�を区別�?�る�?��?�?�引数

	void flip(char x) {			//カードを一枚�?�??る
						//引数c�?�らComputer�?p�?�らPlayer
		if (MAX < h*2)
			shaffle();
		for (int i = 0; i < 1; i++) {
			int n = (int) (Math.random() * 52) + 1;
			if (cards[n] != 99) {		//�?�る�?��?��?��?�99を代入�?��?��?�る
				if (x == 'p') {
					player[P] = n;
					P++;
				}
				if (x == 'c') {
					com[C] = n;
					C++;
				}
				cards[n] = 99;	//�?�る�?��?��?��?�99を代入
				MAX--;
			} else
				i--;
		}
	}

	void hands() {				// 最�?�?�カードを�?る
		flip('c');
		flip('p');
		flip('c');
		info();
	}

	void shaffle() {			// カードセット�?� シャッフル
		System.out.println("カードをシャッフル�?��?��?�");
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

	void initHands() {			// 手札�?��?期化
		for (int i = 0; i < player.length; i++) {
			player[i] = 0;
			com[i] = 0;
			P = 0;
			C = 0;
		}
	}

	int cal(char i) {			//手札�?�計算
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

	void info() { // �?�種情報�?�表示。 デ�?ックを兼�?�る
	// comment the lines out which you like to know about.
//	 show();
//	 show_s();
//	 System.out.println();
//	 System.out.println("残りカード= " + MAX);
//	 System.out.println();

		System.out.print("PC�?�手 ");
		comHand(1); // 親�?�一枚目�?�カード�?��?�見�?�る
		System.out.print("�?��?��?��?�手 ");
		yourHand(); //�?�?�手札�?�因数�?��?��?�

		System.out.println("�?��?��?��?�カード�?��?�計= " + cal('p')); // you
	}

}
