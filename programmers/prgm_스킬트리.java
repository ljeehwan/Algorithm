package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class prgm_스킬트리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		solution(skill, skill_trees);
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		int[] check = new int[27];
		
		Queue<Character> queue = new LinkedList<>();
		for(int i = 0 ; i < skill.length(); i++) {
			//System.out.println(skill.charAt(i) - 'A');
			char c = skill.charAt(i);
			check[c - 'A'] = 1;
			queue.offer(c);
		}
		
		for(String tree : skill_trees) {
			boolean flag = true;
			for(int i = 0 ; i < tree.length() ; i++) {
				char c = tree.charAt(i);
				if(check[c-'A'] == 0) {
					continue;
				}else {
					if(c == queue.peek()) {
						queue.poll();
					}
					else {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				answer++;
			}
			
			queue = new LinkedList<>();
			for(int i = 0 ; i < skill.length(); i++) {
				char c = skill.charAt(i);
				queue.offer(c);
			}
		}
		System.out.println(answer);
		return answer;
	}
}
