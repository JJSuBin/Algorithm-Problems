import java.util.*;

class position {
	public int x;
	public int y;
	
	public position(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class BaekJoon_7562 {
	// 나이트가 이동할 수 있는 경우의 수
	public static int[] dx = {-2,-1,2,1,2,1,-2,-1};
    public static int[] dy = {1,2,1,2,-1,-2,-1,-2};
	public static int[][] board;
	public static boolean[][] visited;
	public static int n,count,start_x,start_y,end_x,end_y;
	public static Queue<position> q=new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			n=sc.nextInt();
			board=new int[n][n];
			visited=new boolean[n][n];
			
			start_x=sc.nextInt();
			start_y=sc.nextInt();
			end_x=sc.nextInt();
			end_y=sc.nextInt();
			
			bfs(start_x,start_y);
			System.out.println(board[end_x][end_y]);
		}
	}
	public static void bfs(int start_x, int start_y) {
		// 시작 위치랑 도착 위치랑 같아지면 함수 종료
		if(start_x==end_x&&start_y==end_y)
			return;
		
		visited[start_x][start_y]=true;
		q.add(new position(start_x,start_y));
		
		while(!q.isEmpty()) {
			position p=q.poll();
			int x=p.x;
			int y=p.y;
			
			// 나이트가 이동할 수 있는 경우의 수 탐색
			for(int i=0;i<8;i++) {
				// 이동 좌표
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				// 이동 좌표가 범위를 벗어나면 넘어간다.
				if(nx>=n||ny>=n||nx<0||ny<0)
					continue;
				
				// 이미 방문했던 좌표라면 넘어간다.
				if(visited[nx][ny]==true)
					continue;
				
				/*
				 * 이동한 좌표가 범위 내에 있고 방문하지 않았다면
				 * 해당 위치를 큐에 삽입하고 방문처리를 해준다.
				 * 이동 횟수는 이전 이동 횟수에 1씩 증가시켜가며 구한다.
				 */
				q.add(new position(nx,ny));
				visited[nx][ny]=true;
				board[nx][ny]=board[x][y]+1;
			}
		}
	}
}
