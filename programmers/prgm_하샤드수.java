class Solution {
  public boolean solution(int x) {
      boolean answer = true;

        int a = x/10000;
        int b = x%10000/1000;
        int c = x%10000%1000/100;
        int d = x%10000%1000%100/10;
        int e = x%10000%1000%100%10;

        int haxade = a+b+c+d+e;

        if(x%haxade != 0)
            answer = false;
            
        return answer;
  }
}