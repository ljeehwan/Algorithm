package com.ssafy.보충;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_17608_막대기 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0 ; i < N ; i++) {
			stack.add(sc.nextInt());
		}
		
		int standard = stack.pop();
		int cnt = 1;
		int temp = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			temp = stack.pop();
			
			if(standard < temp) {
				standard = temp;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
