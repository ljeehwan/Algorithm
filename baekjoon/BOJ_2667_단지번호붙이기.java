package day1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
	static int N, cnt;
	static int [][]map;
	static int []dx = {-1,0,1,0};
	static int []dy = {0,1,0,-1};
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		cnt = 1;
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == 1) {
					cnt++;
					list.add(numbering(i,j));
				}
			}
		}
		System.out.println(cnt-1);
		Collections.sort(list);
		for(int a : list) {
			System.out.println(a);
		}
	}
	public static int numbering(int x, int y) {
		Queue<Locate> q = new LinkedList<>();
		q.offer(new Locate(x,y));
		map[x][y] = cnt;
		int nx = 0;
		int ny = 0;
		int count = 1;
		while(!q.isEmpty()) {
			Locate lc = q.poll();
			for(int i = 0 ; i < 4 ; i++) {
				nx = lc.x + dx[i];
				ny = lc.y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(map[nx][ny] == 1) {
						map[nx][ny] = cnt;
						count++;
						q.offer(new Locate(nx, ny));
					}
				}
			}
		}
		return count;
	}
	
}
class Locate{
	int x;
	int y;
	public Locate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}