package day0919;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int []arr = new int[num];
		for(int i = 0 ; i < num ; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < num ; i++) {
			list.add(arr[i], i+1);
		}
		
		for(int i = num-1 ; i>=0 ; i--) {
			System.out.print(list.get(i) + " ");
		}
	}
}
