package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {

	static int N, target, count;
	static int[] numArray;
	static int[] sequence;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		count = 0;
		numArray = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i <= N ; i++) {
			sequence = new int[i];
			makeSequence(i, 0, 0);
		}
		
		System.out.println(count);
	}
	
	public static void makeSequence(int r, int cnt, int start) {
		if(cnt == r) {
			int sum = 0;
			System.out.println(Arrays.toString(sequence));
			for(int num : sequence) {
				sum = sum + num;
			}
			if(sum == target) {
				count++;
			}
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			sequence[cnt] = numArray[i];
			makeSequence(r, cnt+1, i+1);
		}
	}

}
