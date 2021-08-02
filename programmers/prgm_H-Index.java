import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int count = 0;
        int count2 = 0;
        int length = citations.length;
        //int flag = length;

        Arrays.sort(citations);
        answer = citations[length-1];
        while(true){
            
            for(int i = length-1; i >= 0 ; i--){

                if(citations[i] >= answer){
                    count++;
                }
                else{
                    count2++;
                }
            }
            if(count >= answer && answer >= count2){
                break;
            }
            count = 0;
            count2 = 0;
            answer = answer-1;
        }
        
        return answer;
    }
}