package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] temp = (br.readLine()).split(" ");
		int[] array = new int[N];
		for(int i = 0 ; i < N ; i++) {
			array[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(array);

		int result = 0;
		int sum = 0;
		for(int i = 0 ; i < N ; i++) {
			
			result = result + sum + array[i];
			sum = sum + array[i];
		}
	
		System.out.println(result);
	}

}
