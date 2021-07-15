package programmers;

public class prgm_최댓값과최솟값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "-1 -2 -3 -4";
		System.out.println(solution(s));

	}

	public static String solution(String s) {
        String answer = "";
        int strLen = s.length();
        
        char c = ' ';
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int num = 0;
        
        String[] arr = s.split(" ");
        
        for(String numStr : arr) {
        	num = Integer.parseInt(numStr);
        	if(num < min) {
        		min = num;
        	}
        	if(num > max) {
        		max = num;
        	}
        }
        
        
        answer = min + " " + max;
        
        
        return answer;
    }
	
}
