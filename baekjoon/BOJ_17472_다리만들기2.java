package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
 * 섬마다 번호 붙이기.(bfs)
 * 섬에서 만들 수 있는 다리를 모두 만들어 우선순위큐에 넣기.
 * 최소간선의 합.(크루스칼)
 *  
 */
public class BOJ_17472_다리만들기2 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int islandCnt = 1;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result;
	static int []parents;
	static int bridgeCnt = 0;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 각 섬에 번호 부여하기.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] != true) {
					islandCnt++;
					makeIslandNumber(new Locate(i, j));
				}
			}
		}
		// 섬마다 다리 연결하기.
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					makeBridge(new Locate(i, j));
				}
			}
		}

		// 크루스칼.
		// pq의 간선만큼 반복하면서 사이클을 확인하며 최소 간선의 합 구하기.

		parents = new int[islandCnt + 1];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		int size = pq.size();
		for (int i = 0; i < size; i++) {
			Edge tmp = pq.poll();

			int a = find(tmp.start_isd);
			int b = find(tmp.end_isd);

			if (a == b)
				continue;

			union(tmp.start_isd, tmp.end_isd);
			result += tmp.v;
			bridgeCnt++;
		}

		if (result == 0 || bridgeCnt != islandCnt - 2) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

    public static int find(int a) {
        if(a == parents[a]) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }
    
    public static void union(int s,int e) {
        int aRoot = find(s);
        int bRoot = find(e);
        
        if(aRoot != bRoot) {
            parents[aRoot] = e;
        } else {
            return;
        }
    }
	// 섬에 번호메기기.
	public static void makeIslandNumber(Locate lc) {
		Queue<Locate> q = new LinkedList<>();

		visited[lc.x][lc.y] = true;
		map[lc.x][lc.y] = islandCnt;

		q.offer(lc);
		while (!q.isEmpty()) {
			Locate d = q.poll();
			int nx = 0;
			int ny = 0;
			for (int i = 0; i < 4; i++) {
				nx = d.x + dx[i];
				ny = d.y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1 && visited[nx][ny] != true) {
					visited[nx][ny] = true;
					map[nx][ny] = islandCnt;
					q.offer(new Locate(nx, ny));
				}
			}
		}
	}

	public static void makeBridge(Locate lc) {
		int curX = lc.x;
		int curY = lc.y;
		int len = 0;
		int curNum = map[curX][curY];
		for (int i = 0; i < 4; i++) {
			int nx = curX;
			int ny = curY;
			while (true) {
				nx = nx + dx[i];
				ny = ny + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == curNum) {
						len = 0;
						break;
					} else if (map[nx][ny] == 0) {
						len++;
					} else {
						if (len > 1) {
							pq.offer(new Edge(curNum, map[nx][ny], len));
						}
						len = 0;
						break;
					}
				} else {
					len = 0;
					break;
				}
			}
		}
	}

}

class Locate {
	int x;
	int y;

	public Locate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
	int start_isd;
	int end_isd;
	int v;

	public Edge(int s, int e, int v) {
		this.start_isd = s;
		this.end_isd = e;
		this.v = v;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return o.v >= this.v ? -1 : 1;
	}
}