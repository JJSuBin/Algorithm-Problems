import java.util.*;

public class BaekJoon_2512 {
	public static int[] budget;
	public static int n;
	public static long m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		budget=new int[n];
		
		// 각 국가의 요청 예산을 입력받고, 합을 구한다.
		long sum=0;
		for(int i=0;i<n;i++) {
			budget[i]=sc.nextInt();
			sum+=budget[i];
		}
		
		Arrays.sort(budget); 
		m=sc.nextLong(); //  배정 가능한 예산 입력받는다.
		
		// 요청 예산의 합이 배정 가능 예산보다 많다면 이분탐색
		if(sum>m) {
			System.out.println(binarySearch(1,budget[n-1],sum));
		}
		// 요청 예산의 합이 배정 가능 예산보다 적다면 가장 큰 예산 값 출력
		else {
			System.out.println(budget[n-1]);
		}
	}
	
	// 이분탐색
	public static long binarySearch(long start, long end, long target) {
		long result=0;
		while(start<=end) {
			long mid=(start+end)/2;
			long sum=0;
			
			// 각 국가에 가능한 예산을 분배할 경우 예산을 총액 구하기
			for(int i=0;i<n;i++) 
				sum+=(mid<budget[i])?mid:budget[i];
			
			// 예산 총액이 배정 가능 예산보다 클 경우
			if(sum>m)
				end=mid-1;
			
			// 예산 총액이 배정 가능 예산보다 작을 경우
			else {
				start=mid+1;
				result=mid; // 최댓값을 찾기 위해 값 저장
			}
		}
		return result;
	}
}
