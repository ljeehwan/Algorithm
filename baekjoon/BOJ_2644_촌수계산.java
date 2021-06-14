package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

	static int N,M, result;
	static int[][] map;
	static int[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		visited = new int[N+1];
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(st1.nextToken());
			int num2 = Integer.parseInt(st1.nextToken());
			
			map[num1][num2] = 1;
			map[num2][num1] = 1;
		}
		result = -1;
		dfs(first, second, 1);
		
		System.out.println(result);
	}

	public static void dfs(int current, int second, int count) {
		visited[current] = 1;

		if(map[current][second] == 1) {
			result = count;
			return;
		}
		for(int i = 1 ; i <= N ; i++) {
			if(map[current][i] == 1 && visited[i] != 1) {
				//visited[i] = 1;
				dfs(i, second, count+1);
				visited[i] = 0;
			}
		}
	}
	
}
