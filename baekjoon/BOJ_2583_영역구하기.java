package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {

	static int M,N,K;
	static int[][] map;
	//static int[][] visited;
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		//visited = new int[M][N];
		
		for(int i = 0 ; i < K ; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st1.nextToken());
			int c1 = Integer.parseInt(st1.nextToken());
			
			int r2 = Integer.parseInt(st1.nextToken());
			int c2 = Integer.parseInt(st1.nextToken());
			//1 1 2 5
			//0 1 4 2
			int newR1 = M-c1-(c2-c1);
			int newC1 = r1;
			
			int newR2 = M-c1;
			int newC2 = r2;
			for(int j = newR1 ; j < newR2 ; j++) {
				for(int k = newC1 ; k < newC2 ; k++) {
					map[j][k] = 2;
				}
			}
			
			
		}
		
		List<Integer> area = new ArrayList<>();
		int areaCount = 0;
		for(int i = 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 0) {
					areaCount++;
					area.add(bfs(i,j));
				}
			}
		}
		System.out.println(areaCount);
		Collections.sort(area);
		for(int result : area) {
			System.out.print(result + " ");
		}
		
	}
	public static int bfs(int r, int c) {
		Queue<Locate> queue = new LinkedList<>();
		queue.offer(new Locate(r,c));
		//visited[r][c] = 1;
		map[r][c] = 1;
		int count = 1;
		while(!queue.isEmpty()) {
			
			Locate lc = queue.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int nr = lc.r + dir[i][0];
				int nc = lc.c + dir[i][1];
				
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 0 /*&& visited[nr][nc] == 0*/) {
					queue.offer(new Locate(nr, nc));
					map[nr][nc] = 1;
					//visited[nr][nc] = 1;
					count++;
				}
			}
		}
		return count;
	}

}
class Locate{
	int r;
	int c;
	public Locate(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}