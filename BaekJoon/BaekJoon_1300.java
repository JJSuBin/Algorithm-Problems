import java.util.*;

public class BaekJoon_1300 {
	public static int n,k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		
		/*
		 * 배열의 인덱스가 1부터 시작하기 떄문에 start는 최솟값 1로 초기화 한다.
		 * k번째에 해당하는 수는 k를 초과하지 않기 때문에 end 값을 k로 초기화 한다. 
		 * 그 이유는 두 개씩 중복되는 수가 존재하기 때문이다.   
		 */
		long start=1;
		long end=k;
		long result=0;
		
		// 이분탐색
		while(start<=end) {
			long mid=(start+end)/2;
			long count=0;
			
			/*
			 * Math.min(mid/i, n)에서 mid/i는 각 행에서 mid보다 작은 숫자의 개수를 의미한다.
			 * 이때 만약 n=4, mid=7이라고 가정하면 1행에서는 7/1=7의 결과가 나오는데
			 * 각 행에 있는 숫자의 개수는 최대 n개이기 떄문에 mid/i or n 중 작은 숫자를 누적해나가면서
			 * mid보다 작은 숫자의 개수를 새나간다.
			 */
			for(int i=1;i<=n;i++)
				count+=Math.min(mid/i, n);
			
			/*
			 * mid보다 작은 숫자의 개수가 k보다 작다면 mid는 k번째 수가 될 수 없기 때문에
			 * 좀 더 큰 숫자를 탐색하기 위해 범위를 크게 한다.
			 * 
			 * mid보다 작은 숫자의 개수가 k보다 크다면 mid는 k번째 수에 포함된다.
			 * 따라서 mid를 result에 저장하고 범위를 좁혀 재탐색한다.
			 */
			if(k>count)
				start=mid+1;
			else {
				result=mid;
				end=mid-1;
			}	
		}
		System.out.println(result);
	}
}
