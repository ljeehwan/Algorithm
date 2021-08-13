import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int standard = 0;
        int complete_count = 1;
        int complete_size = 0;
        int progresses_size = progresses.length;

        Queue queue = new LinkedList<>();
        Queue complete = new LinkedList<>();

        // 각 기능별 남은 날짜 계산.
        for(int i = 0; i < progresses_size ; i++){
            if((100 - progresses[i]) % speeds[i] == 0)
                queue.add((100 - progresses[i])/speeds[i]);
            else
                queue.add((100 - progresses[i])/speeds[i] + 1);
        }

        standard = (int)queue.poll();

        while(!queue.isEmpty()){
            int num = (int)queue.poll();

            if(num <= standard){
                complete_count++;
            }

            else{
                complete.add(complete_count);
                complete_count = 1;
                standard = num;
            }
        }
        // 빠져나온 뒤 마지막 배포 입력
        complete.add(complete_count);

        complete_size = complete.size();
        int[] answer = new int[complete_size];
        for(int i = 0 ; i < complete_size ; i++){
            answer[i] = (int)complete.poll();
        }
        
        return answer;
    }
}