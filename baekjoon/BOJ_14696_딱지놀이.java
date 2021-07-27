package day0924;

import java.util.Scanner;

public class BOJ_14696_µüÁö³îÀÌ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[] ans = new char[N];
		
		for(int i = 0 ; i < N ; i++) {
			
			int first_num = sc.nextInt();
			int[] f_cnt = new int[5];
			
			for(int j = 0 ; j < first_num ; j++) {
				f_cnt[sc.nextInt()]++;
			}
			
			int second_num = sc.nextInt();
			int[] s_cnt = new int[5];
			for(int j = 0 ; j < second_num ; j++) {
				s_cnt[sc.nextInt()]++;
			}
			
			ans[i] = 'D';
			for(int j = 4 ; j > 0 ; j--) {
				if(f_cnt[j] > s_cnt[j]) {
					ans[i] = 'A';
					break;
				}
				else if(f_cnt[j] < s_cnt[j]) {
					ans[i] = 'B';
					break;
				}	
			}
		}
		
		for(char a : ans) {
			System.out.println(a);
		}

	}

}
