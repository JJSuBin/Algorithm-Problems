import java.util.*;

class Position_2206 {
	public int x;
	public int y;
	public int distance;
	public int drill; // 공사 횟수
	
	public Position_2206(int x, int y, int distance, int drill) {
		this.x=x;
		this.y=y;
		this.distance=distance;
		this.drill=drill; 
	}
}

public class BaekJoon_2206 {
	public static int[][] map,visited;
	public static int[] dx= {0,0,-1,1};
	public static int[] dy= {-1,1,0,0};
	public static int n,m,answer=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		map=new int[n][m];
		visited=new int[n][m]; // 해당 좌표의 공사 횟수를 저장하는 배열
		
		for(int i=0;i<n;i++) {
			String str=sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=str.charAt(j)-'0';
				visited[i][j]=Integer.MAX_VALUE;
			}
		}
		
		bfs(0,0);

		if(answer==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	public static void bfs(int x,int y) {
		Queue<Position_2206> q=new LinkedList<>();
		
		q.offer(new Position_2206(x,y,1,0)); // 시작 지점을 포함한 거리 1로 시작
		visited[x][y]=0; // 처음 공사 횟수
		
		while(!q.isEmpty()) {
			Position_2206 position=q.poll();
			
			// 도착지점을 만났다면 이동 거리를 저장하고 종료
			if(position.y==m-1&&position.x==n-1) {
				answer=position.distance;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx=dx[i]+position.x;
				int ny=dy[i]+position.y;
				
				// 범위를 벗어난다면 넘어간다.
				if(ny>=m||nx>=n||nx<0||ny<0)
					continue;
				
				// 이동한 좌표의 공사 횟수가 기존에 갖고있던 값보다 작을 경우 넘어간다.
				if(visited[nx][ny]<=position.drill)
					continue;
				
				if(map[nx][ny]==0) { // 벽이 아닐 경우
					visited[nx][ny]=position.drill; // 부순 횟수 유지
					// 이동한 좌표와, 이동 거리를 1 증가한 값을 큐에 삽입한다.
					q.add(new Position_2206(nx,ny,position.distance+1,position.drill));
				}
				else { // 벽일 경우
					if(position.drill==0) { // 지금까지 벽을 부순 횟수가 0일 경우
						visited[nx][ny]=position.drill+1; // 부순 횟수를 1 높여주고
						// 이동한 좌표와, 거리와 부순 횟수를 1씩 증가한 값을 큐에 삽입한다.
						q.add(new Position_2206(nx,ny,position.distance+1,position.drill+1));
					}
				}
				
			}
		}
	}
}
