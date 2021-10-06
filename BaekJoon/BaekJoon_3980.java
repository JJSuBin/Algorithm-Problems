import java.util.*;

public class BaekJoon_3980 {
	static int max;
	static boolean[] visited;
	static int[][] power;
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			// 케이스별로 반드시 초기화 해주어야 한다.
			power=new int[11][11];
			visited=new boolean[11];
			max=0;
			
			// 각 선수들의 포시션 별 능력 입력받기
			for(int i=0;i<11;i++) 
				for(int j=0;j<11;j++) 
					power[i][j]=sc.nextInt();
				
			dfs(0,0);
			System.out.println(max);
		}
	}
	
	static void dfs(int depth, int totalscore) {
		// 11명 선수들의 포시션을 모두 선정했다면 최댓값 갱신
		if(depth==11) {
			max=Math.max(totalscore, max);
			return;
		}
		
		// 백트래킹
		for(int i=0;i<11;i++) {
			/*
			 * 아직 선택되지 않은 포지션이고, 해당 포지션에서 선수의 능력이 0이 아니라면
			 * 해당 포시션을 선수에게 할당하고 능력치를 누적한다. 
			 */
			if(!visited[i]&&power[depth][i]!=0) {
				visited[i]=true; 
				dfs(depth+1,totalscore+power[depth][i]);
				visited[i]=false;
			}
		}
	}
}
