package programmers;

import java.util.Arrays;

public class prgm_로또의최고순위와최저순위 {
	public static void main(String[] args) {
		
		int[] lottos = {44,1,0,0,31,25};
		int[] win_nums = {31,10,45,1,6,19};
		
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int len = lottos.length;
        int zero = 0;
        
        int[] numbers = new int[46];
        
        for(int i = 0 ; i < len ; i++) {
        	if(lottos[i] == 0) {
        		zero++;
        	}
        	else {
        		numbers[lottos[i]] = 1;
        	}
        }
        
        int cnt = 0;
        
        for(int i = 0 ; i < len ; i++) {
        	if(numbers[win_nums[i]] == 1) {
        		cnt++;
        	}
        }
        
        answer[0] = change(cnt + zero);
        answer[1] = change(cnt);  

        return answer;
    }
	
	public static int change(int num) {
		switch(num) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default :
			return 6;
		}
	}
}
