import java.util.*;

class CCTV {
	int num,x,y;
	
	public CCTV(int num, int x, int y) {
		this.num=num;
		this.x=x;
		this.y=y;
	}
}

public class BaekJoon_15683 {
	static int[][] map,temp;
	static int[] output;
	static int n,m,result=Integer.MAX_VALUE;
	static ArrayList<CCTV> arr=new ArrayList<>();
	// CCTV는 시계방향으로 방향을 바꾸기 때문에 상,우,하,좌 순
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				
				// CCTV가 있는 좌표와 CCTV 번호 저장
				if(map[i][j]!=0&&map[i][j]!=6)
					arr.add(new CCTV(map[i][j],i,j));
			}
		}
		
		output=new int[arr.size()];
		choose_direction(0,arr.size());
		
		System.out.println(result);
	}
	
	/*
	 * 각 CCTV는 상,하,좌,우 4방향을 선택할 수 있다. 이런 CCTV가 여러개가 존재할 경우
	 * 각 CCTV가 바라볼 수 있는 방향의 조합마다 사각지대의 개수를 갱신해주어야 하기 때문에 
	 * 모든 CCTV가 바라볼 수 있는 방향의 조합을 DFS를 사용하여 구한다. 
	 * 
	 * 이때 1번 CCTV가 회전하면서 생기는 방향의 가지수는 4개, 2번 CCTV는 2개, 
	 * 3번, 4번 CCTV는 4개, 5번 CCTV는 1개이다. 
	 * 
	 * 예를들어 1번, 2번 cctv가 한개씩 설치되어 있다고 가정해보자.
	 * 총 나올 수 있는 방향의 가짓수는 4(1번)*2(2번)=8가지이다. 이 8가지를 모두 탐색해 사각지대의 개수를 갱신해주면 된다. 
	 */
	static void choose_direction(int depth, int num) {
		// 재귀의 깊이가 설치된 cctv의 개수와 같아졌다면
		if(depth==num) {
			// 배열 복사
			temp=new int[n][m];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					temp[i][j]=map[i][j];
			
			// cctv의 정보와 해당 cctv가 바라보고 있는 방향으로 cctv 작동
			for(int i=0;i<arr.size();i++)
				operate_CCTV(arr.get(i),output[i]);
			
			count_blind(); // 사각지대 개수 count
			
			return;
		}
		
		for(int i=0;i<4;i++) {
			/*
			 * 방향 저장
			 * 0:상, 1:좌, 2:하, 3:우 
			 */
			output[depth]=i; 
			choose_direction(depth+1,num);
		}
	}
	
	// cctv 번호와 바라보고 있는 방향으로 감시
	static void operate_CCTV(CCTV cctv, int dir) {
		int number=cctv.num;
		
		// 1번 cctv
		if(number==1) {
			if(dir==0) watch(cctv,0); // 상
			else if(dir==1) watch(cctv,1); // 우
			else if(dir==2) watch(cctv,2); // 좌
			else if(dir==3) watch(cctv,3); // 하
		}
		
		// 2번 cctv
		else if(number==2) {
			if(dir==0||dir==2) { // 상우
				watch(cctv,0);
				watch(cctv,2);
			}
			else { // 좌우
				watch(cctv,1);
				watch(cctv,3);
			}
		}
		
		// 3번 cctv
		else if(number==3) {
			if(dir==0) { // 상우
				watch(cctv,0);
				watch(cctv,1);
			}
			else if(dir==1){ // 우하
				watch(cctv,1);
				watch(cctv,2);
			}
			else if(dir==2){ // 하좌
				watch(cctv,2);
				watch(cctv,3);
			}
			else if(dir==3){ // 좌상
				watch(cctv,3);
				watch(cctv,0);
			}
		}
		
		// 3번 cctv
		else if(number==4) {
			if(dir==0) { // 좌상우
				watch(cctv,3);
				watch(cctv,0);
				watch(cctv,1);
			}
			else if(dir==1){ // 상우하
				watch(cctv,0);
				watch(cctv,1);
				watch(cctv,2);
			}
			else if(dir==2){ // 좌하우
				watch(cctv,1);
				watch(cctv,2);
				watch(cctv,3);
			}
			else if(dir==3){ // 상좌하
				watch(cctv,2);
				watch(cctv,3);
				watch(cctv,0);
			}
		}
		
		// 3번 cctv
		else { // 상우좌하
			watch(cctv,0);
			watch(cctv,1);
			watch(cctv,2);
			watch(cctv,3);
		}
	}
	
	// 해당 방향으로 cctv에 의해 감시되는 지역을 -1로 변환한다.
	public static void watch(CCTV cctv, int d) {
		Queue<CCTV> q=new LinkedList<>();
		q.add(cctv);
		
		while(!q.isEmpty()) {
			CCTV c=q.poll();
			int nx=c.x+dx[d];
			int ny=c.y+dy[d];

			// 범위를 벗어나거나 벽을 만나면 끝 
			if(nx<0||nx>=n||ny<0||ny>= m||temp[nx][ny]==6) 
				break;
			
			// 아직 감시되지 않은 지역이라면
			if(temp[nx][ny]==0) { 
				temp[nx][ny]=-1; // 감시됨을 표시
				q.add(new CCTV(cctv.num,nx,ny));
			} 
			
			/*
			 * 다른 cctv가 있거나 이미 다른 ccvt에 의해 감시가 된 칸이라도 
			 * 해당 칸을 넘어갈 수 있으므로 탐색을 위해 큐에 삽입
			 */
			else 
				q.add(new CCTV(cctv.num,nx,ny)); 
		}
	}
	
	// 사각지대의 개수를 count하는 함수
	static void count_blind() {
		int count=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(temp[i][j]==0)
					count++;
		
		result=Math.min(result, count);
	}
}
