package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1026_보물 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] aTemp = (br.readLine()).split(" ");
		String[] bTemp = (br.readLine()).split(" ");
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			A[i] = Integer.parseInt(aTemp[i]);
			B[i] = Integer.parseInt(bTemp[i]);
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int answer = 0;
		int idx = N-1;
		for(int i = 0 ; i < N ; i++) {
			answer = answer + (A[i] * B[idx]);
			idx--;
		}
		
		System.out.println(answer);
	}

}
