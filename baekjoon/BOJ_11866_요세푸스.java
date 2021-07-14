package com.ssafy.보충;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866_요세푸스 {
	static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		System.out.println(getAnswer());
	}
	
	private static String getAnswer() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1 ; i <= N ; i++) {
			q.offer(i);
		}
		
		int cur, cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		while(!q.isEmpty()) {
			cur = q.poll();
			if(++cnt%K == 0) {
				sb.append(cur).append(", ");
			}
			else {
				q.offer(cur);
			}
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		return sb.toString();
	}
}
