import java.util.Stack;

public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("3 DUP 5 - -"));
	}
	
	// POP �ֻ��� ��ȣ ����
	// DUP �ֻ��� ������ ������ ���ÿ� Ǫ��
	// + �� ���� �� ��� ������ �� ���� Ǫ��
	// - �ֻ��� �� ��� ���ϰ� ù ��°(�ֻ���)��ҿ��� �� ��° ��Ҹ� ���� �� ���̸� ���ÿ� Ǫ��
	// ���ÿ��� ���ֻ��� �� ��ȯ
	
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
					//������Ȳ : ���� ������� ���
					if(stack.isEmpty()) {
						return -1;
					}
					stack.pop();
					
					break;
					
				case "DUP":
					//������Ȳ : ���� ������� ���
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
					// ���� ������� ���
					if(stack.isEmpty()) {
						return -1;
					}
					
					int firstNum = 0;
					int secondNum = 0;
					firstNum = stack.pop();
					
					// �Ѱ� ���� �ΰ�°�� ����ִ� ��� ��, ���� �Ѱ����ִ� ���
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
					// ���� ������� ���
					if(stack.isEmpty()) {
						return -1;
					}
					
					int firstNum2 = 0;
					int secondNum2 = 0;
					firstNum2 = stack.pop();
					
					// �Ѱ� ���� �ΰ�°�� ����ִ� ��� ��, ���� �Ѱ����ִ� ���
					if(stack.isEmpty()) {
						return -1;
					}
					secondNum2 = stack.pop();
					
					// ����� �����ϰ��? �� ù ���ڰ� �ι�° ���ں��� ���� ���
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
