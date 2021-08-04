package programmers;

public class prgm_짝지어제거하기 {

	public static void main(String[] args) {

		System.out.println(solution("cdcd"));

	}
	public static int solution(String s)
    {
        int answer = 0;

        int len = s.length();
        
        char c = s.charAt(0);
        char temp = ' ';
        String newStr = s;
        String newTemp = "";
        int tmpLen = len;
        for(int i = 1 ; i < tmpLen ; i++) {
        	temp = newStr.charAt(i);
        	
        	if(c == temp) {
        		newStr = newTemp + newStr.substring(i+1, tmpLen);
        		if(newStr.length() == 0) {
        			return 1;
        		}
        		c = newStr.charAt(0);
        		tmpLen = newStr.length();
        		newTemp = "";
        		i = 0;
        	}
        	else {
        		newTemp = newTemp + c;
        		c = temp;
        	}
        }

        return answer;
    }
}
