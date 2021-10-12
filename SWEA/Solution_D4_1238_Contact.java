package com.ssafy.algo;


import java.util.*;

public class Solution_D4_1238_Contact{
	
	public static int MAXN=100;
	public static int[][] contact;
	public static int[] visit;
	public static int max;
	
	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);
		int T=10;//sc.nextInt();

		for(int tc=1; tc<=T; tc++){
	        int L=sc.nextInt(); //length 데이터 길이
	        int S=sc.nextInt();  //start 시작번호 (당번)
	        contact=new int[MAXN+1][MAXN+1]; //from ---> to
	        visit=new int[MAXN+1]; //방문여부
	        
	        for(int i=0; i<L/2; i++){
	            int f=sc.nextInt();//f: from
	            int t=sc.nextInt();//t: to
	            contact[f][t]=1;
	        }
	        
	        Queue<Integer> queue=new LinkedList<>();
	        
	        visit[S]=1;
	        queue.offer(S);
	        while(!queue.isEmpty()){
	        	max=0;
	        	int size=queue.size();
	        	for(int k=0; k<size; k++){
	                int i=queue.poll();
	                if(max<i) max=i;
		            
	                for(int j=1; j<=MAXN; j++){
	                    if(contact[i][j]==1 && visit[j]==0){
	                        visit[j]=1;
	                        queue.offer(j);
	                    }
	                }
	        	}
	        }
	        
			System.out.println("#"+tc+" "+max);
		}
		sc.close();
	}
}
