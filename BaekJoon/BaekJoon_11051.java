import java.util.*;

public class BaekJoon_11051 {
	public static int n,k,div=10007;
	public static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		dp=new int[n+1][k+1];
		
		System.out.println(func(n,k));
	}
	
	public static int func(int n, int k) {
		if(dp[n][k]>0)
			return dp[n][k];
		/*
		 * 이상 계수의 성질 사용
		 * nC0 = nCn =1 
		 */
		if(n==k||k==0)
			return dp[n][k]=1;
		/*
		 * 파스칼의 정리 사용
		 * nCr = n-1Ck-1 + n-1Ck 
		 */
		return dp[n][k]=(func(n-1,k-1)+func(n-1,k))%div;
	}
}
