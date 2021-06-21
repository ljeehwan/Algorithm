package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

	static int N, max, min;
	static int[] numArray;
	static int[] operator;
	static Object[] formula;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numArray = new int[N];
		operator = new int[4];
		formula = new Object[(2*N) - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < 4 ; i++) {
			operator[i] = Integer.parseInt(st2.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		makeFormula(numArray[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	// 0 : + ; 1 : - ; 2 : * ; 3 : /
	public static void makeFormula(int num, int idx) {
		if (idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
 
				switch (i) {
 
				case 0:	makeFormula(num + numArray[idx], idx + 1);	break;
				case 1:	makeFormula(num - numArray[idx], idx + 1);	break;
				case 2:	makeFormula(num * numArray[idx], idx + 1);	break;
				case 3:	makeFormula(num / numArray[idx], idx + 1);	break;
 
				}

				operator[i]++;
			}
		}
	}
}






