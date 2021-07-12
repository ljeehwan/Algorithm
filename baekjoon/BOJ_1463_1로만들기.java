package com.ssafy.ws;

import java.util.Scanner;

public class BOJ_1463_1로만들기 {
	static int d[];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// x / 3 나머지없으면
		// x / 2 나머지 없으면
		// x - 1
		
		d = new int[N+1];
		
		d[0] = 0;
		d[1] = 0;
		
		for(int i = 2 ; i <= N ; i++) {
			d[i] = d[i-1] + 1;
			if(i%2 == 0)
				d[i] = Math.min(d[i], d[i/2] + 1);
			if(i%3 == 0)
				d[i] = Math.min(d[i], d[i/3] + 1);
		}
		
		System.out.println(d[N]);
	}
}
