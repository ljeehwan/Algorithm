package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int M, N;
	static int[][] map;
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static Queue<Locate2> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
				if(map[i][j] == 1) {
					queue.offer(new Locate2(i,j,0));
				}
			}
		}
		
		int result = bfs();
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == 0) {
					result = -1;
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}
	public static int bfs() {
		int count = 0;
		
		while(!queue.isEmpty()) {
			Locate2 lc = queue.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = lc.r + dir[i][0];
				int nc = lc.c + dir[i][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
					queue.offer(new Locate2(nr,nc,lc.day+1));
					map[nr][nc] = 1;
				}
			}
			
			count = lc.day;
		}
		
		return count;
	}

}
class Locate2{
	int r;
	int c;
	int day;
	public Locate2(int r, int c, int day) {
		this.r = r;
		this.c = c;
		this.day = day;
	}
}