import java.util.*;

public class BaekJoon_2583 {
	public static int n,m,k,count;
	public static int[][] map;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static ArrayList<Integer> result=new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		n=sc.nextInt();
		k=sc.nextInt();
		
		map=new int[m][n];
		
		// 입력받은 좌표로 직사각형 구해 해당 영역은 1로 표시
		for(int i=0;i<k;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
			
			for(int col=y1;col<y2;col++)
				for(int row=x1;row<x2;row++)
					map[col][row]=1;
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0) {
					count=1; // 해당 좌표를 포함해야하기 때문에 1로 초기화 
					dfs(i,j);
					result.add(count); // 영역의 넓이 리스트에 저장
				}
			}
		}
		
		// 리스트의 크기가 영역의 개수
		System.out.println(result.size());
		
		// 각 영역의 크기를 오름차순으로 출력
		Collections.sort(result); 
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}
	
	public static void dfs(int x, int y) {
		map[x][y]=1; // 방문처리
		
		// 상,하,좌,우 4방향 탐색
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			// 탐색하려는 좌표가 범위내에 있고, 직삭각형에 포함된 좌표가 아니라면 재귀호출
			if(nx>=0&&ny>=0&&nx<m&&ny<n) {
				if(map[nx][ny]==0) {
					dfs(nx,ny);
					count++; // 영역의 넓이 count
				}
			}
		}
	}
}
