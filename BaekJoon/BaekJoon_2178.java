import java.util.*;
/*
 * BFS를 사용하여 해결하는 것이 효과적이다.
 * BFS는 시작 지점에서 가까운 노드부터 차례대로 탐색하기 떄문에 
 * 움직여야 하는 최소 칸의 개수를 구하는 목적에 알맞다. 
 */
class Node_2178 {
	private int x;
	private int y;
	
	public Node_2178(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class BaekJoon_2178 {
	/*
	 * 상,하,좌,우 이동할 때 x, y값 변화 저장 함수
	 * for문을 사용하여 4방향 이동 경우를 탐색할 수 있다.  
	 */
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int[][] maze;
	public static int n,m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		maze=new int[n][m];
		
		// 미로 상태 입력받기
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<m;j++) {
				maze[i][j]=str.charAt(j)-'0';
			}
		}
		System.out.println(bfs(0,0));
	}
	
	public static int bfs(int x, int y) {
		Queue<Node_2178> q=new LinkedList<>();
		q.offer(new Node_2178(x,y));
		
		while(!q.isEmpty()) {
			Node_2178 node=q.poll();
			x=node.getX();
			y=node.getY();
			
			// 현재 위치에서 4가지 방향으로의 위치 확인
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				// 미로 찾기 공간을 벗어난 경우 무시
				if(nx>=n||ny>=m||nx<=-1||ny<=-1)
					continue;
				// 벽인 경우 무시
				if(maze[nx][ny]==0)
					continue;
				/*
				 * 해당 노드를 처음 방문하는 경우에만 최단 거리 기록
				 * 미로를 지나오면서 각 위치마다 이전 이동 거리을 더해오면서 
				 * 최종 이동 거리를 구한다
				 */ 
				if(maze[nx][ny]==1) {
					maze[nx][ny]=maze[x][y]+1;
					q.offer(new Node_2178(nx,ny));
				}
			}
		}
		return maze[n-1][m-1];
	}
}
