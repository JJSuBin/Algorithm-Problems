import java.util.*;
/*
 * <조합공식 성질>
 * n+1Cr+1 = nCr + nCr+1
 * nC0 = nCn = 1
 *
 * <알고리즘>
 * 서로 다를 n개에서 r개를 뽑는 nCr 조합공식을 사용하여 푸는 문제이다.
 * 조합은 순서를 고려하지 않는다. 조합을 사용하면 다리가 교차하는 것을 신경쓰지 않아도 된다.
 * 예를 들어 (1,2,3,4,5)에서 (3,1,4)을 뽑았다고 하면 다리가 교차되지 않는(1,3,4)와 같은 경우이다.
 */
public class BaekJoon_1010 {
	public static int[][] dp=new int[30][30];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		
		while(testcase-->0) {
			int r=sc.nextInt();
			int n=sc.nextInt();
			
			sb.append(bridge(n,r)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int bridge(int n, int r) {
		if(dp[n][r]>0)
			return dp[n][r];
		
		// 조합공식 : nC0 = nCn = 1
		if(r==0||n==r)
			return dp[n][r]=1;
		
		// 조합공식 중 n+1Cr+1 = nCr + nCr+1에 n-1을 대입한 식
		return dp[n][r]=bridge(n-1,r-1)+bridge(n-1,r);
	}
}
