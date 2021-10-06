import java.util.*;

public class BaekJoon_1912 {
	public static int n;
	public static int[] num;
	public static Integer[] dp; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		num=new int[n];
		dp=new Integer[n];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		dp[0]=num[0];
		makesum(n-1); // dp의 마지막 인덱스 번호는 n-1이기 때문에 n-1을 매개변수로 호출
		
		/*
		 * dp에는 각 인덱스까지의 누적합 최대가 저장되어 있다.
		 * 저장되어 있는 누적합 중 최대를 찾아야 하기 때문에
		 * 아래와 같은 과정 수행
		 */ 
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			max=(dp[i]>max)?dp[i]:max;
		
		System.out.println(max);
	}
	
	public static int makesum(int n) {
		if(dp[n]==null)
			/*
			 * (이전 인덱스 까지의 누적 합 + 현재 값)과 현재 값을 비교하여 최댓값을 저장
			 * 즉, dp[n]에는 인덱스 n까지의 최대 누적합이 저장되어 있다.
			 * 예를 들어 -10 2 3이 주어졌을 때 
			 * dp[2]는 (-10+2)와 2중 큰 값을 선택할 것이고
			 * dp[3]은 dp[2]+3(2+3) 또는 3중 큰 값을 선택할 것이다. 
			 */
			return dp[n]=Math.max(makesum(n-1)+num[n], num[n]);
		
		return dp[n];
	}
}
