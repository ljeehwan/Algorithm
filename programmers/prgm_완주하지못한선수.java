package 해시.전화번호목록;

class Solution {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

         for(String prefix_number : phone_book) {
            for(String phone_number : phone_book) {
                if(prefix_number.equals(phone_number))
                    continue;

                if(phone_number.startsWith(prefix_number))
                    return false;
            }
        }

        return answer;
    }
}