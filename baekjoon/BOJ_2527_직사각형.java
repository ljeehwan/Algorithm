package day0923;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2527_���簢�� {
	/*
	 ���簢�� a
	 ���� b
	 �� c
	 �Ȱ�ħ d
	 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] num = new int[4][8];
		for(int i = 0 ; i < 4 ; i++) {
			for(int j = 0 ; j < 8 ; j++) {
				num[i][j] = sc.nextInt();
			}
		}

		String []result = new String[4];
		for(int i = 0 ; i < 4 ; i++) {
			if(num[i][2] > num[i][4] && num[i][3] > num[i][5]) {
				result[i] = "a";
			}
			else if(num[i][2] == num[i][4] || num[i][3] == num[i][5]) {
				result[i] = "b";
			}
			else if(num[i][2] == num[i][4] && num[i][3] == num[i][5]) {
				result[i] = "c";
			}
			else if(num[i][2] < num[i][4] && num[i][3] < num[i][5]) {
				result[i] = "d";
			}
			
		}

		for(String a : result) {
			System.out.println(a);
		}
	}
}