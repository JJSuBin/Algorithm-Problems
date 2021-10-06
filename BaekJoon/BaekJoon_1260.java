import java.util.*;

public class BaekJoon_1260 {
	public static boolean[] dfsvisited=new boolean[1001];
	public static boolean[] bfsvisited=new boolean[1001];
	public static int[][] graph=new int[1001][1001];
	public static int n,m,v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt(); // 노드 개수
		m=sc.nextInt(); // 간선 개수
		v=sc.nextInt(); // 시작점 
		
		// 간선 연결상태 저장
		for(int i=1;i<=m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			// 노드 a와 b는 연결되어 있다는 표시
			graph[a][b]=graph[b][a]=1;
		}
		
		DFS(v);
		System.out.println();
		BFS(v);
	}
	
	// 깊이 우선 탐색
	public static void DFS(int x) {
		dfsvisited[x]=true; // 방문처리
		System.out.print(x+" "); // 경로 출력
		
		// 현재 노드와 연결되어 있고, 방문하지 않은 노드가 있다면 재귀호출
		for(int i=1;i<=n;i++) {
			if(graph[x][i]==1&&dfsvisited[i]==false)
				DFS(i);
		}
	}
	
	// 너비 우선 탐색
	public static void BFS(int start) {
		Queue<Integer> queue=new LinkedList<Integer>(); // 큐 선언
		queue.offer(start); // 시작 노드 삽입
		bfsvisited[start]=true; //  방문처리
		
		while(!queue.isEmpty()) {
			int x=queue.poll(); 
			System.out.print(x+" "); // 경로 출력
			
			// 현재 노드와 연결되어 있고, 방문하지 않은 노드가 있다면 재귀호출
			for(int i=1;i<=n;i++) {
				if(graph[x][i]==1&&bfsvisited[i]==false) {
					queue.offer(i); // 큐에 노드 삽입
					bfsvisited[i]=true; // 방문처리
				}
			}
		}
	}
}
