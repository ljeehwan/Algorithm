package kakaointern;

import java.util.Arrays;

public class t1 {
	public static void main(String[] args) {
		String s = "2three45sixseven";
		solution(s);
	}
	static String[] array = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	public static int solution(String s) {
        int answer = 0;
        String result = "";
        
        int strlen = s.length();
        String temp = "";
        
        for(int i = 0 ; i < strlen ; i++) {
        	char c = s.charAt(i);
        	if((byte)c >= 48 && (byte)c < 58) {
        		result = result + c;
        	}
        	else {
        		temp = temp + c;
        		
        		if(Arrays.asList(array).contains(temp)) {
                	int a = Arrays.asList(array).indexOf(temp);
                	result = result + a;
                	temp = "";
                }
        	}
//        	System.out.println((byte)c);
        }
        
        System.out.println(result);
        answer = Integer.parseInt(result);
        		
        return answer;
    }
}
