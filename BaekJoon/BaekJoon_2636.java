import java.io.*;
import java.util.*;

class Cheese_2636 {
	int x;
	int y;
	
	public Cheese_2636(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_2636 {
	public static int n,m,totalcheese,count,time;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		
		// 맵 정보 입력 받기
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if (map[i][j]==1)
					totalcheese++;
			}
		}
		
		while(totalcheese!=0) {
			time++;
			/*
			 * 치즈가 모두 없어지기 1시간 전의 개수를 구해야하므로
			 * 마지막 bfs 함수가 수행되기 전의 전체 치즈의 개수를 저장해줘야 한다. 
			 */
			count=totalcheese;
			bfs();
		}
		
		System.out.println(time);
		System.out.println(count);
	}

	public static void bfs() {
		Queue<Cheese_2636> que = new LinkedList<>();
		que.offer(new Cheese_2636(0,0));
		visited=new boolean[n][m];
		visited[0][0]=true; // (0,0)부터 시작
		
		while (!que.isEmpty()) {
			Cheese_2636 ch=que.poll();
			
			// 상,하,좌,우 탐색
			for(int i=0;i<4;i++) {
				int nx=ch.x+dx[i];
				int ny=ch.y+dy[i];
				
				// 이동 좌표가 범위를 벗어나거나 방문한 좌표라면 넘어간다.
				if (nx<0||nx>=n||ny<0||ny>=m||visited[nx][ny]) 
					continue;
				
				// 이동한 좌표에 치즈가 있다면
				if(map[nx][ny]==1) {
					totalcheese--; // 전체 치즈개수에서 1 감소
					map[nx][ny]=0; // 치즈 제거
				} 
				/*
				 * 치즈는 공기와 맞닿은 부분이 제거되야 한다.
				 * 따라서 이동한 좌표가 공기라면 큐에 넣고 상,하,좌,우를 탐색해주고,
				 * 그 중 치즈가 있다면 없어져야하는 치즈이기 때문에 위의 코드를 실행해준다.
				 */
				else if(map[nx][ny]==0) {
					que.offer(new Cheese_2636(nx,ny));
				}
				visited[nx][ny]=true; // 방문처리
			}
		}
	}
}
