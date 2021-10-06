import java.util.*;

public class BaekJoon_1012 {
	public static boolean[][] visited; // 방문여부 체크 배열
	public static int[][] map;
	public static int n,m,k,count=0;
	
	/*
	 * 상,하,좌,우 이동할 때 x, y값 변화 저장 함수
	 * for문을 사용하여 4방향 이동 경우를 탐색할 수 있다.  
	 */
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			n=sc.nextInt(); // 배추밭 가로길이
			m=sc.nextInt(); // 배추밭 세로길이
			k=sc.nextInt(); // 배추 개수
			map=new int[n][m];
			visited=new boolean[n][m];
			
			// 배추가 심어져 있는 곳 체크
			for(int i=0;i<k;i++) {
				map[sc.nextInt()][sc.nextInt()]=1;
			}
			
			count=0; // 배추 흰지렁이 개수 초기화
			
			// 지도 전체를 탐색
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					/* 
					 * 탐색하고자 하는 좌표에 배추가 있고, 탐색하지 않았다면 
					 * 해당 좌표로부터 상,하,좌,우를 탐색하는 dfs() 함수를 호출한다.
					 * 
					 * dfs() 함수는 위의 조건을 만족하는 지점으로부터 4방향을 탐색하며
					 * 주위에 배추가 심어져있는 장소를 모두 방문처리한다. 
					 * 이어져있는 배추의 영역이 끝나면 count를 1 증가시켜주고 인덱스를 증가시켜가며
					 * 다시 좌표의 값이 1이고, 방문처리하지 않은 배열을 찾는다.
					 */
					if(map[i][j]==1&&visited[i][j]==false) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y]=true;
		
		// 한 지점에서의 4방향(상,하,좌,우)을 탐색한다.
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 이동한 좌표의 값이 1이고, 방문하지 않았다면 재귀호출
			if(nx>=0&&ny>=0&&nx<n&&ny<m) {
				if(map[nx][ny]==1&&visited[nx][ny]==false) {
						dfs(nx,ny);
				}
			}
		}
	}
}
