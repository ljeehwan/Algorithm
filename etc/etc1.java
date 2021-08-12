import java.util.ArrayList;

public class etc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(7, 55);
	}

	static ArrayList<Integer> list = new ArrayList<>();;
	static int cnt;
	public static void solution(int N, int K) {
		list.add(1);
		list.add(2);
		cnt = 2;
		fibonachi(1, 2, K);
		
		System.out.println(list.get(cnt-N));
		System.out.println(list.get(cnt-N+1));
	}
	
	public static void fibonachi(int a, int b, int K) {
		list.add(a+b);
		cnt++;
		if(a+b == K) {
			return ;
		}
		
		fibonachi(b, a+b, K);
	}
}
