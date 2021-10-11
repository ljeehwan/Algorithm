import java.util.Stack;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("3 DUP 5 - -"));
	}
	
	// POP 최상위 번호 제거
	// DUP 최상위 숫자의 복제본 스택에 푸시
	// + 맨 위에 두 요소 꺼내고 그 합을 푸시
	// - 최상위 두 요소 팝하고 첫 번째(최상위)요소에서 두 번째 요소를 빼고 그 차이를 스택에 푸시
	// 스택에서 ㅊ최상위 값 반환
	
	// error
	// 2^20 : 1048576;
	static final int RANGE = 1048576;
	public static int solution(String S) {
		int answer = 0;
		String[] sSplit = S.split(" ");
		int len = sSplit.length;
		
		Stack<Integer> stack = new Stack<>();
		

		
		char c = ' ';
		for(int i = 0 ; i < len ; i++) {
			c = sSplit[i].charAt(0);
			if(c > 48 && c < 58) {
				stack.push(Integer.parseInt(sSplit[i]));
			}
			else {
				switch(sSplit[i]) {
				case "POP":
					//에러상황 : 스택 비어있을 경우
					if(stack.isEmpty()) {
						return -1;
					}
					stack.pop();
					
					break;
					
				case "DUP":
					//에러상황 : 스택 비어있을 경우
					if(stack.isEmpty()) {
						return -1;
					}
					
					int num = 0;
					num = stack.peek();
					if(num < 0 || num > RANGE) {
						return -1;
					}
					stack.push(num);				
					
					break;
					
				case "+":
					// 스택 비어있을 경우
					if(stack.isEmpty()) {
						return -1;
					}
					
					int firstNum = 0;
					int secondNum = 0;
					firstNum = stack.pop();
					
					// 한개 빼고 두개째에 비어있는 경우 즉, 숫자 한개만있는 경우
					if(stack.isEmpty()) {
						return -1;
					}
					secondNum = stack.pop();
					
					int cal = 0;
					cal = firstNum + secondNum;
					if(cal < 0 || cal > RANGE) {
						return -1;
					}
					stack.push(cal);
		
					break;
					
				case "-":
					// 스택 비어있을 경우
					if(stack.isEmpty()) {
						return -1;
					}
					
					int firstNum2 = 0;
					int secondNum2 = 0;
					firstNum2 = stack.pop();
					
					// 한개 빼고 두개째에 비어있는 경우 즉, 숫자 한개만있는 경우
					if(stack.isEmpty()) {
						return -1;
					}
					secondNum2 = stack.pop();
					
					// 결과가 음수일경우? 즉 첫 숫자가 두번째 숫자보다 작을 경우
					if(firstNum2 < secondNum2) {
						return -1;
					}
					
					int cal2 = 0;
					cal2 = firstNum2 - secondNum2;
					if(cal2 < 0 || cal2 > RANGE) {
						return -1;
					}
					stack.push(cal2);					
					
					break;
				}
			}
		}
		
		answer = stack.peek();
		
		return answer;
	}
}
