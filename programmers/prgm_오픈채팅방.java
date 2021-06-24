package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class prgm_오픈채팅방 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		
		solution(s);
	}

	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();
		List<Set> list = new ArrayList<>();
		
		for(String info : record) {
			String[] infoArray = info.split(" ");
			
			if(!infoArray[0].equals("Leave")) {
				map.put(infoArray[1], infoArray[2]);
			}
			
		}
		
		for(String info : record) {
			String[] infoArray = info.split(" ");
			
			if(!infoArray[0].equals("Change")) {
				list.add(new Set(infoArray[1], infoArray[0]));
			}
		}
		
		String[] answer = new String[list.size()];
		
		for(int i = 0 ; i < list.size() ; i++) {
			Set st = list.get(i);
			String name = "";
			if(st.active.equals("Enter")) {
				name = map.get(st.id);
				answer[i] = name + "님이 들어왔습니다.";
			}
			else if(st.active.equals("Leave")) {
				name = map.get(st.id);
				answer[i] = name + "님이 나갔습니다.";
			}
			else {
				continue;
			}
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
class Set{
	String id;
	String active;
	
	public Set(String id, String active) {
		this.id = id;
		this.active = active;
	}
}