package day0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_����� {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] student = new int[7][2];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); //����
			int Y = Integer.parseInt(st.nextToken()); //�г�
			//S : 0 ���� 1 ����
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
