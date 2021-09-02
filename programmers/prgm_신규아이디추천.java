package programmers;

public class prgm_신규아이디추천 {
	public static void main(String[] args) {
		System.out.println(solution("=.="));
	}
	
	public static String solution(String new_id) {
        String answer = "";
        int strLen = new_id.length();
        
        // 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        // 소문자, 숫자, -, _, . 제외 제거
        char c = ' ';
        
        for(int i = 0 ; i < strLen ; i++) {
        	c = new_id.charAt(i);
        	if(c >= 97 && c <= 122) {
        		answer = answer + c;
        	}
        	else if(c >= 48 && c <= 57) {
        		answer = answer + c;
        	}
        	else if(c == '-' || c == '_' || c == '.') {
        		answer = answer + c;
        	}
        }
        // 마침표가 2번이상 연속된 부분을 하나의 마침표로
        boolean flag = false;
        String temp = "";
        for(int i = 0 ; i < answer.length() ; i++) {
        	c = answer.charAt(i);
        	if(c == '.' && flag == false) {
        		temp = temp + c;
        		flag = true;
        	}
        	else if(c == '.' && flag == true) {
        		continue;
        	}
        	else {
        		temp = temp + c;
        		flag = false;
        	}
        }
        answer = temp;
        // . 처음이나 끝  제거
        if(answer.charAt(0) == '.') {
        	if(answer.length() < 2) {
        		answer = "";
        	}
        	else{
        		answer = answer.substring(1,answer.length());
        	}
        }
        if(answer.length() > 1 && answer.charAt(answer.length()-1) == '.') {
        	if(answer.length() < 2) {
        		answer = "";
        	}
        	else {
        		answer = answer.substring(0, answer.length()-1);
        	}  	
        }
        // 빈 문자열 a 대입
        if(answer.length() == 0) {
        	answer = answer + "a";
        }
        // 16자 이상이면 15개까지 남김.
        // . 처음이나 끝 제거
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        }
        if(answer.charAt(0) == '.') {
        	answer = answer.substring(1,answer.length());
        }
        if(answer.charAt(answer.length()-1) == '.') {
        	answer = answer.substring(0, answer.length()-1);
        }
        // 길이가 2자 이하면 마지막 문자를 길이 3 될 때까지 반복해서 붙임.
        if(answer.length() <= 2) {
        	char cc = answer.charAt(answer.length()-1);
        	while(answer.length() < 3) {
        		answer = answer + cc;
        	}
        }

        return answer;
    }
}
