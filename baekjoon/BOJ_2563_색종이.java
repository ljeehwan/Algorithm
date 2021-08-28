package day0923;

import java.util.Scanner;

public class BOJ_2563_»öÁ¾ÀÌ {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = 0;
		int y = 0;
		
		int[][] map = new int[100][100];
		int cnt = 0;
		for(int i = 0 ; i < n ; i ++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int j = x ; j < x+10 ; j++) {
				for(int k = y ; k < y+10 ; k++) {
					if(map[j][k] != 1) {
						map[j][k] = 1;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);

	}

}
