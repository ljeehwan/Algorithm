package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class prgm_순위검색 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		
		System.out.println(Arrays.toString(solution(info, query)));
	}

	public static int[] solution(String[] info, String[] query) {
		int queryLen = query.length;
		int infoLen = info.length;
		
        int[] answer = new int[queryLen];
        boolean flag = true;
        int infoDataLen = 0;
        int cnt = 0;
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0 ; i < queryLen ; i++) {
        	query[i] = query[i].replace(" and ", " ");
        }
        
        for(int i = 0 ; i < queryLen ; i++) {
        	String[] queryData = query[i].split(" ");
        	
        	for(int j = 0 ; j < infoLen ; j++) {
        		String[] infoData = info[j].split(" ");
        		infoDataLen = infoData.length;
        		flag = true;
        		
        		for(int k = 0 ; k < infoDataLen ; k++) {
        			if(k == infoDataLen - 1) {
            			int score = Integer.parseInt(infoData[k]);
            			int queryScore = Integer.parseInt(queryData[k]);
            			if(score < queryScore) {
            				flag = false;
            				break;
            			}
            		}
        			else if(queryData[k].equals("-")) {
            			continue;
            		}
        			else if(!infoData[k].equals(queryData[k])) {
            			flag = false;
            			break;
            		}
        		}
        		if(flag) {
            		answer[i]++;
            	}
        	}
        }
        /*for(int i = 0 ; i < queryLen ; i++) {
        	String[] queryData = query[i].split(" ");
     	
        	for(int j = 0 ; j < infoLen ; j++) {
        		String[] infoData = info[j].split(" ");
            	infoDataLen = infoData.length;
            	flag = true;
            	
            	cnt = 0;
            	
            	for(int k = 0 ; k < infoDataLen ; k++) {
            		if(k == infoDataLen - 1) {
            			int score = Integer.parseInt(infoData[k]);
            			int queryScore = Integer.parseInt(queryData[cnt]);
            			if(score < queryScore) {
            				flag = false;
            				break;
            			}
            		}
            		else if(queryData[cnt].equals("and")) {
            			k--;
            			cnt++;
            			continue;
            		}
            		else if(queryData[cnt].equals("-")) {
            			cnt++;
            			continue;
            		}
            		else if(!infoData[k].equals(queryData[cnt])) {
            			flag = false;
            			break;
            		}
            		
            		cnt++;
            	}
            	if(flag) {
            		answer[i]++;
            	}		
        	}
        }*/
        
        return answer;
    }
}
