package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class prgm_실패율 {

	public static void main(String[] args) {
		
		int N = 5;
		int[] stages = {2,1,2,4,2,4,3,3};
		System.out.println(Arrays.toString(solution(N, stages)));

	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> map = new HashMap<>();
        
        for(int i = 1 ; i < N+1 ; i++) {
        	double over = 0.0;
        	double stage = 0.0;
        	double fail = 0.0;
        	for(int j = 0 ; j < stages.length ; j++) {
        		if(stages[j] > i) {
        			over++;
        		}
        		else if(stages[j] == i) {
        			over++;
        			stage++;
        		}
        	}
        	if(stage == 0 && over == 0) {
        		fail = 0;
        	}
        	else {
        		fail = stage/over;
        	}
        	
        	map.put(i, fail);
        }

        ArrayList<Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        
        //List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(testMap.entrySet());

		// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
		Collections.sort(list, new Comparator<Entry<Integer, Double>>() {
			// compare로 값을 비교
			public int compare(Entry<Integer, Double> obj1, Entry<Integer, Double> obj2)
			{
				// 내림 차순으로 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

        for(int i = 0 ; i < N ; i++) {
        	//System.out.println(list.get(i).getKey() + " " +  list.get(i).getValue());
        	answer[i] = list.get(i).getKey();
        }
        
        
        return answer;
    }
}