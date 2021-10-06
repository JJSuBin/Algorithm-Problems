import java.util.*;

public class BaekJoon_14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] t=new int[n];
		int[] p=new int[n];
		int[] dp=new int[n+1];
		
		for(int i=0;i<n;i++) {
			t[i]=sc.nextInt();
			p[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			// 현재 날짜에서 상담이 소요되는 시간을 합한 날짜가 퇴사 전이라면
			if(i+t[i]<=n) {
				/*
				 * 해당 날짜의 dp에는 원래 저장되 있던 값과
				 * 현재 날짜에서 비용을 더한 값 중 최댓값을 저장한다.
				 */
				
				dp[i+t[i]]=Math.max(dp[i+t[i]],dp[i]+p[i]);
			}
			/*
			 * 해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 저장해두어야 하기 때문에
			 * 이전의 dp 배열 값과 비교하여 최댓값을 넣어둔다. 
			 */
			dp[i+1]=Math.max(dp[i+1],dp[i]);
		}
		System.out.println(dp[n]);
	}

}
