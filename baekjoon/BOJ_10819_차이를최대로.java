package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

	static int N, max;
	static int[] numArray;
	static int[] makeArray;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numArray = new int[N];
		makeArray = new int[N];
		isSelected = new boolean[N];
		max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		
		makeComb(0);
		
		System.out.println(max);
	}

	public static void makeComb(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 1 ; i < N ; i++) {
				sum = sum + Math.abs(makeArray[i-1] - makeArray[i]);
			}
			if(sum > max) {
				max = sum;
			}
			return;
		}
		for(int i = 0 ; i < N ; i++) {
			if(isSelected[i]) continue;
			
			makeArray[cnt] = numArray[i];
			isSelected[i] = true;
			
			makeComb(cnt+1);
			
			isSelected[i] = false;
		}
	}
}
