import java.util.*;

public class BaekJoon_1654 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		long n=sc.nextLong();
		long[] line=new long[k];
		
		for(int i=0;i<k;i++)
			line[i]=sc.nextLong();
		
		Arrays.sort(line);
		
		/*
		 * 랜선 길이는 자연수라고 명시되어 있기 때문에
		 * start는 최소 길이인 1로 초기화 한다. 
		 * 그리고 랜선을 자를 수 있는 범위는 입력 받은 랜선 길이 중 제일 긴 랜선보다
		 * 길 수 없기 때문에 end는 가장 긴 랜선 길이로 초기화 한다. 
		 */
		long start=1; 
		long end=line[k-1];
		long result=0; // 
		
		// 이분탐색 
		while(start<=end) {
			long count=0;
			long mid=(start+end)/2;
			
			/*
			 * 각 랜선마다 만들 수 있는 랜선의 개수를 구해
			 * count 값에 누적시킨다.
			 */
			for(int i=0;i<k;i++) 
				count+=line[i]/mid;
			
			/*
			 * 누적 값이 만들고자 하는 랜선의 개수보다 적을 경우
			 * 자르는 랜선의 길이를 줄여 더 많은 랜선이 만들어지도록 한다.
			 * 
			 * 누적 값이 만들고자 하는 랜선보다 많은 경우에는 
			 * 자르는 랜선의 길이를 늘려 더 적은 랜선이 만들어지도록 하는데 
			 * 이때 n개보다 많이 만드는 것도 n개를 만드는 것에 포함되기 떄문에
			 * 해당 값은 결과 값에 저장해둔다.
			 */
			if(count<n)
				end=mid-1;
			else {
				start=mid+1;
				result=mid;
			}
		}
		System.out.println(result);
	}
}
