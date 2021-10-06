import java.util.*;

class Position_16234 {
	int x;
	int y;
	
	public Position_16234(int x, int y) {
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_16234 {
	static int n,l,r,totalsec=0;
	static int[][] graph,unions;
	public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		l=sc.nextInt();
		r=sc.nextInt();
		
		graph=new int[n][n];
		unions=new int[n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				graph[i][j]=sc.nextInt();
		
		while(true) {
			// 모든 나라의 연합 번호를 -1로 초기화
			for(int i=0;i<n;i++) 
				for(int j=0;j<n;j++) 
					unions[i][j]=-1;
			
			int index=0; // 연합 번호 시작
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					// 연합 번호가 -1이라는건 아직 해당 나라가 처리되지 않았다는 의미
					if(unions[i][j]==-1) {
						bfs(i,j,index);
						// bfs가 끝나면 연합 번호 +1 증가
						index++; 
					}
				}
			}
			
			/*
			 * 이번 문제는 인구 이동이 총 며칠 동안 이루어졌는지를 구하는 문제이다.
			 * 즉, 모든 국가가 더이상 인구 이동이 불가능한,모두 각각의 연합 번호를 갖고 있을때 종료된다.
			 * 연합 국가는 0부터 시작해서 n-1까지 부여되지만 bfs가 끝나고 index++가 실행되기 때문에
			 * 최종적으로 연합번호(index)가 n이 된다. 
			 */
			if(index==n*n)
				break;
			
			/*
			 * while문은 첫 번째 배열을 기점으로 배열 마지막 국가까지 
			 * 가능한 모든 인구 이동이 이뤄지는데 하루가 소요된다.
			 * 즉, 이러한 while문이 한번 실행될 때 마다 하루가 소요되는 것과 같기 때문에 여기서 소요 일을 +1 해주어야 한다.  
			 */
			totalsec++;
		}
		
		System.out.println(totalsec);
	}
	
	public static void bfs(int x, int y, int index) {
		// 연합된 나라의 x, y 좌표를 저장하는 연결리스트
		ArrayList<Position_16234> united=new ArrayList<>();
		united.add(new Position_16234(x,y)); // 현재 나라를 추가
		
		// BFS를 위한 큐 선언
		Queue<Position_16234> q=new LinkedList<>();
		q.offer(new Position_16234(x,y)); // 현재 위치 삽입
		unions[x][y]=index; // 현재 연합의 번호 할당
		
		int count=1; // 연합된 국가의 수
		int summary=graph[x][y]; // 현재 연합의 전체 인구수
		while(!q.isEmpty()) {
			Position_16234 position=q.poll();
			x=position.x;
			y=position.y;
			
			// 상,하,좌,우 탐색
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				// 이동한 좌표가 범위 내에 있으며 해당 국가가 어떤 연합에도 속해있지 않고,
				if(nx>=0&&ny>=0&&nx<n&&ny<n&&unions[nx][ny]==-1) {
					// 인구 차가 l명 이상 r명 이라하면
					int gab=Math.abs(graph[x][y]-graph[nx][ny]);
					if(gab>=l&&gab<=r) {
						q.offer(new Position_16234(nx,ny)); // 다음 탐색 위해 큐에 삽입
						united.add(new Position_16234(nx,ny)); // 연합 국가에 추가
						unions[nx][ny]=index; // 같은 연합 번호 부여
						count++; // 연합 국가의 개수 증가
						summary+=graph[nx][ny]; // 인구수 누적
					}
				}
			}
		}
		
		// 연합 국가끼리 인구 분배
		for(int i=0;i<united.size();i++) 
			graph[united.get(i).x][united.get(i).y]=summary/count;
	}
}
