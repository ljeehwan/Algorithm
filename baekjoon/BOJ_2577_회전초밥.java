package com.ssafy.hw;

import java.util.Scanner;
public class BOJ_2577_회전초밥 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 
		int D = sc.nextInt(); 
		int K = sc.nextInt();
		int C = sc.nextInt(); 

		int[] arr = new int[N + K];
		int[] cnt = new int[D + 1]; 
		int count = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}		
		System.arraycopy(arr, 0, arr, N, K - 1);
		
		for (int i = 0; i < K; i++) {			
			if (cnt[arr[i]]++ == 0)
				count++;
		}

		for (int i = 1; i < N; i++) {
			if (cnt[arr[i + K - 1]]++ == 0)
				count++;

			if (--cnt[arr[i - 1]] < 1)
				count--;
			
			int temp = count;
			if (cnt[C] == 0)
				temp++;

			if (temp > max) {
				max = temp;
			}
		}

		System.out.println(max);
	}
}
