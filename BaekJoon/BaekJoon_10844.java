import java.util.*;

public class BaekJoon_10844 {
	public static int n;
	public static long[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dp=new long[n+1][10];
		long sum=0;
		
		// 입력받은 n에 대하여 각 끝 자리수 마다 나올 수 있는 개수를 모두 더한다.
		for(int i=1;i<=9;i++)
			sum+=easystair(n,i);
		
		System.out.println(sum%1000000000);
	}
	
	/*
	 * n이 늘어날수록 직전 n의 계단 수에 영향을 받는다. 
	 * 길이가 n이고 끝자리가 k인 계단수의 개수를 dp[n][k]라고 한다면
	 * dp[n][k] = 길이가 n-1이고 끝자리가 k-1 + 길이가 n-1이고 끝자리가 k+1 
	 * 즉, d[n][k] = d[n-1][k-1] + d[n-1][k+1]이다.
	 * 단, 끝자리가 9인 경우에는 8밖에 선택할 수 없고, 
	 * 끝자리가 0인 경우에는 1 선택할 수 없는 경우는 따로 처리해줘야 한다. 
	 */
	public static long easystair(int n, int k) {
		if(dp[n][k]==0) {
			// 자릿수가 1인 경우는 모든 개수가 1
			if(n==1)
				return 1;
			// 끝자리가 0인 경우는 1만 선택 가능
			if(k==0)
				dp[n][k]=easystair(n-1,1);
			// 끝자리가 9인 경우는 8만 선택 가능
			else if(k==9)
				dp[n][k]=easystair(n-1,8);
			else
				dp[n][k]=easystair(n-1,k-1)+easystair(n-1,k+1);
		}
		return dp[n][k]%1000000000;
	}
}
