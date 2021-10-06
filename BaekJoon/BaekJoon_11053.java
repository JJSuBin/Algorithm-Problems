import java.util.*;

public class BaekJoon_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
				
		int[] num=new int[n];
		int[] dp=new int[n];
				
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
				
		for(int i=0;i<n;i++) {
			dp[i]=1; // 부분 수열은 자기 자신을 포함한 값이 최솟값이기 때문에 1로 초기화
					
			for(int j=0;j<i;j++) {
				/*
				* 자신 보다 값이 작지만 dp 값은 큰 경우 
				* j번째 원소의 dp 값에 i번째 수열을 포함한(+1) 값을 저장한다.
				*/   
				if(num[j]<num[i]&&dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
		}
				
		// 최대 길이 탐색
		int max=-1;
		for(int i=0;i<n;i++) {
			max=dp[i]>max?dp[i]:max;
		}
		System.out.println(max);
	}
}
