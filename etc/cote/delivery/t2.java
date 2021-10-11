import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] B = {".##.#", "#.#..", "#...#", "#.##."};
		System.out.println(Arrays.toString(solution(B)));
	}

	// Patrol Boats
	// size 1
	// 상하좌우 .
	
	// Submarines
	// size 2
	// 한 쪽 면만 #
	
	// Destroyers
	// size 3
	// 4방에 두 개 #
	static char[][] map;
	static int N,M;
	static int[][] dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	public static int[] solution(String[] B) {
        // write your code in Java SE 8
		int[] answer = new int[3];
		N = B.length;
		M = B[0].length();
		map = new char[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = B[i].charAt(j);
			}
		}
		
		int cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(map[i][j] == '#') {
					cnt = 0;
					cnt = bfs(i,j);
					if(cnt == 1) {
						answer[0]++;
					}
					else if(cnt == 2) {
						answer[1]++;
					}
					else if(cnt == 3) {
						answer[2]++;
					}
				}
			}
		}
		cnt = bfs(1,0);
		return answer;
    }
	
	public static int bfs(int r, int c) {
		int result = 1;
		
		map[r][c] = 'v';
		
		Queue<Locate> queue = new LinkedList<>();
		queue.offer(new Locate(r,c));
		
		while(!queue.isEmpty()) {
			Locate lc = queue.poll();
			int nr = 0;
			int nc = 0;
			
			for(int i = 0 ; i < 4 ; i++) {
				nr = lc.r + dir[i][0];
				nc = lc.c + dir[i][1];

				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != '#') {
					continue;
				}
				else {
					queue.offer(new Locate(nr, nc));
					map[nr][nc] = 'v';
					result++;
				}
//				if(nr >= 0 && nr < N && nc > 0 && nc < M && map[nr][nc] == '#') {
//					queue.offer(new Locate(nr, nc));
//					map[nr][nc] = 'v';
//					result++;
//				}
			}
		}
		
		return result;
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