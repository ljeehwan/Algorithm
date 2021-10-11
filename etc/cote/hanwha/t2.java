import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class t2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {1,2,12,14,15};
		int k = 2;
		System.out.println(solution(scores, k));
	}

	public static int solution(int[] scores, int k) {
		int answer = 0;
		int len = scores.length;	
		int temp = 0;

		List<Data> minList = new ArrayList<>();

		for(int i = len-1 ; i > 0 ; i--) {
			temp = scores[i] - scores[i-1];
			minList.add(new Data(temp, i));
		}
		
		Collections.sort(minList);
		
		int cnt = k-1;
		List<Integer> idxList = new ArrayList<>();
		
		for(int i = 0 ; i < k-1 ; i++) {
			idxList.add(minList.get(i).idx);
			//System.out.println(dt.v + " " + dt.idx);
		}

		Collections.sort(idxList);
		
		int idx = 0;
		int startIdx = 0;
		for(int i = 0 ; i < len ; i++) {
			if(idx == k-1) {
				answer = answer + (scores[len-1] - scores[startIdx]);
				break;
			}
			if(i == idxList.get(idx)-1) {
				answer = answer + (scores[i] - scores[startIdx]);
				startIdx = idxList.get(idx);
				idx++;
			}
		}
		
		
		
		return answer;
	}

}
class Data implements Comparable<Data>{
	int v;
	int idx;
	public Data(int v, int idx) {
		this.v = v;
		this.idx = idx;
	}
	@Override
	public int compareTo(Data o) {
		// TODO Auto-generated method stub
		return o.v - this.v;
	}
}


