import java.util.*;

public class BaekJoon_11055 {
	static int n;
	static int[] a,dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n];
		dp=new int[n]; // 각 원소의 가장 큰 증가 부분 수열의 합
		
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			dp[i]=a[i]; // 수열의 시작은 자기 자신이기 때문에 자기 자신의 값으로 초기화
			// 자신보다 왼쪽에 있는 값 탐색
			for(int j=0;j<i;j++) {
				// 자신보다 값이 작다면 dp값 갱신
				if(a[i]>a[j])
					/*
					 * 자신의 증가 부분 수열의 합과
					 * 원소 j의 증가 부분 수열의 합에 자기 자신의 배열 값을 더한 값 중
					 * 큰 값으로 갱신한다.
					 */
					dp[i]=Math.max(dp[i],dp[j]+a[i]);
			}
		}
		
		// 수열의 합이 가장 큰 값 찾기
		int max=-1;
		for(int i=0;i<n;i++)
			max=Math.max(max, dp[i]);
		
		System.out.println(max);
	}

}
