package programmers;

public class prgm_이상한문자만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("  try hello world   "));
	}

	public static String solution(String s) {
        String answer = "";
        
        int len = s.length();
        char c = ' ';
        String temp = "";
        int cnt = 0;
        for(int i = 0 ; i < len ; i++) {
        	c = s.charAt(i);
        	
        	if(c == ' ') {
        		answer = answer + c;
        		cnt = 0;
        	}
        	else {
        		temp = temp + c;
        		
        		if(cnt%2 == 0) {
        			answer = answer + temp.toUpperCase();
        		}
        		else {
        			answer = answer + temp.toLowerCase();
        		}
        		
        		cnt++;
        		temp = "";
        	}
        }
        
        
        return answer;
    }
}
