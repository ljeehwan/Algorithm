package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

	static int T, N;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for(int tc = 0 ; tc < T ; tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new int[N+2];
			List<Locate3> list = new ArrayList<>();
			
			for(int i = 0 ; i < N+2 ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Locate3(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			String result = bfs(list);
			System.out.println(result);
		}
	}
	public static String bfs(List<Locate3> list) {
		String result = "sad";
		Locate3 start = list.get(0);
		Locate3 end = list.get(N+1);
		visited[0] = 1;
		Queue<Locate3> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Locate3 current = queue.poll();
			
			if(current.equals(end)) {
				result = "happy";
				break;
			}
			
			for(int i = 1 ; i < N+2 ; i++) {
				if(visited[i] == 0 && getDistance(current.x, list.get(i).x, current.y, list.get(i).y) <= 1000){
					queue.offer(list.get(i));
					visited[i] = 1;
				}
			}
			
		}
		return result;
	}
	public static int getDistance(int x1, int x2, int y1, int y2) {
		int distance = Math.abs(x2-x1) + Math.abs(y2-y1);
		
		return distance;
	}
//	public static boolean getDistance(int x1, int x2, int y1, int y2) {
//		int distance = (x2-x1) + (y2-y1);
//		
//		if(distance > 1000) {
//			return false;
//		}
//		
//		return true;
//	}

}
class Locate3{
	int x;
	int y;
	public Locate3(int x, int y) {
		this.x = x;
		this.y = y;
	}
}