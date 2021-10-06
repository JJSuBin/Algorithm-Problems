import java.util.*;

public class BaekJoon_2644 {
	static int n,m,start,end,result=-1;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		visited=new boolean[n+1];
		
		for(int i=0;i<=n;i++)
			graph.add(new ArrayList<Integer>());
		
		start=sc.nextInt();
		end=sc.nextInt();
		m=sc.nextInt();
		
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			// 양방향
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(start, end, 0);
		System.out.println(result);
	}
	
	/*
	 * dfs 함수의 매개변수로 촌수를 세는 count가 있어야 한다.
	 * 그렇지 않고 전역변수로 선언한 변수를 증가시키면서 촌수를 count하게 되면
	 * 시작 노드로부터 end 노드까지 도달하는 과정에서 탐색한 모든 노드의 개수를 세게 된다.
	 *  
	 * 알고자하는 것은 start 노드에서 end 노드로 가는 길에 들르는 노드의 개수이기 때문에
	 * 조건을 만족할 때 전역변수에 count를 덮어쓰기 해야한다.
	 */
	public static void dfs(int start, int end, int count) {
		// end 노드에 도착했다면 촌수 덮어쓰기
		if(start==end) {
			result=count;
			return;
		}
		
		visited[start]=true; // 방문처리
		// 시작 번호로부터 연결되어 있는 노드 확인
		for(int i=0;i<graph.get(start).size();i++) {
			int next=graph.get(start).get(i);
			// 방문하지 않았던 노드라면 촌수를 +1하고, 해당 노드를 시작으로 재탐색한다. 
			if(!visited[next]) {
				dfs(next,end,count+1);
			}
		}
	}
}
