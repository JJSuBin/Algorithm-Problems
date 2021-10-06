import java.util.*;

public class BaekJoon_11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] card=new int[n+1];
		// dp[i]에는 i장의 카드를 살 경우의 최대금액이 저장되어 있다.
		int[] dp=new int[n+1];
		
		for(int i=1;i<=n;i++)
			card[i]=sc.nextInt();
		
		/*
		 * 카드 n개를 구매하는 방법은
		 * n개가 들어이는 팩을 구매하느냐
		 * 1개가 들어있는 팩과 n-1개가 들어있는 팩을 구매하느냐
		 * 2개가 들어있는 팩과 n-2개가 들어있는 팩을 구매하느냐
		 * ...
		 * 
		 * 이를 점화식으로 표현한다면 dp[i]=Math.max(dp[i],dp[i-j]+card[j])가 된다.
		 * 2중 for문을 사용하여 모든 경우수의 비교해보면서 값를 찾아나가면 된다
		 */
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				dp[i]=Math.max(dp[i],dp[i-j]+card[j]);
			}
		}
		System.out.println(dp[n]);
	}

}
