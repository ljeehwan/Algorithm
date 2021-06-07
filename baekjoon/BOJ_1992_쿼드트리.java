package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1992_쿼드트리 {

	static int N;
	static int[][] map;
	static List<Object> list = new ArrayList<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());		
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		compression(0,0,N);
		
		String result = "";
		
		for(int i = 0 ; i < list.size(); i++) {
			result = result + list.get(i);
		}
		System.out.println(result);
	}
	public static void compression(int r, int c, int size) {
		
		if(check(r,c,size)) {
			list.add(map[r][c]);
		}
		else {
			list.add("(");
			int newSize = size/2;
			
			compression(r,c,newSize);
			compression(r,c+newSize,newSize);
			compression(r+newSize,c,newSize);
			compression(r+newSize,c+newSize,newSize);
			list.add(")");
		}
	}
	
	public static boolean check(int r, int c, int size) {
		int standard = map[r][c];
		
		for(int i = r ; i < r+size ; i++) {
			for(int j = c ; j < c+size ; j++) {
				if(standard != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	

}
