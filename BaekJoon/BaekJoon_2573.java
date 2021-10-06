import java.util.*;

class Point_2573 {
	int x,y;
	
	public Point_2573(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class BaekJoon_2573 {
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int[][] iceberg;
	static int n,m,year=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		iceberg=new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				iceberg[i][j]=sc.nextInt();
		
		// 빙하가 두 덩어리 이상으로 분리될 때 까지 반복
		while(separate()<2) {
			// 한 번에 모든 빙하가 녹은 경우
			if(separate()==0) {
				year=0;
				break;
			}
			
			// bfs 함수를 실행시켜 빙하를 녹이고 년수 +1
			bfs();
			year+=1;
		}
		
		System.out.println(year);
	}
	
	// 빙산이 분리된 개수를 구하는 함수
	static int separate() {
		boolean[][] visited=new boolean[n][m];
		int count=0;
		
		// 방문하지 않았으며, 빙산의 높이가 0이 아니라면 dfs 호출
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(iceberg[i][j]!=0&&!visited[i][j]) {
					dfs(i,j,visited);
					// dfs가 1번 수행될 때 마다 빙산의 덩어리가 1씩 증가
					count++;
				}
			}
		}
		
		return count;
	}
		
	// 빙하의 개수를 세는 함수
	static void dfs(int x, int y, boolean[][] visited) {
		visited[x][y]=true;
		
		// 빙하의 상,하,좌,우 탐색하여 빙하 방문처리 
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 배열의 범위를 벗어났거나 이미 방문한 곳이면 넘어간다.
			if(nx>=n||ny>=m||nx<0||ny<0||visited[nx][ny])
				continue;
			
			// 이동한 좌표가 빙하라면 재귀호출
			if(iceberg[nx][ny]!=0)
				dfs(nx,ny,visited);
		}
	}
	
	// 빙하를 녹이는 함수
	static void bfs() {
		Queue<Point_2573> q=new LinkedList<>();
		
		/*
		 * 주위의 바닷물에 의해 빙하가 녹아 배열 값이 0으로 변하게 되면 
		 * 같은 단계에 녹고있는 빙하에는 영향을 미치면 안된다. 
		 * 이를 위해 boolean 배열을 사용한다.
		 * 
		 * 처음에 빙하가 있는 자리의 배열 값을 true로 바꿔주어 원래 빙하였던 자리를 표시해둔다.
		 * 이후 주위의 바다의 개수를 셀 때 배열의 값이 false인 바다를 count 해주어야 한다.   
		 * 
		 */
		boolean[][] visited=new boolean[n][m];
		
		// 빙하인 자리 true로 변경, 큐에 삽입
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(iceberg[i][j]!=0) {
					visited[i][j]=true;
					q.offer(new Point_2573(i,j));
				}
			}
		}
		
		// 빙하의 좌표로부터 상,하,좌,우 탐색
		while(!q.isEmpty()) {
			Point_2573 point=q.poll();
			int x=point.x;
			int y=point.y;
			
			int sea=0; // 주위 바다 개수 count
			
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				// 배열의 범위를 벗어난 경우
				if(nx>=n||ny>=m||nx<0||ny<0)
					continue;
				
				// 빙하가 녹아 바다가 된 경우가 아닌 원래부터 바다인 경우 count
				if(iceberg[nx][ny]==0&&!visited[nx][ny])
					sea++;
			}
			
			// 빙하가 잠기게 되면 0으로 변경
			if(iceberg[x][y]-sea<0)
				iceberg[x][y]=0;
			// 잠긴만큼 빙하의 높이 줄이기
			else
				iceberg[x][y]-=sea;
		}
	}
}
