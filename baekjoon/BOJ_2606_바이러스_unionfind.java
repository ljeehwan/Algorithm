package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_unionfind {

	static int N, M;
	static int[] parents;
	static int[] visited;
	static int count = 0;
	
	public static void make() {
		for(int i = 1 ; i < N+1 ; i++) {
			parents[i] = i;
		}
	}
	
	public static void union(int first, int second) {
		int x = find(first);
		int y = find(second);
		
		if(x > y) {
			parents[x] = y;
		}
		else {
			parents[y] = x;
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}
		else {
			int num = find(parents[x]);
			parents[x] = num;
			return num;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parents = new int[N+1];
		
		make();
		
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int firstNum = Integer.parseInt(st.nextToken());
			int secondNum = Integer.parseInt(st.nextToken());
			
			union(firstNum, secondNum);
		}
		
		for(int i = 2 ; i <= N ; i++) {
			if(find(i) == find(1)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
