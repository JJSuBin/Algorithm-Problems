import java.util.*;

public class BaekJoon_21278 {
	static int n,m;
	static final int INF=(int)1e9;
	static int[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		map=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					continue;
				
				map[i][j]=INF;
			}
		}
		
		// 간선 정보 입력 받기
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			map[a][b]=map[b][a]=1;
		}
		
		// 플로이드 와샬 알고리즘
		for(int k=1;k<=n;k++) 
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
	
		int point1=Integer.MAX_VALUE;
		int point2=Integer.MAX_VALUE;
		int min=Integer.MAX_VALUE;
		
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				// 2개의 지점을 치킨집으로 선정
				int dis=distance(i,j);
				// 더 작은 값을 찾으면 치킨집 장소와 최솟값 갱신
				if(min>dis) {
					point1=i;
					point2=j;
					min=dis;
				}
			}
		}
		
		// 왕복 거리이기 때문에 min*2 한 값을 출력
		System.out.println(point1+" "+point2+" "+min*2);
	}
	
	/*
	 * 모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합을 구하는 문제이기 때문에
	 * 두 치킨집 중 더 가까운 치킨집까지의 거리를 구해 return 한다. 
	 */
	static int distance(int x, int y) {
		int result=0;
		for(int i=1;i<=n;i++)
			result+=Math.min(map[x][i],map[y][i]);
		
		return result;
	}
}
