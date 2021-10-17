package com.ssafy.ws;

/**
입력
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1

출력
12
 */


import java.util.Scanner;

public class BOJ_17406_배열돌리기4 {
	
	static class Data {//회전연산의 정보
		int r;
		int c;
		int s;

		public Data(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Data [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}
	private static int N;//행
	private static int M;//열
	private static int K;//회전연산의 개수
		
	private static int[][] map;//초기데이터 저장
	private static int[][] mapClone;//초기 맵 복사
	
	private static Data[] arr;// 회전정보 : 초기 위치(행, 열, 크기)
	private static Data[] tempArr;
	private static boolean[] v; //순열에 사용
	private static int min;//회전후 최소값
	private static int result;//최종 값

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		//입력된 데이터와 배열인덱스 맞추어주기
		map = new int[N + 1][M + 1];
		mapClone = new int[N + 1][M + 1];
		
		arr = new Data[K];
		tempArr = new Data[K];
		
		v = new boolean[K];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			arr[i] = new Data(r, c, s);
		}

		// 순열 구하기
		result = Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);
        sc.close();
	} // end of main

	/**
	 * 회전 연산에 대한 순열 구하기
	   2회 회전: [3 4 2] [4 2 1]
	   2회 회전: [4 2 1] [3 4 2]	
	   
	 */
	private static void perm(int len) {
		if (len == K) {
			
            //회전 발생하면 값이 변경되므로 mapClone에 원본값 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					mapClone[i][j] = map[i][j];
				}
			}			
			
			// 순열이 준비되었다면 해당 순열의 회전 연산 처리하기
			solve(); 

			result = Math.min(result, min);
			// 배열돌리고 최솟값 구하는 곳 구현
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				tempArr[len] = arr[i];
				perm(len + 1);
				v[i] = false;
			}
		}
	}

	private static void solve() {
		// tempArr사용
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < tempArr.length; i++) {
			arrRotate(tempArr[i]);
		}

		// 배열을 다 돌린 후의 각 행의 최소값 찾
		int sum = 0;
		for (int j = 1; j <= N; j++) {
			sum = 0;
			for (int k = 1; k <= M; k++) {
				sum += mapClone[j][k];
			}
			min = Math.min(sum, min);
		}
	}

	
	private static void arrRotate(Data d) {
		int R = d.r;
		int C = d.c;
		int S = d.s;
		
		for (int s = 1; s <= S; s++) {
			
			int prevV = -1;
			int initR = -1, initC = -1;  // 맨 처음 데이터를 기억하고 나중에 회전이 끝났을때 처음 위치의 데이터를 변경

/*
입력데이터
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1	


(3-2, 4-2)   (3+2,4+2)  ==> (1,2) 부터 (5,6) 까지 시계방향 회전
(4-1, 2-1)   (4+1,2+1)  ==> (3,1) 부터 (5,3) 까지 시계방향 회전		
 */
			// (r-s, c-s) -> (r-s, c+s)    3-2,4-2    3-2,3+2   (1,2)~(1,5)
			//상단 >
			for (int r = R - s, c = C - s; c <= C + s; c++) {
				if (prevV == -1) {
					initR = r;
					initC = c;
					prevV = mapClone[r][c];
				} else {
					int temp = prevV;
					prevV = mapClone[r][c];
					mapClone[r][c] = temp;
				}
			}

			// (r-s+1, c+s) -> (r+s, c+s)    3-2+1,4+2     3+2,4+2   (2,6)~(5,6)
			// 오른쪽V
			for (int r = R - s + 1; r <= R + s; r++) {
				int temp = prevV;
				prevV = mapClone[r][C + s];
				mapClone[r][C + s] = temp;
			}
			
			
			// (r+s, c+s-1) -> (r+s, c-s)     3+2,4+2-1     3+2,4-2   (5,5)~(5,2)
			// 하단<
			for (int c = C + s - 1; c >= C - s; c--) {
				int temp = prevV;
				prevV = mapClone[R + s][c];
				mapClone[R + s][c] = temp;
			}
			
			
			// (r+s-1, c-s) -> (r-s+1, c-s)   3+2-1,4-2     3-2+1,4-2  (4,2)~(2,2)
			// 왼쪽^
			for (int r = R + s - 1; r >= R - s + 1; r--) {
				int temp = prevV;
				prevV = mapClone[r][C - s];
				mapClone[r][C - s] = temp;
			}
			
			
			mapClone[initR][initC] = prevV;
		}
	}
}