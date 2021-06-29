package com.ssafy.ws;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2206_벽부수고이동하기 {
	
	static boolean[][][] v; // 벽이 부서진 상태일때, 아닐 때 따로 확인
	
	static int[][] arr;
	//static int[] dx = { 0, 0, -1, 1 }; // 상하좌우
	//static int[] dy = { -1, 1, 0, 0 };
	private static int []dx = {-1, 0, 1, 0};
	private static int []dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 세로
		int m = sc.nextInt(); // 가로
		
		arr = new   int[n][m];
		v = new boolean[n][m]  [2];

		for (int i = 0; i < n; i++) {
			char[] temp = sc.next().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				arr[i][j] = temp[j] - '0';
			}
		}
		bfs(n, m);
		sc.close();
	}//end main

	public static void bfs(int n, int m) {
		Queue<Data> q = new LinkedList<>();

		q.offer(new Data(0, 0, 1, 0));
		v[0][0][0] = true;
		v[0][0][1] = true;

		while (!q.isEmpty()) {
			Data p = q.poll();
			if (p.x == m - 1 && p.y == n - 1) {//배열의 범위를 벗어났을때 ==> 도착점에 도달하였을때
				System.out.println(p.cnt);
				return;
			}

			// 상하좌우 확인
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				// 범위 내에 있을때
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					// 벽일 경우
					if (arr[ny][nx] == 1) {
						// 벽을 부수지 않은 상태일 경우 부순 후 방문
						if (p.wall == 0 && !v[ny][nx][1]) {
							q.offer(new Data(nx, ny, p.cnt + 1, 1));
							v[ny][nx][1] = true;
						}
					} else {
						// 벽을 부수고 온 경우일 경우는 제외
						if (!v[ny][nx][p.wall]) {
							q.offer(new Data(nx, ny, p.cnt + 1, p.wall));
							v[ny][nx][p.wall] = true;
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

	public static class Data {
		int x; // 위치
		int y;
		int cnt; // 이동 횟수
		int wall; // 벽 부순 여부  : 0

		Data(int x, int y, int count, int wall) {
			this.x = x;
			this.y = y;
			this.cnt = count;
			this.wall = wall;
		}
	}
}
