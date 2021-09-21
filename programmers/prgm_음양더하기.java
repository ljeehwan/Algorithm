package programmers;

public class prgm_음양더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] absolutes = {4,7,12};
		boolean[] signs = {true, false, true};
		
		System.out.println(solution(absolutes, signs));
	}

	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;
        int num = 0;
        for(int i = 0 ; i < len ; i++) {
        	num = absolutes[i];
        	if(signs[i]) {
        		answer = answer + num;
        	}
        	else {
        		answer = answer - num;
        	}
        }
        
        return answer;
    }
}
