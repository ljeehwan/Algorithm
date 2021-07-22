package day0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] student = new int[7][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); //성별
			int Y = Integer.parseInt(st.nextToken()); //학년
			//S : 0 여자 1 남자
			student[Y][S]++;
		}
		int cnt = 0;
		for(int i = 1 ; i < 7 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				if(student[i][j] % K != 0) {
					cnt = cnt + (student[i][j]/ K) + 1;
				}
				else if(student[i][j] % K == 0) {
					cnt = cnt + (student[i][j]/ K);
				}
			}
		}
		System.out.println(cnt);
	}
}
