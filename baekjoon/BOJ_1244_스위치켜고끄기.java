package day0924;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] swit = new int[num+1];
		for(int i = 1 ; i <= num ; i++) {
			swit[i] = sc.nextInt();
		}
		
		int student = sc.nextInt();
		int s = 0;
		int n = 0;
		for(int i = 0 ; i < student ; i++) {
			s = sc.nextInt();
			n = sc.nextInt();
			
			if(s == 1) {
				int k = 1;
				while(n*k <= num) {
					if(swit[n*k] == 0)
						swit[n*k] = 1;
					else if(swit[n*k] == 1)
						swit[n*k] = 0;
					k++;
				}
			}
			if(s == 2) {
				int k = 1;

				while(n-k > 0 && n+k <= num && swit[n-k] == swit[n+k]) {
					if(swit[n-k] == 0 )
						swit[n-k] = 1;
					else if(swit[n-k] == 1)
						swit[n-k] = 0;
					
					if(swit[n+k] == 0 )
						swit[n+k] = 1;
					else if(swit[n+k] == 1)
						swit[n+k] = 0;
					
					k++;
				}
				if(swit[n] == 0 )
					swit[n] = 1;
				else if(swit[n] == 1)
					swit[n] = 0;
			}
		}
		
		for(int i = 1 ; i <= num ; i++) {
			System.out.print(swit[i]);
			
			if(i != num) {
				System.out.print(" ");
			}
			if(i%20 == 0) {
				System.out.println();
			}
		}
	}

}
