import java.util.*;

public class BaekJoon_2156 {
	public static int n;
	public static int[] wine; 
	public static Integer[] dp; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		wine=new int[n+1];
		dp=new Integer[n+1];
		
		for(int i=1;i<=n;i++)
			wine[i]=sc.nextInt();
		
		dp[0]=0;
		dp[1]=wine[1];
		
		/*
		 * n이 1인 경우는 처음 와인의 양이 최댓값이고
		 * n이 2 이상인 경우의 dp[2]는 wine[1]+wine[2]이 항상 최댓값이다.
		 */
		if(n>1)
			dp[2]=wine[1]+wine[2];
		
		System.out.println(choose(n));
	}
	
	/*
	 * dp는 이전 잔들을 선택 한 최대 합을 의미한다.
	 * 해당 문제의 특징은 마지막 와인잔을 더했을 경우까지가 최대합이 될 수도 있고
	 * 그 이전까지의 합이 최대합이 될 수도 있다는 것이다.
	 * Math.max(choose(n-2), choose(n-3)+wine[n-1])+wine[n] 부분은 마지막 와인잔을 더했을 경우
	 * choose(n-1) 부분은 마지막 이전 와인잔 까지의 선택이 최대 누적합인 경우이다.
	 */
	public static int choose(int n) {
		if(dp[n]==null) {
			dp[n]=Math.max(Math.max(choose(n-2), choose(n-3)+wine[n-1])+wine[n],choose(n-1));
		}
		return dp[n];
	}
}
