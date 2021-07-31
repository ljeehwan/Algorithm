import java.util.*;
class Solution {
    static int max;
    static int []dx = {-1,0,1,0};
    static int []dy = {0,1,0,-1};
    static boolean [][]visit;
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][m];
        int cnt = 0;
        max = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(picture[i][j] > 0 && visit[i][j] == false){
                    cnt++;
                    bfs(m,n,picture,i,j);
                }
            }
        }
   
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }
    public static void bfs(int M, int N, int [][]pic, int r, int c){
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(r,c));
        visit[r][c] = true;
        int val = pic[r][c];
        int count = 0;
        while(!queue.isEmpty()){
            Data dt = queue.poll();
            int nx = 0;
            int ny = 0;
            count++;
            for(int i = 0 ; i < 4 ; i++){
                nx = dt.r + dx[i];
                ny = dt.c + dy[i];
                
                if(nx >= 0 && nx < M && ny >= 0 && ny < N  && visit[nx][ny] != true && pic[nx][ny] == val){
                    visit[nx][ny] = true;
                    queue.offer(new Data(nx, ny));       
                }
            }
        }
        if(count > max){
            max = count;
        }
    }
}
class Data{
    int r;
    int c;
    public Data(int r, int c){
        this.r = r;
        this.c = c;
    }
}