import java.util.*;

public class BaekJoon_11057 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] dp=new int[n+1][10];
		
		for(int i=0;i<10;i++)
			dp[0][i]=1;
		
		/*
		 * dp[n][j]에는 n자리 수이면서 첫째 자리가 j로 시작하는 수를 말한다.
		 * 즉, 0~9까지의 각 숫자(j)를 시작으로 만들 수 있는 수를 모두 더한 값이
		 * n 자리로 만들 수 있는 오르막의 수가 된다.  
		 */
		for(int i=1;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k<10;k++) {
					dp[i][j]+=dp[i-1][k];
					dp[i][j]%=10007;
				}
			}
		}
		System.out.println(dp[n][0]%10007);
	}

}
