import java.util.*;

class Position_2589 {
	int x;
	int y;
	int distance;
	
	public Position_2589(int x, int y, int distance) {
		this.x=x;
		this.y=y;
		this.distance=distance;
	}
}

public class BaekJoon_2589 {
	public static boolean[][] visited;
	public static char[][] map;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new char[n][m];
		visited=new boolean[n][m];
		
		// 지도 정보 저장
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		int answer=0;
		/*
		 * 각 위치에서의 이동 가능한 가장 먼 지점을 찾아주면 된다.
		 * 따라서 각 위치마다 방문 체크 배열은 초기화를 시켜주어야 하며
		 * bfs 함수를 호출하여 return한 값의 최댓값을 찾아준다. 
		 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]=='L') {
					visited=new boolean[n][m];
					int val=bfs(i,j);
					answer=Math.max(answer, val);
					}
				}
			}
		
		System.out.println(answer);
	}
	
	public static int bfs(int x, int y) {
		Queue<Position_2589> q=new LinkedList<>();
		visited[x][y]=true;
		int result=0;
		q.offer(new Position_2589(x,y,0));
		
		while(!q.isEmpty()) {
			Position_2589 position=q.poll();
			
			// 상,하,좌,우 이동
			for(int i=0;i<4;i++) {
				int nx=position.x+dx[i];
				int ny=position.y+dy[i];
				
				// 이동한 좌표가 범위 내에 있으며
				if(nx<n&&ny<m&&nx>=0&&ny>=0) {
					/*
					 *  방문하지 않았고, 육지라면 
					 *  해당 좌표를 방문처리 하고, 거리를 1 증가시킨 뒤 큐에 삽입한다.
					 */
					if(visited[nx][ny]==false&&map[nx][ny]=='L') {
						visited[nx][ny]=true;
						q.offer(new Position_2589(nx,ny,position.distance+1));
						result=Math.max(result,position.distance+1); 
					}
				}
			}
		} 
		// 이동 가능한 좌표 중 가장 먼 거리를 return
		return result;
	}
}
