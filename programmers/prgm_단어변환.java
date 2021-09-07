package programmers;

public class prgm_단어변환 {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin, target, words));

	}

	static int min;
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        min = Integer.MAX_VALUE;
        
        boolean flag = true;
        for(String str : words) {
        	if(str.equals(target)) {
        		flag = false;
        		break;
        	}
        }
        if(flag)
        	return 0;
        
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 0);
        
        answer = min;
        return answer;
    }
	
	public static void dfs(String src, String target, String[] words, boolean[] visited, int count) {
		int wordLen = words[0].length();
        if(src.equals(target)) {
        	if(min > count) {
        		min = count;
        	}
        	return;
        }
        for(int i = 0 ; i < words.length ; i++) {
        	if(visited[i] == true) {
        		continue;
        	}
         	char srcChar = ' ';
        	char cmpChar = ' ';
        	int cnt = 0;
        	for(int j = 0 ; j < wordLen ; j++) {
        		
        		if(cnt > 1) {
        			break;
        		}
        		srcChar = src.charAt(j);
        		cmpChar = words[i].charAt(j);
        		
        		if(srcChar != cmpChar) {
        			cnt++;
        		}
        	}
        	if(cnt == 1) {
        		visited[i] = true;
        		dfs(words[i], target, words, visited, count+1);
        		visited[i] = false;
        	}
        }
	}
}
