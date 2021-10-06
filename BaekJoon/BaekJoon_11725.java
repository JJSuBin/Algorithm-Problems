import java.util.*;

public class BaekJoon_11725 {
	static int[] parents;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		parents=new int[n+1];
		visited=new boolean[n+1];
		
		// 연결리스트에 n개의 노드 추가
		for(int i=0;i<=n;i++)
			graph.add(new ArrayList<Integer>());
		
		// 간선 연결 상태 저장
		for(int i=0;i<n-1;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		// 방문처리가 되지 않은 노드는 dfs 함수 실행
		for(int i=1;i<=n;i++) {
			if(visited[i]==false)
				dfs(i);
		}
		
		// 2번 노드부터 부모 노드 출력
		for(int i=2;i<=n;i++)
			System.out.println(parents[i]);
	}
	
	public static void dfs(int v) {
		/*
		 * v 노드가 이미 방문했던 노드라면
		 * 해당 노드는 트리의 가장 밑에 있는 노드이기 때문에 재귀함수를 끝낸다.
		 */
		if(visited[v]) 
			return;
		
		visited[v]=true; // 방문처리
		// v 노드와 연결되어 있는 노드 탐색
		for(int i=0;i<graph.get(v).size();i++) {
			// 방문하지 않은 노드라는 것은 아직 부모노드를 구하지 못한 노드라는 의미
			if(!visited[graph.get(v).get(i)]) {
				// v 노드의 다음 노드는 v 노드를 부모로 갖는다. 
				parents[graph.get(v).get(i)]=v;
				dfs(graph.get(v).get(i)); // v 노드의 다음 노드로 재귀호출 
			}
		}
	}
}
