package 0825;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15686_치킨배달 {
	
	static class Loc {
		int r,c;
		public Loc(int r,int c){
			this.r=r;
			this.c=c;
		}
	};
	
	static ArrayList<Loc>home= new ArrayList<Loc>();
	static ArrayList<Loc>chickens=new ArrayList<Loc>();
	static int N,M,Ans=Integer.MAX_VALUE;
	static boolean[] visit;
	static int[] sel;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = sc.nextInt();
				if(n==1) {
					home.add(new Loc(i,j));
				}else if(n==2) {
					chickens.add(new Loc(i,j));
				}
			}
		}
		// 방문배열 ()
		visit=new boolean[chickens.size()];
		// 선택배열 ()
		sel = new int[M];
		
		com(0,0);
		
		System.out.println(Ans);
		sc.close();
		
	}

	private static void com(int idx, int k) {
		if(k==M) {
			int sum=0;
			for (int i = 0; i < home.size(); i++) {
				int dist=Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					dist=Math.min(dist, calc(home.get(i),chickens.get(sel[j])));
				}
				sum+=dist;
			}
			Ans=Math.min(Ans, sum);
			return;
		}
		
		for (int i = idx; i < chickens.size(); i++) {
			if(visit[i]) continue;
			sel[k]=i;
			visit[i]=true;
			com(i,k+1);
			visit[i]=false;
		}
	}
	
	private static int calc(Loc loc1, Loc loc2) {
		return Math.abs(loc1.r - loc2.r)+Math.abs(loc1.c-loc2.c);
	}
	
}
