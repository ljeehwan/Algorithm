package programmers;

import java.util.Arrays;

public class prgm_최소직사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] sizes = {{60,50}, {30,70}, {60,30}, {80,40}};
		
		System.out.println(solution(sizes));
	}

	public static int solution(int[][] sizes) {
        int answer = 0;
        int len = sizes.length;
        
        int[] garo = new int[len];
        int[] sero = new int[len];
        
        for(int i = 0 ; i < len ; i++) {
        	if(sizes[i][0] > sizes[i][1]) {
        		garo[i] = sizes[i][0];
        		sero[i] = sizes[i][1];
        	}
        	else {
        		garo[i] = sizes[i][1];
        		sero[i] = sizes[i][0];
        	}
        }
        
        Arrays.sort(garo);
        Arrays.sort(sero);
        
        answer = garo[len-1] * sero[len-1];
        return answer;
    }
}
