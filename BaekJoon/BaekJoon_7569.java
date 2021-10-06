import java.util.*;

class Tomato {
	int x; // 세로
	int y; // 가로 
	int z; // 높이
	
	public Tomato(int z, int x, int y) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}
public class BaekJoon_7569 {
	public static int[][][] board;
	public static int n,m,h;
	public static int dx[] = {-1, 0, 1, 0, 0, 0}; // 상,하,좌,우,위,아래
	public static int dy[] = {0, 1, 0, -1, 0, 0};
	public static int dz[] = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt(); // 가로
		n=sc.nextInt(); // 세로
		h=sc.nextInt(); // 높이
		board=new int[h][n][m];
		
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					board[k][i][j]=sc.nextInt();
				}
			}
		}

		/*
		 * bfs의 시작 인덱스는 주어지지 않는다. 
		 * 이번 문제는 익은 토마토 지점으로부터 6방향을 탐색해야하기 때문에
		 * 아래 bfs() 함수에서 익은 토마토 좌표를 큐에 삽입하는 과정을 수행한다.
		 */
		bfs();
	}
	public static void bfs() {
		Queue<Tomato> q=new LinkedList<>();
		
		// 익은 토마토의 좌표를 큐에 삽입한다.
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(board[k][i][j]==1)
						q.offer(new Tomato(k,i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Tomato tomato=q.poll();
			int x=tomato.x;
			int y=tomato.y;
			int z=tomato.z;
			
			// 익은 토마로를 기점으로 상,하,좌,우,위,아래 6방향을 탐색한다.
			for(int i=0;i<6;i++) {
				// 다음 위치 계산
				int nx=x+dx[i];
				int ny=y+dy[i];
				int nz=z+dz[i];
				
				// 범위를 벗어났으면 넘어간다.
				if(nx>=n||ny>=m||nz>=h||nx<0||ny<0||nz<0)
					continue;
				// 새로 계산한 위치에 익은 토마토가 없다면 넘어간다.
				if(board[nz][nx][ny]!=0)
					continue;
				
				// 총 일수를 구해야하기 때문에 현재 일수 +1을 해준다.
				board[nz][nx][ny]=board[z][x][y]+1;
				// 새로운 익은 토마토의 위치를 큐에 삽입한다.
				q.add(new Tomato(nz,nx,ny));
			}
		}
		
		// 최대 일수 구하기
		int max=Integer.MIN_VALUE;
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					// 토마토가 모두 익지 못한 상황이라면 -1 return 
					if(board[k][i][j]==0) {
						System.out.println(-1);
						return;
					}
					// 갱신한 board에서 최댓값 찾기
					max=Math.max(max, board[k][i][j]);
				}
			}
		}
		// 최대 일수는 최댓값 -1이 된다.
		System.out.println(max-1);
	}
}
