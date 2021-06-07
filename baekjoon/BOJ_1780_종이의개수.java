package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

	static int N, minus, zero, plus;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		minus = 0;
		zero = 0;
		plus = 0;
		
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		division(0,0,N);

		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	
	//영역 : 좌상 상 우상 / 좌 중앙 우 / 좌하 하 우하
	public static void division(int r, int c, int size) {
		
		if(check(r,c,size)) {
			if(map[r][c] == -1) {
				minus = minus + 1;
			}
			else if(map[r][c] == 0) {
				zero = zero + 1;
			}
			else { // 1
				plus = plus + 1;
			}
			
			return;
		}
		
		int newSize = size/3;
		
		//좌상
		division(r, c, newSize);
		
		//상
		division(r, c + newSize, newSize);
		
		//우상
		division(r, c + (newSize*2), newSize);
		
		//좌
		division(r + newSize, c, newSize);
		
		//중앙
		division(r + newSize, c + newSize, newSize);
		
		//우
		division(r + newSize, c + (newSize*2), newSize);
		
		//좌하
		division(r + (newSize*2), c, newSize);
		
		//하
		division(r + (newSize*2), c + newSize, newSize);
		
		//우하
		division(r + (newSize*2), c + (newSize*2), newSize);
	}
	
	public static boolean check(int r, int c, int size) {
		int standard = map[r][c];
		
		for(int i = r ; i < r+size ; i++) {
			for(int j = c ; j < c+size ; j++) {
				if(standard != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
