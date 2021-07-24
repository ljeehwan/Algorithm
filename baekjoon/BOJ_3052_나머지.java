package day0924;

import java.util.Scanner;

public class BOJ_3052_³ª¸ÓÁö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 10;
		int[] chk = new int[1000];
		int num = 0;
		for(int i = 0 ; i < N ; i++) {
			num = sc.nextInt();
			
			chk[num%42]++;
		}
		int cnt = 0;
		for(int i = 0 ; i < 1000 ; i++) {
			if(chk[i] != 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
