import java.util.*;

/*
 * 알고리즘
 * 철거되어야 할 전선의 최소 개수라 하면, 
 * 거꾸로 전체 전선의 개수에서 최대한 겹치지 않게 설치 가능한 개수를 구하여 빼면,
 * 즉, (전체 전선 개수 - 설치 가능 개수) = 철거 개수가 된다.
 * 따라서 최대한 설치 가능한 개수를 구해야 한다.
 */
public class BeakJoon_2565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] wire=new int[n][2];
		int[] dp=new int[n];
		
		for(int i=0;i<n;i++) {
			wire[i][0]=sc.nextInt();
			wire[i][1]=sc.nextInt();
		}
		
		// A 전봇대를 기준으로 정렬
		Arrays.sort(wire, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		/*
		 * LIS(부분수열) 문제
		 * i번째 전봇대를 기준으로 이전의 전봇대들의 전선을 연결하기 위한 탐색
		 * 즉, i번째 전봇대에 연결된 B전봇대는
		 * 탐색할 j번째 전봇대에 연결된 B전봇대보다 값이 커야함 
		 */
		for(int i=0;i<dp.length;i++) {
			dp[i]=1;
			
			for(int j=0;j<i;j++) {
				if(wire[i][1]>wire[j][1]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max=0;
		for(int i=0;i<n;i++) {
			max = Math.max(max, dp[i]);
		}
		
		// 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수 
		System.out.println(n-max);
	}
}
