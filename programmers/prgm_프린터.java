import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int pri_length = priorities.length;
        boolean flag = false;
        int count = 0;
        int queue_size = 0;
        int standard = 0;
        int queue_value = 0;

        Queue queue = new LinkedList<>();

        // 문서 목록 큐에 입력
        for(int i = 0 ; i < pri_length ; i++){
            queue.add(priorities[i]);
        }

        standard = (int)queue.poll();   // 기준 값 저장. 

        while(!queue.isEmpty()){
            queue_size = queue.size();  // 인쇄될때 문서가 큐에서 빠져나가기 때문에 매번 사이즈 구함..
            for(int i = 0 ; i < queue_size ; i++){ // 큐에 기준 값 보다 큰 값 있으면 flag true.
                queue_value = (int)queue.poll(); 
                if(queue_value > standard){
                    flag = true;
                }
                queue.add(queue_value);
            }

            if(flag == true){           // flag true 일 경우 기준 값 큐에 add 후 새로운 기준 값 저장.
                queue.add(standard);
                standard = (int)queue.poll();
                flag = false;
                location--;            
                if(location < 0){       // location 이 음수일 경우 큐의 맨 뒤 위치.
                    location = queue_size;
                }
            }
            else{                       // flag false 일 경우 count +1
                count++;
                standard = (int)queue.poll();
                location--;
                if(location == -1){     // flag false 인데 location이 -1이면 인쇄된것이기 때문에 break
                    break;
                }
            }
            if(queue.isEmpty()){        // 맨 마지막 값 빠져나가는 경우(break로 빠져나가는게 아닌 경우) standard 값 까지 비워 줌.
                standard = 0;
            }
        }
        if(standard == 0){
            count++;
        }
        answer = count;

        return answer;
    }
}