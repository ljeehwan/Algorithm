package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	static int N, M;
	static int[][] map;
	static int[] visited;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new int[N+1][N+1];
		visited = new int[N+1];
		
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}
		
		bfs();
		
		System.out.println(count);
	}
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(1);
		visited[1] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i = 1 ; i <= N ; i++) {
				if(map[now][i] == 1 && visited[i] == 0) {
					visited[i] = 1;
					queue.offer(i);
					count++;
				}
			}
		}
	}

}
