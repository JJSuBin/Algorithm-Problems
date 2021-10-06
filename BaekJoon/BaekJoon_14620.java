import java.util.Scanner;

public class BaekJoon_14620 {
	static int[][] map;
	static boolean[][] visited;
	static int n,min=Integer.MAX_VALUE;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		visited=new boolean[n][n];
		
		// 각 화단의 비용 입력 받기
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[i][j]=sc.nextInt();
		
		dfs(0,0);
		System.out.println(min);
	}
	
	static void dfs(int depth, int sum) {
		// 3개의 꽃을 심었다면 최소 비용 갱신
		if(depth==3) {
			min=Math.min(min, sum);
			return;
		}
		
		// 모든 화단 탐색
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// i행 j열에 꽃을 심을 수 있다면
				if(isPossible(i,j)) {
					int temp=expense(i,j); // 비용 계산
					
					// 꽃을 심은 자리와 상,하,좌,우 방문처리
					visited[i][j]=true;
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						
						visited[nx][ny]=true;
					}
					
					dfs(depth+1,sum+temp); // 개수를 1 늘리고, 비용을 더한 후 재귀호출
					
					// 다음 경우의 수를 위해 값 초기화
					visited[i][j]=false;
					for(int k=0;k<4;k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						
						visited[nx][ny]=false;
					}
				}
			}
		}
	}
	
	// x행 y열에 꽃을 심을 수 있는지 판별하는 함수
	static boolean isPossible(int x, int y) {
		// 해당 자리가 이미 방문처리 되어있다면 false return
		if(visited[x][y]==true)
			return false;
		
		// 꽃이 피어나 꽃잎이 생길 수 있는지 확인
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 꽃잎이 배열의 범위를 벗어난다면 해당 자리에 꽃을 심을수 없음
			if(nx>=n||ny>=n||nx<0||ny<0)
				return false;
			
			// 꽃잎의 자리에 다른 꽃이 핀 경우도 꽃을 심을 수 없음
			if(visited[nx][ny])
				return false;
		}
		// 위의 경우가 아니라면 꽃을 심을 수 있음
		return true;
	}
	
	// x행 y열에 꽃을 심었다면 비용 계산
	static int expense(int x, int y) {
		int sum=map[x][y]; // 씨앗 자리 비용
		
		// 꽃잎 자리 비용 계산
		for(int k=0;k<4;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			
			sum+=map[nx][ny];
		}
		return sum;
	}
}
