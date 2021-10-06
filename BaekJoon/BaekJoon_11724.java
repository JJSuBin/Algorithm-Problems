import java.util.*;

public class BaekJoon_11724 {
	public static int[][] graph;
	public static int n,m,count=0;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		graph=new int[n+1][n+1];
		visited=new boolean[n+1];
		
		// 간선 연결상태 저장
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph[a][b]=graph[b][a]=1;
		}
		
		// 방문 배열을 탐색하면서 방문하지 않은 정점이 있다면 탐색 후 연결요소 1증가
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int index) {
		visited[index]=true; // 방문처리
		
		// 간선이 연결되어 있고, 방문하지 않았다면 dfs() 호출
		for(int i=1;i<=n;i++) {
			if(graph[index][i]==1&&visited[i]==false)
				dfs(i);
		}
	}
}
