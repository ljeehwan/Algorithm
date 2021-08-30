package devmatching;

import java.util.Arrays;

public class T2 {
	static int [][]map;
	public static void main(String[] args) {
		int[][] queries = {{1,1,100,97}};
		
		solution(100,97,queries);
	}
	public static int[] solution(int rows, int columns, int[][] queries) {
        int len = queries.length;
		int[] answer = new int[len];
        
        map = new int[rows+1][columns+1];
        int insertNum = 0;
        for(int i = 1 ; i <= rows ; i++) {
        	for(int j = 1 ; j <= columns ; j++) {
        		map[i][j] = ++insertNum;
        	}
        }
        
        for(int i = 0 ; i < len ; i++) {
        	answer[i] = rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	public static int rotate(int x1, int y1, int x2, int y2) {
		int min = Integer.MAX_VALUE;
		//rotate {2,2,5,4}
		/*
		 x1 : 2
		 x2 : 5
		 y1 : 2
		 y2 : 4
		 */
		//왼쪽 세로줄
		int temp = 0;
		for(int i = x1 ; i < x2 ; i++) {
			if(map[i][y1] < min) {
				min = map[i][y1];
			}
			if(i == x1) {
				temp = map[i][y1];
			}
			map[i][y1] = map[i+1][y1];
		}
		
		//상단 가로줄
		int temp1 = 0;
		for(int i = y2 ; i > y1 ; i--) {
			if(map[x1][i] < min) {
				min = map[x1][i];
			}
			if(i == y2) {
				temp1 = map[x1][i];
			}
			if(i == y1+1) {
				map[x1][i] = temp;
			}
			else {
				map[x1][i] = map[x1][i-1];
			}
		}
		//오른쪽 세로줄
		int temp2 = 0;
		for(int i = x2 ; i > x1 ; i--) {
			if(map[i][y2] < min) {
				min = map[i][y2];
			}
			if(i == x2) {
				temp2 = map[i][y2];
			}
			if(i == x1+1) {
				map[i][y2] = temp1;
			}
			else {
				map[i][y2] = map[i-1][y2];
			}
		}
		
		//하단 가로줄
		for(int i = y1 ; i < y2 ; i++) {
			if(map[x2][i] < min) {
				min = map[x2][i];
			}
			if(i == y2-1) {
				map[x2][i] = temp2;
			}
			else {
				map[x2][i] = map[x2][i+1];
			}
		}
		
		
		return min;
	}
}
