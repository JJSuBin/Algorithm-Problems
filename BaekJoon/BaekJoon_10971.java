import java.util.*;

public class BaekJoon_10971 {
	static int[][] map;
	static int n,min=Integer.MAX_VALUE;
	static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		visited=new boolean[n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				map[i][j]=sc.nextInt();
		
		// 시작점을 바꿔가며 순회
		for(int i=0;i<n;i++)
			dfs(i,i,0,0);
		
		System.out.println(min);
	}
	
	// 백트래킹
	static void dfs(int start, int now, int depth, int cost) {
		// 모든 도시를 순회했고, 다시 시작점으로 돌아왔다면 최솟값 갱신
		if(depth==n&&start==now) {
			min=Math.min(cost, min);
			return;
		}
		
		// 순회할 도시 탐색
		for(int i=0;i<n;i++) {
			// i번째 도시와 이어져있지 않다면 넘어간다.(자기 자신 포함)
			if(map[now][i]==0)
				continue;
			
			// 현재 도시를 방문하지 않았고, 다음 순회할 i번째 도시와 연결되어 있다면
			if(visited[now]==false&&map[now][i]>0) {
				visited[now]=true; // 현재 도시 방문처리
				cost+=map[now][i]; // 비용 증가
				dfs(start,i,depth+1,cost); // now를 i번째 도시로 갱신하고, 깊이를 1 증가시킨다.
				// 다음 탐색을 위해 초기화
				visited[now]=false;
				cost-=map[now][i];
			}
		}
	}
}
