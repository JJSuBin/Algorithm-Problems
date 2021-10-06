import java.util.*;

public class BaekJoon_10026 {
	public static int n;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int people=0, patient=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new char[n][n];
		visited=new boolean[n][n];
		
		// 그림 정보 입력받기
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<n;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		// 그림을 탐색하며 방문하지 않았다면 dfs 호출
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j]==false) {
					dfs(i,j);
					people++; // 구역의 개수 count
				}
			}
		}
		
		// 적록색약인 경우를 위해 초기화
		visited=new boolean[n][n];
		// 그림의 빨간색 부분을 초록색으로 바꿔준다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]=='R')
					map[i][j]='G';
			}
		}
		// 그림을 탐색하며 방문하지 않았다면 dfs 호출
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j]==false) {
					dfs(i,j);
					patient++; // 구역의 개수 count
				}
			}
		}
		
		System.out.println(people+" "+patient);
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true; // 방문처리
		
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			/* 
			 * 이동좌표가 구역 내에 있고, 방문하지 않았으며
			 * 이전 좌표의 색과 동일할 경우 재귀호출
			 */
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(map[nx][ny]==map[x][y]&&visited[nx][ny]==false) {
					dfs(nx,ny);
				}
			}
		}
	}
}
