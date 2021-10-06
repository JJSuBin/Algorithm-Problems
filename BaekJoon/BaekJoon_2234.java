import java.util.*;

class Point_2234 {
	int x,y;
	
	public Point_2234(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_2234 {
	static int n,m,room_count=0,room_area=0,max=0;
	static int[][] map;
	static boolean[][] visited;
	// 서,북,동,남 순으로 탐색해야 함
	static int dx[]={0,-1,0,1};
    static int dy[]={-1,0,1,0};
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		map=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				map[i][j]=sc.nextInt();
		
		// 벽을 허물기 전 방의 개수, 가장 넓은 방의 넓이 구하기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j]) {
					// bfs가 한번 수행될 때 마다 방의 개수가 count 된다.
					room_area=Math.max(room_area, bfs(i,j));
					room_count++;
				}
			}
		}
		
		System.out.println(room_count);
		System.out.println(room_area);
		
		// 벽 허물기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				// 비스마스크를 1,2,4,8로 늘려가면서 서,북,동,남 순으로 벽을 허문다.
				for(int bit=1;bit<=8;bit<<=1) {
					/*
					 * 해당 좌표와 비트마스크의 &연산 값이 1이라면 bit 방향에 벽이 있다는 것이기 때문에
					 * 해당 방향의 벽을 허문 상태에서 방의 최대 넓이를 구한 후 다음 경우를 위해 값을 복구한다. 
					 */
					if((map[i][j]&bit)!=0) {
						visited=new boolean[n][m];
						map[i][j]-=bit; // 벽 허물기
						max=Math.max(max, bfs(i,j)); // 최대 방 넓기 구하기
						map[i][j]+=bit; // 벽 복구
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static int bfs(int x,int y) {
        // TODO Auto-generated method stub
        Queue<Point_2234> q=new LinkedList<>();
        q.add(new Point_2234(x,y));
        visited[x][y] = true;
        int count=1; // 방의 넚이는 시작 좌표도 세야하기 때문에 1부터 시작
        
        while(!q.isEmpty()) {
        	Point_2234 p=q.poll();
            int bit=1; // 해당 방향으로 벽이 있는지 탐색하기 위한 비트마스크
            
            // 서,북,동,남 순으로 탐색
            for(int d=0;d<4;d++) {
            	/*
            	 * 해당 좌표의 값과 비트마스크를 & 연산하면 
            	 * 서,북,동,남 방향에 벽이 있는지 알 수 있다. 
            	 * 
            	 * 연산 결과가 0이라면 벽이 없는 경우이기 때문에 이동 가능
            	 */
                if((map[p.x][p.y]&bit)==0) {
                    int nx=p.x+dx[d];
                    int ny=p.y+dy[d];
                   
                    // 이동한 좌표가 배열 범위 내에 있으며, 아직 방문하지 않았다면 
                    if(0<=ny&&ny<m&&0<=nx&&nx<n&&!visited[nx][ny]) {
                        count++; // 해당 방의 넓이 count
                        visited[nx][ny]=true; // 방문처리
                        q.add(new Point_2234(nx,ny));
                    }
                }
                bit<<=1; // 비트마스크는 1,2,4,8 로 늘려가며 서,북,동,남에 벽이 있는지 체크
            }
        }
        return count;
    }
}	
