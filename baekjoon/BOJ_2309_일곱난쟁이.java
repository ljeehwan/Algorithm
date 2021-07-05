package day0919;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_ÀÏ°ö³­ÀïÀÌ {
	//ÀÏ°ö³­ÀïÀÌÀÇ Å°ÀÇ ÇÕ : 100
	
	static int []dwarf = new int[9];
	static int []selected = new int[7];
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 9 ; i++) {
			dwarf[i] = sc.nextInt();
		}
		
		comb(0,0);
		
		Arrays.sort(selected);
		for(int i = 0 ; i < 7 ; i++) {
			System.out.println(selected[i]);
		}
	}
	
	public static void comb(int cnt, int cur) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0 ; i < 7  ; i++) {
				sum = sum + selected[i];
			}
			if(sum == 100) {
				flag=true;
			}
			return;
		}
		
		for(int i = cur ; i < 9 ; i++) {
			if(flag == true)
				return;
			selected[cnt] = dwarf[i];
			comb(cnt+1, i+1);
			
		}
	}
}
