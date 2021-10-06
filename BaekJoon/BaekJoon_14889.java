import java.util.Scanner;

public class BaekJoon_14889 {
	static int n;
	static int team[][]; // 점수표
	static boolean visit[]; // 방문 여부
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		team=new int[n][n];
		visit=new boolean[n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				team[i][j]=sc.nextInt();
		}
		dfs(0,0);
		System.out.println(min);	
	}
	// idx는 인덱스, count는 조합 개수(=재귀 깊이)
	public static void dfs(int idx, int depth) {
		// 팀 조합이 완성될 경우
		if(depth==n/2) {
			/*
			 방문한 팀과 방문하지 않은 팀을 각각 나누어
			 각 팀의 점수를 구한 뒤 최솟값을 찾는다.
			*/
			score();
			return;
		}
		
		for(int i=idx;i<n;i++) {
			if(!visit[i]) {
				/*
				 * 팀을 구성하는 방법
				 * 예를 들어 n이 4일 경우 진행하면, 처음에는 1번 사람이 true가 된다. 
				 * 이후 depth를 1 증가시킨후 재귀호출을 하면 이에 의해 다음에는 2번 사람이 true가 된다.
				 * 이때는 depth가 n/2와 같아지기 때문에 true인 1,2번이 스타트 팀, 3,4번이 링크팀이 된다.
				 * score() 함수를 호출하고 return 되면 2번 사람이 false로 바뀌고 for문에 의해 3번 사람이
				 * true 값을 가지게 된다. 이후에는 앞의 과정 반복...  
				 */
				visit[i]=true;
				dfs(i+1,depth+1);
				visit[i]=false;
			}
		}
	}
	
	// 두 팀의 능력치를 계산하는 함수
	public static void score() {
		int team_start=0;
		int team_link=0;
		
		/*대각선에는 능력치가 없기 때문에 i는 n-1까지
		 *(1,2)나 (2,1)은 같은 사람이 뽑힌 것이기 때문에 
		 *중복을 최소화 하기 위해 j의 조건은 i+1부터 시작해야 한다.
		 */  
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				// i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스 
				if(visit[i]==true&&visit[j]==true) {
					team_start+=team[i][j];
					team_start+=team[j][i];
				}
				else if(visit[i]==false&&visit[j]==false) {
					// i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스 
					team_link+=team[i][j];
					team_link+=team[j][i];
				}
			}
		}
		// 두 팀의 점수 차이 (절댓값)
		int result=Math.abs(team_start-team_link);
		
		/*
		 * 두 팀의 점수차가 0이라면 가장 낮은 최솟값이기 때문에
		 * 더이상의 탐색 필요없이 0을 출력하고 종료하면 된다.
		 */
		if(result==0) {
			System.out.println(result);
			System.exit(0);
		}
		min=Math.min(result,min);
	}
}
