import java.util.*;

class tomato {
	int x;
	int y;
	
	public tomato(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_7576 {
	public static int n,m;
	public static int[][] board;
	public static int[] dx= {-1,1,0,0}; // 상,하,좌,우 
	public static int[] dy= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt(); // 가로
		n=sc.nextInt(); // 세로
		board=new int[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				board[i][j]=sc.nextInt();
		
		/*
		 * bfs의 시작 인덱스는 주어지지 않는다. 
		 * 이번 문제는 익은 토마토 지점으로부터 4방향을 탐색해야하기 때문에
		 * 아래 bfs() 함수에서 익은 토마토 좌표를 큐에 삽입하는 과정을 수행한다.
		 */
		bfs();
	}
	public static void bfs() {
		Queue<tomato> q=new LinkedList<>();
		
		// 익은 토마토의 좌표를 큐에 삽입한다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j]==1)
					q.add(new tomato(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			tomato node=q.poll();
			
			// 익은 토마로를 기점으로 상,하,좌,우 4방향을 탐색한다.
			for(int i=0;i<4;i++) {
				int nx=node.x+dx[i]; // 다음 위치
				int ny=node.y+dy[i];
				
				// 범위르 벗어났으면 탐색x
				if(nx>=n||ny>=m||nx<0||ny<0)
					continue;
				// 다음 위치의 토마토가 익지 않은 토마토가 아니라면 탐색x
				if(board[nx][ny]!=0)
					continue;
				
				// 총 일수를 구해야하기 때문에 현재 일수 +1을 해준다.
				board[nx][ny]=board[node.x][node.y]+1;
				q.offer(new tomato(nx,ny)); // 새로운 익은 토마토 위치 큐에 삽입
			}
		}
		
		// 최대 일수 구하기
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				// 토마토가 모두 익지 못한 상황이라면 -1 return 
				if(board[i][j]==0) {
					System.out.println(-1);
					return;
				}
				// 일수를 갱신한 board에서 최댓값 찾기
				max=Math.max(max, board[i][j]);
			}
		}
		// 최대 일수는 최댓값 -1이 된다.
		System.out.println(max-1);
	}
}
