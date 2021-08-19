import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_size = truck_weights.length;
        int crossing_sum = 0;
        int i = 0; // 출발한 트럭 횟수.
        
        Queue wait_truck = new LinkedList(); // 대기중인 트럭.
        Queue crossing = new LinkedList();   // 다리를 건너고있는 트럭
        Queue arrive = new LinkedList();     // 도착한 트럭
        int []position = new int[truck_size];// 트럭 별 위치 입력 할 배열

        // 대기중인 트럭 큐에 입력.
        for(int truckWeights : truck_weights){
            wait_truck.add(truckWeights);
        }

        while(true){
            answer++; // 한 회 마다 +1
            // 건너고 있는 트럭과 대기중인 트럭이 다리 무게보다 작은경우만 출발.
            if(wait_truck.peek() != null && crossing_sum + (int)wait_truck.peek() <= weight){
                crossing_sum = crossing_sum + (int)wait_truck.peek();// 다리위에 있는 트럭 무게
                crossing.add(wait_truck.poll());

                i++; // 새로운 트럭 출발할 때마다 증가.
            }
            
            for(int j = 0; j<i ; j++){
                if(position[j] != -1) // 도착한 트럭의 위치는 입력하지 않음.
                    position[j]++; // 위치 1씩 증가.

                if(position[j] == bridge_length){ // 다리 길이와 위치가 같은경우 도착 / 도착한 트럭의 위치는 -1
                    position[j] = -1;
                    //if(wait_truck.peek() != null)
                    crossing_sum = crossing_sum - (int)crossing.peek(); // 도착한 트럭 무게 빼주기.
                    arrive.add(crossing.poll());
                }
            }

            if(arrive.size() == truck_size){
                answer++;
                break;
            }
        }
        return answer;
    }
}