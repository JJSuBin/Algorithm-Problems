import java.util.*;

public class BaekJoon_2422 {
	static boolean[][] graph;
	static int n,m,count=0;
	static boolean[] visited;
	static int[] icecream=new int[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		visited=new boolean[n+1];
		graph=new boolean[n+1][n+1];
		
		// 섞으면 안 되는 조합의 배열 값을 true로 변경한다.  
		for(int i=0;i<m;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph[a][b]=graph[b][a]=true;
		}
		
		dfs(0,1);
		System.out.println(count);
	}
	
	public static void dfs(int depth,int start) {
		/*
		 * 3개의 아이스크림을 골랐다면 3개의 맛 중 2개씩 선택하여
		 * 섞으면 안되는 조합에 해당하는지 체크한다.
		 */
		if(depth==3) {
			for(int i=0;i<3;i++) {
				for(int j=i+1;j<3;j++) {
					// graph 값이 true라면 섞으면 안되는 조합
					if(graph[icecream[i]][icecream[j]])
						return;
				}
			}
			// 섞으면 안되는 조합에 해당하지 않는다면 해당 경우의수 count
			count++;
			return;
		}
		
		/*
		 * n개의 아이스크림 중 3개를 중복 없이 골라야 하기 때문에 
		 * i의 시작점을 늘려가며 백트래킹을 해야한다.  
		 * i를 다시 1부터 시작하게 되면 (1,2,3)과 같은 경우의 수인 (2,3,1), (3,2,1)등이 고려되기 떄문이다.
		 */
		for(int i=start;i<=n;i++) {
			if(visited[i]==false) {
				visited[i]=true;
				icecream[depth]=i;
				dfs(depth+1,i+1);
				visited[i]=false;
			}
		}
	}
}
