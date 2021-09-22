package programmers;

import java.util.Stack;

public class prgm_크레인인형뽑기게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = moves.length;
        int boardLen = board.length;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for(int i = 0 ; i < len ; i++) {
        	for(int j = 0 ; j < boardLen ; j++) {
            	num = board[j][moves[i]-1];
        		if(num != 0) {
            		if(stack.isEmpty()) {
            			stack.push(num);
            		}
            		else if(stack.peek() == num) {
            			stack.pop();
            			answer = answer + 2;
            		}
            		else {
            			stack.push(num);
            		}
            		board[j][moves[i]-1] = 0;
            		break;
        		}
            }
        }
        
        return answer;
    }
}
