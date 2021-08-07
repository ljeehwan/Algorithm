import java.util.Arrays;
import java.util.Comparator;
class Solution {
   
    public String solution(int[] numbers) {
        String answer = "";

        int number_length = numbers.length;

        // 문자열 배열로 변경.
        String[] str_number = new String[number_length];

        for(int i = 0; i < number_length ; i++){
            str_number[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str_number, new Comparator<String>() {
 
            @Override
            public int compare(String o1, String o2) {
 
                String sum_str1 = o1 + o2;
                String sum_str2 = o2 + o1;
 
                return sum_str2.compareTo(sum_str1);
            }
        });

        for(int i = 0 ; i < number_length ; i++){
            answer = answer + str_number[i];
        }

        // 원소가 모두 0 일경우 0000으로 출력되기 때문에 0 으로 변환.
        if(answer.charAt(0) == '0')
            return "0";

        return answer;

    }
}