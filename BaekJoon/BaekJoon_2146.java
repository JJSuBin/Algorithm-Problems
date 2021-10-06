import java.util.*;

class Point_2146 {
	int x,y,count;
	
	public Point_2146(int x, int y, int count) {
		this.x=x;
		this.y=y;
		this.count=count;
	}
}
public class BaekJoon_2146 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int[][] map;
	static int n,min=Integer.MAX_VALUE,landnum=2; 
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		visited=new boolean[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[i][j]=sc.nextInt();
		
		// 섬 번호 붙이기
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// 섬이 있는 곳이고, 아직 번호가 붙여지지 않은 곳이라면
				if(map[i][j]==1&&!visited[i][j]) {
					visited[i][j]=true; // 방문처리
					map[i][j]=landnum; // 시작 지점부터 번호 붙이기
					dfs(i,j);
					landnum++; // 한 개의 섬의 번호를 다 붙였다면 번호 증가
				}	
			}
		}
		
		// 배열의 각각의 칸에서 다른 섬까지로 가는 칸의 개수 count
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]>=2) {
					visited=new boolean[n][n]; // 각 경우의 수 마다 방문배열 초기화
					bfs(i,j);
				}
			}
		
		}
		System.out.println(min);	
	}	
	
	// 각 섬마다 번호를 붙이는 함수(섬 번호는 2부터 시작)
	static void dfs(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 배열 범위 내이면서 아직 방문하지 않은 곳이고,
			if((nx<n&&ny<n&&nx>=0&&ny>=0)&&!visited[nx][ny]) {
				// 섬이 있는 곳이라면 번호 붙이기
				if(map[nx][ny]==1) {
					visited[nx][ny]=true;
					map[nx][ny]=landnum;
					dfs(nx,ny);
				}
			}
		}
	}
	
	// 다리 짓기
	static void bfs(int r, int c) {
        Queue<Point_2146> queue=new LinkedList<>();
        queue.offer(new Point_2146(r,c,0));
        int curr=map[r][c];// 현재 섬 번호
        visited[r][c]=true;
        
        while (!queue.isEmpty()) {
        	Point_2146 p=queue.poll();
        	
            for (int i=0;i<4;i++) {
                int r2=p.x+dx[i];
                int c2=p.y+dy[i];
                
                // 배열 범위 내에 있으면서 아직 방문하지 않은 곳이고
                if ((r2>=0&&r2<n&&c2>=0&&c2<n)&&!visited[r2][c2]) { 
                	// 현재 섬 번호와 다른 곳이라면
                	if(map[r2][c2]!=curr) {
                		visited[r2][c2]=true; // 방문처리
                		
                        if (map[r2][c2]==0) // 바다라면 다리 갯수를 1개 늘리고 새로운 좌표 큐에 삽입
                            queue.offer(new Point_2146(r2,c2,p.count+1));
                        else // 다른 섬을 만났다면 다리 갯수의 최솟값 갱신
                            min=Math.min(min,p.count);           
                	}
                }
            }
        }
    }
}
