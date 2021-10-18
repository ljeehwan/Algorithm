package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 메모리 : 18008 KB	시간 : 3240 ms
 * 시간 너무 오래걸림.
 */
public class Baekjoon1987 {
	private static int R, C, max;
	private static char[][] map;
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, 1, 0, -1 };
	private static boolean [][]visited;
	private static ArrayList<Character> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		max = 0;
		list.add(map[0][0]);
		visited[0][0] = true;
		dfs(0,0,1);
		
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {
		int nx = 0;
		int ny = 0;

		boolean move = true;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			boolean flag = false;
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(visited[nx][ny] == true)
					continue;
				
				flag = check(map[nx][ny]);

				if (flag) {
					move = false;
					list.add(map[nx][ny]);
					visited[nx][ny] = true;
					dfs(nx, ny, cnt+1);
					list.remove(list.size()-1);
					visited[nx][ny] = false;
					
				} else {
					continue;
				}
			}
		}
		if(move) {
			if(max < cnt)
				max = cnt;
		}
	}
	public static boolean check(char c) {

		for (int i = 0; i < list.size(); i++) {
			if (c == list.get(i))
				return false;
		}

		return true;
	}
}