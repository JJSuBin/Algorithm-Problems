import java.util.*;

public class BaekJoon_11404 {
	public static final int INF=(int)1e9;
	public static int n,m;
	public static int[][] graph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		graph=new int[n+1][n+1];
		
		// 최단 거리 테이블을 모두 무한으로 초기화
		for(int i=0;i<=n;i++)
			Arrays.fill(graph[i], INF);
		
		// 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) graph[i][j]=0;
			}
		}
		
		// 인접 행렬 입력
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			graph[a][b]=Math.min(graph[a][b],c);
		}
		
		// 플로이드 워셜 알고리즘 수행
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					graph[j][k]=Math.min(graph[j][k], graph[j][i]+graph[i][k]);
				}
			}
		}
		
		// 출력
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				// INF 값은 0으로 처리
				if(graph[i][j]==INF) 
					graph[i][j]=0;
				
				sb.append(graph[i][j]).append(" ");
				}
			sb.append("\n");
			}
		System.out.println(sb.toString());
		}
	}
