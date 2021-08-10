import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        int prices_length = prices.length;
        int[] answer = new int[prices_length];
        int standard = 0;
        int count = 0;
        int j = 1;
        Queue priceList = new LinkedList<>();
        Queue queue = new LinkedList<>();

        for(int i = 0 ; i < prices_length ; i++){
            priceList.add(prices[i]);
        }

        standard = (int)priceList.poll();

        while(!priceList.isEmpty()){
            for(int i = j ; i < prices_length ; i++){
                if(standard <= prices[i]){
                    count++;
                }
                else{
                    count++;
                    break;
                }
            }
            j = j+1;
            queue.add(count);
            standard = (int)priceList.poll();
            count = 0;
        }
        queue.add(count);
        for(int i = 0 ; i < prices_length ; i++){
            answer[i] = (int)queue.poll();
        }

        return answer;
    }
}