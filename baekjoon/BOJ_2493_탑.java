package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] top = new int[N];
		Stack<Integer> result = new Stack<>();
		
		for(int i = 0 ; i < N ; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		
		int index = N-1;
		
		while(index > 0) {
			for(int i = index-1 ; i >= 0 ; i--) {
				if(top[i] >= top[index]) {
					result.push(i+1);
					break;
				}
				else if(i == 0) {
					result.push(0);
				}
			}
			index = index - 1;
		}
		result.push(0);
		
		while(!result.isEmpty()) {
			System.out.print(result.pop() + " ");
		}
		
		
	}

}
