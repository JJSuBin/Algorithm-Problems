import java.util.*;

public class BaekJoon_11727 {
	static Integer[] dp;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dp=new Integer[n+1];
		
		dp[0]=dp[1]=1;
		
		System.out.println(dynamic(n));
	}
	
	/*
	 * 동적 계획법
	 * n=1일 경우 1
	 * n=2일 경우 3
	 * n=3일 경우 5
	 * ...
	 * 
	 * 점화식은 dp[n] = (dp[n-2]*2) + dp[n-1]이 된다.
	 */
	public static int dynamic(int n) {
		if(dp[n]==null)
			dp[n]=(dynamic(n-1)+dynamic(n-2)*2)%10007;
		
		return dp[n];
	}
}
