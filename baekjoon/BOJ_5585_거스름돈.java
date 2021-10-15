package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585_거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int money = 1000 - Integer.parseInt(br.readLine());
		// 500 100 50 10 5 1
		// 1000
		while(true) {
			if(money >= 500) {
				money = money - 500;
				cnt++;
			}
			else if(money >= 100) {
				money = money - 100;
				cnt++;
			}
			else if(money >= 50) {
				money = money - 50;
				cnt++;
			}
			else if(money >= 10) {
				money = money - 10;
				cnt++;
			}
			else if(money >= 5) {
				money = money - 5;
				cnt++;
			}
			else if(money >= 1) {
				money = money - 1;
				cnt++;
			}
			else {
				break;
			}
		}
		
		System.out.println(cnt);
	}

}
