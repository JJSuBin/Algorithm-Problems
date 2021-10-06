import java.util.*;

public class BaekJoon_18243 {
	static int n,k;
	static final int INF=(int)1e9;
	static int[][] graph;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		
		graph=new int[n+1][n+1];
		
		// 그래프 초기화
		for(int i=0;i<=n;i++)
			Arrays.fill(graph[i],INF);
		
		// 이어져 있는 노드는 거리를 1로 변경
		for(int i=0;i<k;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			// 양방향
			graph[a][b]=graph[b][a]=1;
		}
		
		// 플로이드 워셜 알고리즘
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
		
		// 결과 출력
		if(network()==true)
			System.out.println("Small World!");
		else
			System.out.println("Big World!");
	}
	
	/*
	 * 플로이드 워셜 알고리즘을 통해 각 배열에는 다른 노드로 가는 최소 비용이 저장되어 있다.
	 * 이때 배열의 값이 6이 넘어 Small World 조건을 만족하지 않는 경우와,
	 * 자기 자신으로 가는(i==j) 경우가 아닌데 배열의 값이 INF라면 
	 * 모든 네트워크는 연결되어 있지 않은 상태이기 때문에 Small World가 될 수 없다.
	 */
	static boolean network() {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if((graph[i][j]==INF&&i!=j)||graph[i][j]>6) {
					return false;
				}
			}
		}
		return true;
	}
}
