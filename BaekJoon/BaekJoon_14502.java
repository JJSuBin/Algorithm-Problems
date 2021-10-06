import java.util.*;

public class BaekJoon_14502 {
	static int[][] map; // 입력받은 맵 저장 배열
	static int[][] temp; // 배열 복사 
	static int n,m,answer=0;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		map=new int[n][m];
		temp=new int[n][m];
		
		// 연구소 정보 입력받기
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(answer);
	}
	
	// 안전 영역 크키를 count 하는 함수
	public static int safecount() {
		/*
		 * 한 동작(3개의 벽을 설치하고, 바이러스가 퍼진 동작)이 끝난후
		 * 해당 연구소의 상태를 저장하고 있는 배열은 temp 배열이다. 
		 * 따라서 temp의 0의 개수를 세는 것이 안전 영역의 크기를 구하는 것이다. 
		 */
		int result=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(temp[i][j]==0)
					result++;
			}
		}
		return result;
	}
	
	// 벽 3개를 설치하는 함수
	public static void dfs(int fance) {
		// 벽 3개를 설치했다면
		if(fance==3) {
			/*
			 * 벽이 3개가 설치된 후 아래 동작을 마치고 return 되면
			 * map의 정보는 다시 복원되기 떄문에 해당 지점에서 맵을 복사하여 바이러스를 퍼뜨려야 한다.
			 * 
			 * 이 지점에서 map은 안전영역 3곳에 벽이 설치된 상태이고
			 * temp는 아래 과정을 통해 바이러스가 전파되고 난 뒤의 상태가 저장된다. 
			 */
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					temp[i][j]=map[i][j];
				}
			}
			
			// 바이러스 전파 
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(temp[i][j]==2)
						virus(i,j);
				}
			}
			
			/*
			 * 인전 영역 3곳에 벽을 세운 뒤 바이러스가 퍼진 후
			 * 각 경우마다 안전 영역의 개수를 count 한다. 
			 * 
			 * 이때 어느 지점에 벽을 세운 경우가 가장 많은 안전 영역을
			 * 갖고있는지 그 최댓값을 구한다.
			 */
			answer=Math.max(answer,safecount());
			return;
		}
		
		// 안전영역(0인 지점) 중 3곳에 벽을 세운다.
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1; // 벽 설치
					fance+=1; // 벽 개수 증가
					dfs(fance); // 재귀호출
					
					// 재귀호출이 끝난다면 벽의 개수와, 맵을 상태를 되돌린다. 
					map[i][j]=0; 
					fance-=1;
				}
			}
		}
	}
	
	// 바이러스가 퍼지는 함수
	public static void virus(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx<n&&ny<m&&nx>=0&&ny>=0) {
				if(temp[nx][ny]==0) {
					temp[nx][ny]=2;
					virus(nx,ny);
				}
			}
		}
	}
}
