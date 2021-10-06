import java.util.*;

public class BaekJoon_1719 {
	static int[][] graph, station;
	static int n,m;
	static final int INF=(int)1e9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		graph=new int[n+1][n+1];
		station=new int[n+1][n+1];
		
		// 그래프 초기화
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(i==j) 
					graph[i][j]=0;
		
				else 
					graph[i][j]=INF;
			}
		}
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			graph[a][b]=graph[b][a]=c; // 양방향
			
			// 출발 집하장 저장
			station[a][b]=b;
			station[b][a]=a;
		}
		
		// 플로이드 워셜 알고리즘
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					// k 집하장을 거치는 경로가 빠르다면 최단경로 갱신
					if(graph[i][j]>graph[i][k]+graph[k][j]) {
						graph[i][j]=graph[i][k]+graph[k][j];
						
						// 최단 경로가 갱신되는 경우에만 출발 집하장을 변경한다.
						station[i][j]=station[i][k];
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					System.out.print('-'+" ");
				else
					System.out.print(station[i][j]+" ");
			}
			System.out.println();
		}
	}

}
