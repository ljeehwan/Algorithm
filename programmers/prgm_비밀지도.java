package programmers;

import java.util.Arrays;

public class prgm_비밀지도 {

	public static void main(String[] args) {
		int[] arr1 = {9,20,28,18,11};
		int[] arr2 = {30,1,21,17,28};
		System.out.println(Arrays.toString(solution(5, arr1, arr2)));

	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // 2진수로 표현
        String[] strArr1 = new String[n];
        String[] strArr2 = new String[n];
        String temp = "";
        for(int i = 0 ; i < n ; i++) {
        	strArr1[i] = "";
        	strArr2[i] = "";
        	
        	temp = Integer.toBinaryString(arr1[i]);
        	if(temp.length() == n) {
        		strArr1[i] = temp;
        	}
        	else {
        		int sub = n - temp.length();
        		for(int j = 0 ; j < sub ; j++) {
        			strArr1[i] = strArr1[i] + "0";
        		}
        		strArr1[i] = strArr1[i] + temp;
        	}
        	temp = Integer.toBinaryString(arr2[i]);
        	if(temp.length() == n) {
        		strArr2[i] = temp;
        	}
        	else {
        		int sub = n - temp.length();
        		for(int j = 0 ; j < sub ; j++) {
        			strArr2[i] = strArr2[i] + "0";
        		}
        		strArr2[i] = strArr2[i] + temp;
        	}
        }
        
        
        // 비교 
        // 문자열 charat or연산
        char c1 = ' ';
        char c2 = ' ';
     
        for(int i = 0 ; i < n ; i++) {
        	answer[i] = "";
        	for(int j = 0 ; j < n ; j++) {
        		c1 = strArr1[i].charAt(j);
        		c2 = strArr2[i].charAt(j);
        		
        		if(c1 == '0' && c2 == '0') {
        			answer[i] = answer[i] + " ";
        		}
        		else {
        			answer[i] = answer[i] + "#";
        		}
        	}
        }
        
        return answer;
    }
}
