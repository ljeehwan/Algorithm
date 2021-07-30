class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        int len = numbers.length;
        dfs(numbers, 0, 0, target, len);
        return answer;
    }
    
    public static void dfs(int []numbers, int count, int sum, int target, int len) {
				
		if(count == len) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		
		int num = 0;
		
		if(count != 0) {
			num = sum;
		}
		
		dfs(numbers, count+1, num-numbers[count], target, len);
		dfs(numbers, count+1, num+numbers[count], target, len);
	}
}