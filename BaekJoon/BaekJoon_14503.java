import java.util.*;

public class BaekJoon_14503 {
	static int[][] map;
	static int n,m,x,y,d,count=1; // 첫 지점은 반드시 청소하기 때문에 count는 1부터 시작
	static int[] dx= {-1,0,1,0}; // 북,동,남,서
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		x=sc.nextInt();
		y=sc.nextInt();
		d=sc.nextInt();
		
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		dfs(x,y,d);
		System.out.println(count);
	}
	
	public static void dfs(int r, int c, int dir) {
		map[r][c]=2; // 청소
		
		// 4방향 탐색
		for(int i=0;i<4;i++) {
			dir=(dir+3)%4; // 왼쪽 방향으로 회전
			int nx=r+dx[dir]; // 회전하여 이동한 좌표 계산
			int ny=c+dy[dir];
			
			// 이동한 좌표가 범위 내에 있고, 아직 청소하지 않았다면 
			if(map[nx][ny]==0&&nx>=0&&ny>=0&&nx<n&&ny<m) {
				count++; // 청소 구역 개수 count
				dfs(nx,ny,dir); // 새 좌표와 방향으로 재귀호출
				/*
				 * 일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산한다.
				 * 하지만 해당 문제는 후진할 때만 이전 길을 되돌아가 재탐색 할 수 있으므로
				 * return을 해서 다시 되돌아 와도 더 이상 움직일 수 없게 만들어준다.
				 */
				return;
			}
		}
		
		// 위의 반복문을 빠져 나왔다는 것은 주변에 더 이상 청소할 공간이 없다는 의미
		int back=(dir+2)%4; // 후진할 방향 계산
		int nx=r+dx[back];
		int ny=c+dy[back];
		// 후진한 좌표가 범위 내에 있고, 벽이 아니라면 
		if(map[nx][ny]!=1&&nx>=0&&ny>=0&&nx<n&&ny<m)
			dfs(nx,ny,dir); // 새 좌표와, 이전 방향을 유지한채로 재귀호출
	}
	
}
