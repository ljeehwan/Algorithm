package programmers;

import java.util.Stack;

public class prgm_올바른괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("()))((()"));
	}
	public static boolean solution(String s) {
        boolean answer = true;
        
        s = s.replace("()", "");
        
        Stack<Character> stack = new Stack<>();
        
        char c = ' ';
        int open = 0;
        int close = 0;
        for(int i = 0 ; i < s.length() ; i++) {
        	c = s.charAt(i);
        	
        	if(c == '(') {
        		stack.push(c);
        		open++;
        	}
        	else {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		
        		close++;
        	}
        }
        
        if(open != close || s.charAt(s.length()-1) == '(') {
        	return false;
        }

        return answer;
    }
}
