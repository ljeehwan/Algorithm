package day0923;

import java.util.Scanner;

public class BOJ_10158_개미 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt(); //가로 (열)
		int h = sc.nextInt(); //세로 (행)
		
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		int t = sc.nextInt();

		int []dx = {-1, -1, 1, 1}; // 우상 좌상 좌하 우하
		int []dy = {1, -1, -1, 1};
		int dir = 0;
		int cnt = 0;
		
		int x = h-q;
		int y = p;
		
		int nx = 0;
		int ny = 0;
		
		while(cnt != t) {
			
			if(x == h || y == w || x == 0 || y == 0) {
				switch(dir) {
				case 0: // 우상
					if(x == 0 && y == w)
						dir = 2;
					else if(x == 0)
						dir = 3;
					else if(y == w)
						dir = 1;
					break;
				case 1: // 좌상
					if(x == 0 && y == 0)
						dir = 3;
					else if(x == 0)
						dir = 2;
					else if(y == 0)
						dir = 1;
					break;
				case 2: // 좌하
					if(x == h && y == 0)
						dir = 0;
					else if(x == h)
						dir = 1;
					else if(y == 0)
						dir = 3;
					break;
				case 3: // 우하
					if(x == h && y == w)
						dir = 1;
					else if(x == h)
						dir = 0;
					else if(y == w)
						dir = 2;
					break;
				}
			}
			nx = x + dx[dir];
			ny = y + dy[dir];
			
			if(nx <= h && nx >= 0 && ny <= w && ny >= 0) {
				x = nx;
				y = ny;
				cnt++;
			}
		}
		
		System.out.println(y + " " + (h-x));
	}

}
