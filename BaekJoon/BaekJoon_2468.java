import java.util.*;

public class BaekJoon_2468 {
	static int[][] map,temp; 
	static boolean[][] visited;
	static int n,height=0,max=1;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		
		// 각 지역의 높이 입력 받기
		for(int i=0;i<n;i++) 
			for(int j=0;j<n;j++) 
				map[i][j]=sc.nextInt();
		
		// 비는 1이상 100이하로 내리기 때문에 모든 경우의 수 탐색
		for(int height=1;height<101;height++) {
			temp=new int[n][n]; // 비로 인해 지역이 잠긴 상태 저장 배열
			visited=new boolean[n][n]; // 방문 여부 체크
			int count=0; // 각 비의 높이마다 안전 영역 개수 저장 
			
			// 비가 내린 후 물에 잠겼다면 0, 잠기지 않았다면 1 저장(temp에 저장)
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]<=height)
						temp[i][j]=0;
					else
						temp[i][j]=1;
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// 방문하지 않은 지역이고, 잠기지 않은 지역이라면 영역 구하기
					if(visited[i][j]==false&&temp[i][j]==1) {
						dfs(i,j);
						count++; // 영역 개수 count
					}
				}
			}
			
			max=Math.max(max, count); // 최대 영역 개수 구하기
		}
		System.out.println(max);
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y]=true; // 방문처리
		
		// 상,하,좌,우 탐색
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 탐색 좌표가 영역을 벗어났거나 이미 방문했던 배열이면 넘어간다.
			if(nx>=n||ny>=n||nx<0||ny<0||visited[nx][ny])
				continue;
			
			// 탐색 좌표의 지역이 물에 잠겼다면 넘어간다.
			if(temp[nx][ny]==0)
				continue;
			
			/*
			 * 탐색 좌표에 있는 지역이 배열 범위 내에 있고, 방문하지 않았으며
			 * 물에 잠기지 않았다면 재귀호출하여 연결되어 있는 지역들을 방문처리한다. 
			 */
			dfs(nx,ny);
		}
	}
	
}
