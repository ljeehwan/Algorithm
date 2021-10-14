package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1824_D4 {
	static int T, R, C;
	static char [][]map;
	static String s;
	static int []dx = {-1, 0, 1, 0};
	static int []dy = {0, 1, 0, -1};
	static int memory;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			
			boolean check = true;
			
			for(int i = 0 ; i < R ; i++) {
				s = br.readLine();
				for(int j = 0 ; j < C ; j++) {
					map[i][j] = s.charAt(j);
					if(s.charAt(j) == '@')
						check = false;
				}
			}
			
			if(check) {
				System.out.printf("#%d NO\n", tc);
				continue;
			}
			
			memory = 0;
			move(0,0);
			if(flag)
				System.out.printf("#%d YES\n", tc);
			else
				System.out.printf("#%d NO\n", tc);
		}

	}
	
	public static void move(int r, int c) {
		char ch = map[r][c];
		
		if(ch - '0' >= 0 && ch - '0' < 10)
			memory = ch - '0';
		
		switch(ch) {
		case '@':
			return;
		case '<':
		case '>':
		case '^':
		case 'v':
		case '_':
		case '|':
		case '?':
		case '.':
		case '+':
		case '-':
			
		}
	}

}
