import java.util.*;

public class BaekJoon_2667 {
	public static boolean[][] visited; // 방문 여부 체크 배열
	public static int[][] graph;
	public static int n,count=0; // 단지내의 집 개수 저장 변수
	public static ArrayList<Integer> result=new ArrayList<>();
	
	/*
	 * 상,하,좌,우 이동할 때 x, y값 변화 저장 함수
	 * for문을 사용하여 4방향 이동 경우를 탐색할 수 있다.  
	 */
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt(); 
		
		visited=new boolean[n][n];
		graph=new int[n][n];
		
		// 단지 정보 저장
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<n;j++) {
				graph[i][j]=str.charAt(j)-'0';
			}
		}
		
		// 지도 전체를 탐색
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				/* 
				 * 탐색하고자 하는 좌표에 집이 있고, 탐색하지 않았다면 
				 * 해당 좌표로부터 상,하,좌,우를 탐색하는 dfs() 함수를 호출한다.
				 * 
				 * dfs()의 return 값은 해당 단지의 아파트의 개수이기 때문에
				 * count 값을 result 리스트에 저장한다.
				 */
				if(graph[i][j]==1&&visited[i][j]==false) {
					count=1; // 시작하는 집을 포함해야하기 때문에 1로 초기화
					dfs(i,j);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result); // 정렬
		System.out.println(result.size()); // 단지 개수 출력
		
		// 각 단지에 포함된 아파트의 개수 출력
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
	}
	
	public static int dfs(int x,int y) {
		visited[x][y]=true;
		
		// 한 지점에서의 4방향(상,하,좌,우)을 탐색한다.
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 이동한 좌표의 값이 1이고, 방문하지 않았다면 재귀호출
			if(nx>=0&&ny>=0&&nx<n&&ny<n) {
				if(graph[nx][ny]==1&&visited[nx][ny]==false) {
					dfs(nx,ny);
					count++; // 아파트의 개수만큼 count
				}
			}
		}
		return count;
	}
}
