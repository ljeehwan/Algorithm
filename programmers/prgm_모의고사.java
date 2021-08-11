import java.util.*;

class Solution {
    
    public int[] solution(int[] answers) {
        //int[] answer = new int[3];
        int[] answer_count = new int[3];
        int answer_len = answers.length;
        int j = 0;
        
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        
        int student1_len = student1.length;
        int student2_len = student2.length;
        int student3_len = student3.length;
        
        for(int i = 0 ; i < answer_len ; i++){
            if(answers[i] == student1[i%student1_len]){
                answer_count[0]++;
            }
            if(answers[i] == student2[i%student2_len]){
                answer_count[1]++;
            }
            if(answers[i] == student3[i%student3_len]){
                answer_count[2]++;
            }
            
        }
        
        int len = answer_count.length;
        int max = 0;
        for(int i = 0 ; i<len ; i++){
            if(answer_count[i] >= max){
                max = answer_count[i];
            }
        }
        
        List<Int> answer = new ArrayList<>();
        
        for(int i = 0 ; i<len ; i++){
            if(max == answer_count[i]){
                answer.add(i);
            }
        }
        return answer;
    }
}