package day0923;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2491_¼ö¿­ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N];
		for(int i = 0 ; i < N ; i++) {
			num[i] = sc.nextInt();
		}
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			if(num[i] <= num[i+1]) {
				cnt++;
			}
			else {
				list.add(cnt);
				cnt = 0;
			}
		}
		list.add(cnt);
		cnt = 0;
		for(int i = 0 ; i < N-1 ; i++) {
			if(num[i] >= num[i+1]) {
				cnt++;
			}
			else {
				list.add(cnt);
				cnt = 0;
			}
		}
		list.add(cnt);
		System.out.println(Collections.max(list)+1);
	}
}
