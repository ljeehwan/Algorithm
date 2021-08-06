import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int case_count = 1; //곱셈으로 인해 1로 초기화.
        int clothes_length = clothes.length;

        HashMap<String, Integer> clothes_map = new HashMap<>();

        for(int i = 0; i < clothes_length ; i++){
            if(clothes_map.get(clothes[i][1]) != null){
                clothes_map.put(clothes[i][1], clothes_map.get(clothes[i][1])+1);
            }
            else{
                clothes_map.put(clothes[i][1], 1);
            }
        }

        for(int map_value : clothes_map.values()) { 
            case_count = case_count * (map_value+1);
        }

        answer = case_count - 1;
        
        return answer;
    }
}