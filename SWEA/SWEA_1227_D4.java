package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1227_D4 {
	static int N = 100;
	static char [][]map = new char[N][N];
	static int []dx = {-1, 0, 1, 0};
	static int []dy = {0, 1, 0, -1};
	static int tc, possible = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int t = 1 ; t <= 10 ; t++) {
			tc = Integer.parseInt(br.readLine());
			for(int i = 0 ; i < N ; i++) {
				String s = br.readLine();
				
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			possible = 0;
			for(int i = 99 ; i >= 0 ; i--) {
				for(int j = 99 ; j >= 0 ; j--) {
					if(map[i][j] == '3')
						move(i, j);
				}
			}

			System.out.printf("#%d %d\n", tc, possible);
			
		}

	}

	public static void move(int x, int y) {
		
		
		int nx = 0;
		int ny = 0;
		for(int i = 0 ; i < 4 ; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '2') {
				possible = 1;
				return;
			}
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '0') {
				map[nx][ny] = '9';
				move(nx, ny);
				map[nx][ny] = '0';
			}
		}
	}
}
