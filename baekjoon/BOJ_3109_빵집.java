package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon3109 {
	private static int R,C;
	private static char [][]map;
	private static int []dx = {-1, 0, 1};
	private static int []dy = {1,1,1};
	private static boolean check;
	private static int line_cnt;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0 ; i < R ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < C ; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		line_cnt = 0;
		
		for(int i = 0 ; i < R ; i++) {
			check = false;
			line(i, 0);
		}
		System.out.println(line_cnt);
	}
	public static void line(int x, int y) {
		if(y == C-1) {
			check = true;
			line_cnt++;
			return;
		}
		int nx = 0;
		int ny = 0;
		for(int i = 0 ; i < 3 ; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(map[nx][ny] == 'x')
					continue;
				else {
					map[nx][ny] = 'x';
					line(nx, ny);
					if(check)
						return;
					//break;
				}
				
			}
		}

	}

}