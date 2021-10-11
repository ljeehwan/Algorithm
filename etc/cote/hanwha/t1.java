
public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("11101010000001010000100100010001"));
	}

	public static String solution(String bits) {
		String answer = "";
		int len = bits.length();
		
		String temp = "";
		for(int i = 0 ; i < len ; i=i+8) {
			temp = bits.substring(i, i+8);
			answer = answer + Integer.parseInt(temp, 2) + ".";
		}
		answer = answer.substring(0, answer.length()-1);

		
		return answer;
	}
}
