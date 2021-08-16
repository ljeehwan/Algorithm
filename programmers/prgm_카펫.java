class Solution {
    public int[] solution(int brown, int red) {
        int [] answer = new int[2];
        int x = 0;
        int y = 0;
        int sub = 0;
        int sum = brown + red;
        int temp = sum;
        int width = 0;
        int depth = 0;
        for(int i = red/2 ; i > 0; i--){
            if(red%i == 0){
                width = i;
                depth = red/i;
            }
            if(2*width + 2*depth + 4 == brown){
                break;
            }
        }

        answer[0] = width+2;
        answer[1] = depth+2;
        return answer;
    }
}