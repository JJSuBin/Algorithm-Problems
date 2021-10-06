import java.util.*;

public class BaekJoon_2293 {
	public static int[] coin;
	public static int[] dp;
	public static int n,k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		k=sc.nextInt();
		coin=new int[n+1];
		/*
		 * dp[i] = j는 
		 * i금액을 만드는데 가능한 경우의 수 j가 저장되어 있는 배열이다.
		 */
		dp=new int[k+1];
		dp[0]=1;
		
		/*
		 * 점화식은 dp[j] = dp[j] + dp[j - coin[i]]이 되기 때문에
		 * for문을 사용하여 dp[k]까지의 값을 구해준다.
		 */
		for(int i=1;i<=n;i++) {
			coin[i]=sc.nextInt();
			for(int j=coin[i];j<=k;j++)
				dp[j]+=dp[j-coin[i]];
		}
		System.out.println(dp[k]);
	}
}
