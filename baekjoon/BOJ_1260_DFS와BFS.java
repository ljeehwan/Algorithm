package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {

	static int N, M;
	static int[][] map;
	static List<Integer> dfsList = new ArrayList<>();
	static List<Integer> bfsList = new ArrayList<>();
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new int[N+1];
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st1.nextToken());
			int c = Integer.parseInt(st1.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}

		dfs(V);
		visited = new int[N+1];
		bfs(V);
		
		for(int result : dfsList) {
			System.out.print(result + " ");
		}
		System.out.println("");
		for(int result : bfsList) {
			System.out.print(result + " ");
		}
	}
	public static void dfs(int now) {
		dfsList.add(now);
		visited[now] = 1;
		for(int i = 0 ; i <= N ; i++) {
			if(map[now][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				dfs(i);
			}
		}
	}
	public static void bfs(int now) {
		bfsList.add(now);
		visited[now] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(now);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0 ; i <= N ; i++) {
				if(map[cur][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					queue.offer(i);
					bfsList.add(i);
				}
			}
		}
	}

}
