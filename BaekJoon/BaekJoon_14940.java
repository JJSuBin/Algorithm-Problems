import java.util.*;

class Point_14940 {
	int x,y;
	
	public Point_14940(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_14940 {
	static StringBuilder sb=new StringBuilder();
	static int[][] map;
	static int n,m,endx,endy;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		map=new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				
				if(map[i][j]==2) {
					endx=i;
					endy=j;
				}
			}	
		}
		
		bfs();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				/*
				 * 도착 지점의 배열 2 값으로 시작하면서 배열의 값을 늘려줬기 때문에 
				 * 갈 수 없는 땅의 위치인 0을 제외한 배열 값은 초기 값인 2를 빼준 값을 출력해야 한다.   
				 */
				if(map[i][j]>0)
					sb.append(map[i][j]-2+" ");
				// 갈 수 없는 땅인 곳은 0으로 출력
				else
					sb.append(0+" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void bfs() {
		Queue<Point_14940> q=new LinkedList<>();
		q.offer(new Point_14940(endx,endy)); // 시작지점 큐에 삽입
		map[endx][endy]=2; // 시작지점 
		
		while(!q.isEmpty()) {
			Point_14940 point=q.poll();
			int x=point.x;
			int y=point.y;

			// 상,하,좌,우 탐색
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				// 범위를 벗어나거나 갈 수 없는 땅인 경우 넘어간다.
				if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]==0)
					continue;
				
				// 갈 수 있는 땅이라면 이전 배열의 값에 +1한 값으로 배열 값 갱신
				if(map[nx][ny]==1) {
					map[nx][ny]=map[x][y]+1;
					q.offer(new Point_14940(nx,ny));
				}
			}
		}
 	}
}
