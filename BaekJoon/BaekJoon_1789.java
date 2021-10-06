import java.util.*;

public class BaekJoon_1789 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long s=sc.nextLong();
		
		long start=1;
		long end=s;
		long result=0;
		
		while(start<=end) {
			long mid=(start+end)/2;
			
			// 1부터 mid까지의 합 구하기
			long sum=(mid*(mid+1))/2;
			
			// 합이 s보다 크다면 작은 범위 탐색
			if(sum>s) {
				end=mid-1;
			}
			
			// 합이 s보다 작다면 mid 값 저장 후, 더 큰 범위 탐색
			else {
				start=mid+1;
				result=mid;
			}
		}
		
		System.out.println(result);
	}

}
