package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047_동전0 {

	static int min;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		int[] coin = new int[N];
		for(int i = 0 ; i < N ; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		
		int cnt = 0;
		while(true) {
			for(int i = N-1 ; i >= 0 ; i--) {
				if(money >= coin[i]) {
					money = money - coin[i];
					cnt++;
					break;
				}
			}
			if(money == 0) {
				break;
			}
		}
//		for(int i = N-1 ; i >= 0 ; i--) {
//			if(money >= coin[i]) {
////				dfs(coin, N, money-coin[i], cnt+1);
//				money = money - coin[i];
//			}
//		}
//		if(cnt < min) {
//			min = cnt;
//			return;
//		}
		
//		dfs(coin, N, money, 0);
		
		System.out.println(cnt);
	}

//	public static void dfs(int[] coin, int N, int money, int cnt) {
//		for(int i = N-1 ; i >= 0 ; i--) {
//			if(money >= coin[i]) {
//				dfs(coin, N, money-coin[i], cnt+1);
//			}
//		}
//		if(cnt < min) {
//			min = cnt;
//			return;
//		}
//	}
}
