import java.util.*;

public class BaekJoon_1463 {
	public static int n;
	public static Integer[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		dp=new Integer[n+1];
		
		dp[0]=dp[1]=0;
		
		System.out.println(makeone(n));
	}
	public static int makeone(int n) {
		if(dp[n]==null) {
			// 6으로 나눠지는 경우
			if(n%6==0)
				dp[n]=Math.min(makeone(n/3), Math.min(makeone(n/2), makeone(n-1)))+1;
			// 3으로 나눠지는 경우
			else if(n%3==0)
				dp[n]=Math.min(makeone(n/3), makeone(n-1))+1;
			// 2로 나눠지는 경우
			else if(n%2==0)
				dp[n]=Math.min(makeone(n/2), makeone(n-1))+1;
			// 2와 3으로 나눠지지 않는 경우 -> -1을 하는 경우
			else 
				dp[n]=makeone(n-1)+1;
		}
		return dp[n];
	}
}
