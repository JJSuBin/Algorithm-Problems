import java.util.*;

public class BaekJoon_2417 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		
		long start=0;
		long end=n;
		long min=Long.MAX_VALUE;
		
		/*
		 * 이진탐색을 사용하려 long 자료형을 제곱했을 때 
		 * n보다 큰 값중 제일 작은 값을 찾는 문제
		 */
		while(start<=end) {
			long mid=(start+end)/2;
			long result=(long) Math.pow(mid, 2); // 제곱
			
			/*
			 * mid를 제곱한 값 중 n보다 크지만 
			 * 가장 작은 값을 찾는것이기 때문에
			 * 제곱값이 n보다 큰 경우 min에 mid 값을 저장하고, 
			 * end의 범위를 줄여 재탐색한다.
			 */
			if(result>=n) {
				min=mid;
				end=mid-1;
			}
			// 제곱값이 n보다 작은 경우 start 범위를 키워 재탐색한다.
			else 
				start=mid+1;
		}
		
		System.out.println(min);
	}

}
