package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static int L, C;
	static char[] inputArray;
	static char[] makeArray;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		inputArray = new char[C];
		makeArray = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < C ; i++) {
			inputArray[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(inputArray);
		make(0,0);
		
	}
	public static void make(int cnt, int start) {
		if(cnt == L) {
			if(check() == true && check2() >= 2) {
				//정렬
				//Arrays.sort(makeArray);
				
				//문자열 출력
				String result = "";
				for(char c : makeArray) {
					result = result + c;
				}
				System.out.println(result);
			}
			
			return;
		}
		
		for(int i = start ; i < C ; i++) {
			makeArray[cnt] = inputArray[i];
			make(cnt+1, i+1);
		}
	}
	
	public static boolean check() {
		boolean result = false;
		
		for(char c : makeArray) {
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				return true;
			}
		}
		
		return result;
	}
	public static int check2() {
		
		int cnt = 0;
		for(char c : makeArray) {
			if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
				cnt++;
			}
		}
		return cnt;
	}
}
