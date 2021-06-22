package day0924;

import java.util.Scanner;

public class BOJ_10163_»öÁ¾ÀÌ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] num = new int[N][4];
		int[][] map = new int[101][101];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < 4 ; j++) {
				num[i][j] = sc.nextInt();
			}
		}
		// 1,4 -> 1,1
		int cnt = 0;
		int tmp = 1;
		int[] ans = new int[N+1];
		for(int i = 0 ; i < N ; i++) {
			int r = 101 - num[i][1] - 1;
			int c = num[i][0];

			for(int j = r ; j > r - num[i][3] ; j--) {
				for(int k = c ; k < c + num[i][2] ; k++) {
					map[j][k] = tmp;
				}
			}
			tmp++;
		}
		for(int i = 0 ; i < 101 ; i++) {
			for(int j = 0 ; j < 101 ; j++) {
				if(map[i][j] != 0) {
					ans[map[i][j]]++;
				}
			}
		}
		
		
		
		for(int i = 1 ; i < ans.length ; i++) {
			System.out.println(ans[i]);
		}
	}

}
