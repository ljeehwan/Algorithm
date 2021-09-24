package programmers;

import java.util.Arrays;

public class prgm_폰켓몬2 {

	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		
		System.out.println(solution(nums));

	}
	static int[] array;
	static int[] check;
	static int max;
	static boolean flag;
	public static int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int r = N/2;
        array = new int[r];
        check = new int[200001];
        max = 0;
        flag = false;
        comb(0, 0, r, N, nums);
        
        answer = max;
        return answer;
    }
	
	public static void comb(int start, int cnt, int r, int N, int[] nums) {
		if(flag == true) {
			return;
		}
		if(cnt == r) {
			int count = 0;
			for(int i = 0 ; i < 200001 ; i++) {
				if(check[i] != 0) {
					count++;
				}
			}
			if(count == N) {
				max = count;
				flag = true;
				return;
			}
			if(max < count) {
				max = count;
			}
			return;
		}
		
		for(int i = start ; i < N ; i++) {
			array[cnt] = nums[i];
			check[array[cnt]]++;
			comb(i+1, cnt+1, r, N, nums);
			check[array[cnt]]--;
		}
	}
}
