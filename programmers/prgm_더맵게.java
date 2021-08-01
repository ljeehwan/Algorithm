import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
         int answer = 0;
        int scoville_length = scoville.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        
        for(int i = 0 ; i < scoville_length ; i++){
            pQueue.add(scoville[i]);
        }
        
        int sub = 0;
        while(true){
            if(pQueue.peek() > K){
                break;
            }

            if(pQueue.size() == 1){
                return -1;
            }
                  
            //int min = pQueue.poll();
            //int min2 = pQueue.poll();
            //sub = min + (min2 * 2);
            sub = pQueue.poll() + (pQueue.poll() * 2);
            
            pQueue.add(sub);

            answer++;
        }

        return answer;
    }
}