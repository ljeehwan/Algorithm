package programmers;

public class prgm_부족한금액계산하기 {
	public static void main(String[] args) {
		System.out.println(solution(3,20,4));
	}
	
	public static long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1 ; i <= count ; i++) {
            sum = sum + (price*i);
        }
        
        answer = sum - money;
        if(answer < 0){
            return 0;
        }
        
        return answer;
    }
}
