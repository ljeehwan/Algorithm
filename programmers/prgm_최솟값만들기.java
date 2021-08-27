package programmers;

import java.util.Arrays;

public class prgm_최솟값만들기 {

	public static void main(String[] args) {

		int[] A = {1,4,2};
		int[] B = {5,4,4};
		
		System.out.println(solution(A, B));

	}

	public static int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = len-1;
        
        for(int i = 0 ; i < len ; i++) {
        	answer = answer + (A[i] * B[idx]);
        	idx--;
        }

        return answer;
    }
}
