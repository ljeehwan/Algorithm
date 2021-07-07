package programmers;

public class prgm_문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution("a"));
	}
	
	public static int solution(String s) {
		int answer = Integer.MAX_VALUE;
		
		int len = s.length();
		if(len < 2) {
			return 1;
		}
		int startLen = len/2;
		
		int cnt = 0;
		String makeStr = "";
		String temp = "";
		String temp2 = "";
		for(int i = startLen ; i > 0 ; i--) {
			cnt = 1;
			makeStr = "";
			temp = s.substring(0, i);
			for(int j = i ; j < len ; j = j + i) {
				int subEnd = i+j;
				if(subEnd > len) {
					subEnd = len;
				}
				temp2 = s.substring(j, subEnd);
				if(temp.equals(temp2)) {
					cnt++;
				}
				else if(cnt > 1) {
					makeStr = makeStr + cnt + temp;
					temp = temp2;
					cnt = 1;
				}
				else {
					makeStr = makeStr + temp;
					temp = temp2;
				}
			}
			if(cnt > 1) {
				makeStr = makeStr + cnt + temp;
			}
			else {
				makeStr = makeStr + temp;
			}
			int strLen = makeStr.length();
			
			if(strLen < answer) {
				answer = strLen;
			}
		}
		
		return answer;
	}
}
