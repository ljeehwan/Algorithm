package day0923;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_10157_직사각형 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		
		int[][]map = new int[R][C];
		
		int K = sc.nextInt();
		
		int []dx = {-1, 0, 1, 0};
		int []dy = {0, 1, 0, -1};
		int dir = 0;
		map[R-1][0] = 1;
		
		int x = R-1;
		int y = 0;
		
		int nx = 0;
		int ny = 0;
		
		int cnt = 2;
		
		while(cnt-1 != K && K <= R*C) {
			
			dir = dir%4;
			
			nx = x + dx[dir];
			ny = y + dy[dir];
			
			if(nx < R && nx >= 0 && ny < C && ny >= 0 && map[nx][ny] == 0) {
				map[nx][ny] = cnt;				
				cnt++;
				x = nx;
				y = ny;
				
			}
			else {
				dir++;
			}
		}
	
		
		if(cnt-1 == K) {
			System.out.print((y+1) + " " + (R-x));
		}
		else {
			System.out.println(0);
		}
	}
}
