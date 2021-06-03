package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {
	static int T, max, maxEndTime;
	static int[][] conference;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		conference = new int[T][2];
		max = 0;
		maxEndTime = 0;
		StringTokenizer st;
		for(int i = 0 ; i < T ; i++) {
			st = new StringTokenizer(br.readLine());
			conference[i][0] = Integer.parseInt(st.nextToken());
			conference[i][1] = Integer.parseInt(st.nextToken());
			if(maxEndTime < conference[i][1]) {
				maxEndTime = conference[i][1];
			}
		}
		
		for(int i = 0 ; i < T ; i++) {
			solution(i, 1);
		}

		System.out.println(max);
	}
	
	public static void solution(int index, int count) {
		if(conference[index][0] >= maxEndTime) {
			if(count > max) {
				max = count;
			}
			return;
		}
		int endTime = conference[index][1];
		
		for(int i = 0 ; i < T ; i++) {
			if(conference[i][0] >= endTime) {
				solution(i, count+1);
			}
		}
		
		if(count > max) {
			max = count;
		}
	}

}
