package programmers;

import java.util.HashMap;

public class prgm_전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		boolean result = solution(phone_book);
		
		System.out.println(result);
	}
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String phoneNumber : phone_book) {
			map.put(phoneNumber, 0);
		}
		
		for(String key : map.keySet()) {
			for(String subKey : map.keySet()) {
				if(subKey.equals(key)) {
					continue;
				}
				else if(subKey.startsWith(key)) {
					return false;
				}
			}
		}
		
		return answer;
	}
}
