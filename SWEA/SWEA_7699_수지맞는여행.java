import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지맞는여행 {

	static int R, C; //섬의 크기 R 행 C 열
	static char [][]map;
	static int [][]dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static boolean []visit;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			visit = new boolean[26];
			
			for(int i = 0 ; i < R ; i++) {
				String s = br.readLine();
				for(int j = 0 ; j < C ; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			max = 0;
			visit[map[0][0] - 'A'] = true;
			dfs(0,0,1);
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void dfs(int current_r, int current_c, int count) {
	int nr = 0;
		int nc = 0;
		for(int i = 0 ; i < 4 ; i++) {
			nr = current_r + dir[i][0];
			nc = current_c + dir[i][1];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(visit[map[nr][nc] - 'A'] == false) {
					visit[map[nr][nc] - 'A'] = true;
					dfs(nr, nc, count+1);
					visit[map[nr][nc] - 'A'] = false;
				}
			}
		}
		
		if(count > max) {
			max = count;
		}
	}

}