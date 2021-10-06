import java.util.*;

class Point_16236 {
	int x,y;
	
	public Point_16236(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_16236 {
	static int[][] map;
	static int n,now_x,now_y,now_size=2,result=0,ate=0;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				
				// 초기 상어 위치 저장
				if(map[i][j]==9) {
					now_x=i;
					now_y=j;
					
					// 이후 상어가 있던 자리도 이동할 수 있는 자리이기 때문에 0으로 초기화
					map[i][j]=0;
				}
			}
		}
		
		while(true) {
			int[] info=find_fish(dfs());
			
			now_x=info[0]; // 상어 위치 갱신
			now_y=info[1];
			result+=info[2]; // 상어가 이동한 시간 누적
			
			map[now_x][now_y]=0; // 상어가 먹은 곳 비우기
			ate+=1; // 먹은 물고기의 수 증가
			
			// 자신의 현재 크기 이상으로 먹은 경우 상어 크기 증가
			if(ate==now_size) {
				now_size+=1;
				ate=0;
			}
		}
	}
	
	// 모든 위치까지의 '최단거리'만을 구하는 함수
	static int[][] dfs() {
		/*
		 * 상어를 기준으로 모든 위치까지의 최단거리를 구해야 하기 때문에
		 * 상어가 이동할 때 마다 각 위치의 최단거리가 달라진다. 
		 * 따라서 매번 최단거리 배열은 초기화를 해주고 사용해야 한다.  
		 */
		int[][] distance=new int[n][n]; 
		
		// -1로 초기화, 최단거리를 구한 후 값이 -1이라면 이동할 수 없는 위치
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				distance[i][j]=-1;
			
		Queue<Point_16236> q=new LinkedList<>();
		q.offer(new Point_16236(now_x,now_y));
		distance[now_x][now_y]=0; // 초기화
		
		while(!q.isEmpty()) {
			Point_16236 p=q.poll();
			int x=p.x;
			int y=p.y;
			
			// 상,하,좌,우 탐색
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				// 배열 범위 내에 있으며
				if(nx>=0&&ny>=0&&nx<n&&ny<n) {
					/*
					 * 해당 좌표의 물고기의 크기가 현재 상어 크기보다 작거나 같고, 
					 * 아직 최단거리를 구하지 않은 위치라면 이동가능
					 */
					if(map[nx][ny]<=now_size&&distance[nx][ny]==-1) {
						distance[nx][ny]=distance[x][y]+1; 
						q.offer(new Point_16236(nx,ny));
					}
				}
			}
		}
		return distance; // 최단거리 테이블 return 
	}
	
	// 먹을 물고기의 위치를 찾는 함수
	static int[] find_fish(int[][] dis) {
		int x=0,y=0; // 상어가 이동할 위치
		int min_dis=Integer.MAX_VALUE; // 해당 위치까지 이동하기 위한 최단거리
		
		/*
		 * 최단거리 테이블을 사용하여 상어의 주변중 이동할 수 있으며, 
		 * 물고기의 크기가 현재 상어의 크기보다 작고, 물고기가 1마리 이상 있는 곳 중 가장 가까운 곳을 찾는다. 
		 */
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(dis[i][j]!=-1&&map[i][j]<now_size&&map[i][j]>=1) {
					if(dis[i][j]<min_dis) {
						x=i;
						y=j;
						min_dis=dis[i][j];
					}
				}
			}
		}
		
		// 최단거리가 갱신되지 않았다면 더이상 먹을 수 있는 물고기가 없다는 의미, 엄마상어 호출
		if(min_dis==Integer.MAX_VALUE) {
			System.out.println(result); // 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간 출력
			System.exit(0); // 프로그램 종료
		}
		
		int[] point=new int[3];
		point[0]=x; // 다음 상어의 x 좌표
		point[1]=y; // 다음 상어의 y 좌표
		point[2]=min_dis; // 상어가 움직인 거리
		
		return point;
	}
}
