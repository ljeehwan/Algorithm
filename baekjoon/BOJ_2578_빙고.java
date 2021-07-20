package day0923;

import java.util.Scanner;

public class BOJ_2578_ºù°í {
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = 5;
		map = new int[N][N];
		int[] number = new int[N*N];
		Rot[] chk = new Rot[N*N+1];
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
				chk[map[i][j]] = new Rot(i,j);
			}
		}

		for(int i = 0 ; i < N*N ; i++) {
			number[i] = sc.nextInt();
		}
		
		int cnt = 0;
		int check = 0;
		for(int num : number) {
			
			Rot rt = chk[num];
			map[rt.x][rt.y] = -1;
			cnt++;
			
			if(cnt >= 15) {
				check = chkBingo(rt.x, rt.y);
				if(check >= 3) {
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	public static int chkBingo(int x, int y) {
		int cnt = 0;
		int cnt2 = 0;
		int bingo = 0;
		for(int i = 0 ; i < N ; i++) {
			cnt = 0;
			cnt2 = 0;
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == -1) {
					cnt++;
				}
				if(map[j][i] == -1) {
					cnt2++;
				}
			}
			if(cnt == 5) {
				bingo++;
			}
			if(cnt2 == 5) {
				bingo++;
			}
		}
		
		cnt = 0 ;
		for(int i = 0 ; i < N ; i++) {
			if(map[i][i] == -1) {
				cnt++;
			}
		}
		if(cnt == 5) {
			bingo++;
		}
		
		cnt = 0;
		for(int i = 0 ; i < N ; i++) {
			if(map[i][N-1-i] == -1) {
				cnt++;
			}
		}
		if(cnt == 5) {
			bingo++;
		}
		return bingo;
	}
}
class Rot{
	int x;
	int y;
	public Rot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}