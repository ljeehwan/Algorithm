import java.util.ArrayList;
import java.util.List;

public class t3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {1,3,2,4};
		int[] B = {4,1,3,2};
		System.out.println(solution(A,B));
	}

	public static boolean solution(int[] A, int[] B) {
        boolean answer = false;
        int len = A.length;
        boolean[] check = new boolean[len+1];
        
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        
        for(int i = 0 ; i < len ; i++) {
        	aList.add(A[i]);
        	bList.add(B[i]);
        }
        
        int cnt = 0;
        int idx = 0;
        while(true) {
        	int nextNum = bList.get(idx); 
        	if(aList.contains(nextNum) && check[nextNum] == false) {
        		idx = aList.indexOf(nextNum);
        		cnt++;
        		check[nextNum] = true;
        	}
        	else {
        		break;
        	}
        }
//        while(cnt != len) {
//        	int nextNum = bList.get(idx); 
//        	if(aList.contains(nextNum) && check[nextNum] == false) {
//        		idx = aList.indexOf(nextNum);
//        		cnt++;
//        		check[nextNum] = true;
//        	}
//        	else {
//        		break;
//        	}
//        }
        
        if(cnt == len) {
        	answer = true;
        }
        return answer;
    }
}
