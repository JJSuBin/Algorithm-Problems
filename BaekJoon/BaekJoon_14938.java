import java.util.*;

public class BaekJoon_14938 {
	static int[][] graph;
	static int[] item;
	static int n,m,r;
	static final int INF=(int)1e9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		r=sc.nextInt();
		
		// 그래프 초기화
		graph=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					graph[i][j]=0;
				else 
					graph[i][j]=INF;				
			}
		}
		
		// 아이템 정보 입력받기
		item=new int[n+1];
		for(int i=1;i<=n;i++)
			item[i]=sc.nextInt();
		
		// 연결 상태 입력받기
		for(int i=0;i<r;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			// 양방향 
			graph[a][b]=graph[b][a]=c;
		}
		
		// 플로이드 워셜 알고리즘 수행
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		int max=0,sum;
		// 낙하하는 지역이 1~n 일때 각각 검사
		for(int i=1;i<=n;i++) { 
			sum=0; // 얻을 수 있는 아이템
			/*
			 * 낙하한 지점으로부터 거리가 m 이내이고, 갈 수 있는 지점이라면
			 * 해당 지점의 아이템을 얻을 수 있기 때문에 j 지역 아이템 누적 
			 */
			for(int j=1;j<=n;j++) { 
				if(graph[i][j]<=m&&graph[i][j]!=INF)
					sum+=item[j];
			}
			max=Math.max(max, sum); // 얻을 수 있는 아이템의 최댓값 구하기
		}
		
		System.out.println(max);
	}

}
