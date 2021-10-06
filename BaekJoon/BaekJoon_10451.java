import java.util.*;

public class BaekJoon_10451 {
	static boolean[] visited;
	static int count=0;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int n=sc.nextInt();
			visited=new boolean[n+1];
			graph=new ArrayList<ArrayList<Integer>>();
			count=0;
			
			// 노드 개수만큼 생성
			for(int i=0;i<=n;i++) 
				graph.add(new ArrayList<Integer>());
			
			// 연결 상태 저장
			for(int i=1;i<=n;i++) {
				int a=sc.nextInt();
				
				// 양방향 그래프
				graph.get(i).add(a);
				graph.get(a).add(i);
			}
			
			for(int i=1;i<=n;i++) {
				if(visited[i]==false) {
					visited[i]=true; // 방문처리
					dfs(i);
					count++; // 
				}
			}
			System.out.println(count);
		}
	}
	
	// DFS 알고리즘을 사용하여 하나의 사이클 찾기
	static void dfs(int start) {
		visited[start]=true; // 방문처리
		
		// start 노드와 연결된 모든 노드 탐색
		for(int i=0;i<graph.get(start).size();i++) {
			// start 노드와 연결된 노드이면서, 방문하지 않았다면 재귀호출
			if(visited[graph.get(start).get(i)]==false)
				dfs(graph.get(start).get(i));
		}
	}
}
