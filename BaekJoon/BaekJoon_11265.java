import java.util.*;

public class BaekJoon_11265 {
	static int[][] graph;
	static int n,m;
	static final int INF=(int)1e9;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		graph=new int[n+1][n+1];
		
		/*
		 * 자신이 자신에게로 가는 경로는 0으로 초기화
		 * 외의 지점은 최댓값으로 초기화 
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j)
					graph[i][j]=0;
				else 
					graph[i][j]=INF;
			}	
		}
		
		// 값 입력 받기
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				graph[i][j]=sc.nextInt();
		
		// 플로이드 워셜 알고리즘을 사용하여 최단경로로 갱신
		for(int k=1;k<=n;k++) 
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			// 시간 내에 도착할 수 있는 경우
			if(graph[a][b]<=c)
				System.out.println("Enjoy other party");
			// 시간 내에 도착할 수 없는 경우
			else 
				System.out.println("Stay here");
		}
	}
}
