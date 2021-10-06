import java.util.*;

/*
 * 알고리즘
 * 왼쪽에서 오른쪽으로 진행하는 부분수열과 오른쪽에서 왼쪽으로 진행하는 부분수열을 합쳐
 * 오름차순과 내림차순이 합쳐진 수열을 완성한다. 
 * 이때 결과 값은 원소 1개씩이 중복되어 있기 때문에 -1을 해줘야 한다.
 */
public class BaekJoon_11054 {
	public static int n;
	public static int[] num;
	public static int[] r_dp;
	public static int[] l_dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		num=new int[n];
		r_dp=new int[n];
		l_dp=new int[n];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		LIS(); LDS();
		
		int max=0;
		for(int i=0;i<n;i++) {
			if(max<l_dp[i]+r_dp[i])
				max=l_dp[i]+r_dp[i];
		}
		
		System.out.println(max-1);
	}
	
	// 왼쪽에서 오른쪽으로 진행하는 부분수열 찾기
	public static void LIS() {
		for(int i=0;i<n;i++) {
			l_dp[i]=1; // 자신을 포함한 최소한의 수열 1로 초기화
			
			// 이전 원소들 탐색
			for(int j=0;j<i;j++) {
				// 자신보다 이전의 원소가 작으면서 i번째 dp가 j번째 dp+1 값보다 작은 경우
				if(num[i]>num[j]&&l_dp[i]<l_dp[j]+1)
					l_dp[i]=l_dp[j]+1;
			}
		}
	}
	
	// 오른쪽에서 왼쪽으로 진행하는 부분수열 찾기
	public static void LDS() {
		// 맨 뒤부터 시작
		for(int i=n-1;i>=0;i--) {
			r_dp[i]=1; // 자신을 포함한 최소한의 수열 1로 초기화
			
			// 이전 원소들 탐색
			for(int j=n-1;j>i;j--) {
				// 자신보다 이전의 원소가 작으면서 i번째 dp가 j번째 dp+1 값보다 작은 경우
				if(num[i]>num[j]&&r_dp[i]<r_dp[j]+1)
					r_dp[i]=r_dp[j]+1;
			}
		}
	}
}
