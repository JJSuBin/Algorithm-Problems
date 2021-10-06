import java.util.*;

public class BaekJoon_1987 {
	public static char[][] board;
	/*
	 * visited 배열은 해당 보드에 적혀있는 알파벳을
	 * 이전에 지나온 적이 있는지 체크하는 배열이다. 
	 */
	public static boolean[] visited=new boolean[26]; 
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int r,c,max=Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		board=new char[r][c];
		
		// 보드 정보 입력 받기
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				board[i][j]=str.charAt(j); 
			}
		}
		
		dfs(0,0,1);
		System.out.println(max);
	}
	
	// 백트래킹
	public static void dfs(int x, int y, int count) {
		visited[board[x][y]-'A']=true; // 방문처리
		
		// 이동할 수 있는 상,하,좌,우 탐색
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			/*
			 * 이동한 좌표가 범위 내에 있고 
			 * 이전에 지나온 칸에 적혀있는 알파벳이 아니라면 
			 * 이동한 칸의 개수를 +1해주고 재귀호출한다.
			 */
			if(nx<r&&nx>=0&&ny<c&&ny>=0) {
				if(visited[board[nx][ny]-'A']==false) {
					dfs(nx,ny,count+1);
				}
			}
		}
		
		// 재귀호출이 끝난다면 다음 탐색을 위해 값을 되돌려준다.
		visited[board[x][y]-'A']=false;
		max=Math.max(max, count); // 이동한 칸수 최댓값 갱신
	}
}
