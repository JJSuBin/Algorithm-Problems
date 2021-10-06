import java.util.*;

public class BaekJoon_2606 {
	public static boolean[] visited; // 노드 방문 여부 체크
	public static int[][] graph;
	public static int e,v,count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		e=sc.nextInt(); // 컴퓨터(노드)의 개수
		v=sc.nextInt(); // 간선의 개수
		visited=new boolean[e+1];
		graph=new int[e+1][e+1];
		
		// 간선 연결상태 저장
		for(int i=1;i<=v;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph[a][b]=graph[b][a]=1;
		}
		
		dfs(1);
		System.out.println(count);
	}
	
	// 깊이 우선 탐색
	public static void dfs(int x) {
		visited[x]=true; // 방문처리
		
		/*
		 * 노드 x와 연결되어 있고, 방문하지 않은 노드라면 재귀호출
		 * 재귀호출을 통해 노드 x와 연결되어 있는 노드를 방문하면서
		 * 감염되는 컴퓨터의 개수를 count 
		 */
		for(int i=1;i<=e;i++) {
			if(graph[x][i]==1&&visited[i]==false) {
				dfs(i);
				count++;
			}
		}
		
	}
}
