import java.util.*;

public class BaekJoon_2110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=sc.nextInt();
		int[] house=new int[n];
		
		for(int i=0;i<n;i++)
			house[i]=sc.nextInt();
		
		Arrays.sort(house);
		
		/*
		 * 공유기를 설치할 수 있는 범위는 최소 1부터
		 * 가장 멀리있는 집과 처음의 집 사이의 거리만큼 일 것이다. 
		 * 해당 값들로 start, end를 초기화 해준다.
		 */
		int start=1;
		int end=house[n-1]-house[0]; // 최대길이
		int result=0;
		
		/*
		 * 최소 거리 ~ 최대 거리 범위 내에서 이진 탐색을 사용한다.
		 * 공유기를 설치할 수 있는 지점은 마지막으로 설치한 곳 + 탐색 거리(mid)가 된다.
		 */
		while(start<=end) {
			int mid=(start+end)/2;
			int prevhouse=house[0]; // 첫 번째 집에 설치
			int count=1;
			
			for(int i=0;i<n;i++) {
				int dis=house[i]-prevhouse; 
				/*
				 * 공유기를 설치한 두 지점간의 거리가 탐색중인 mid 보다 크다면
				 * 해당 공유기를 설치할 수 있기 때문에 설치 공유기의 개수를 늘려주고
				 * 마지막으로 공유기를 설치한 집의 위치를 갱신한다.
				 */
				if(dis>=mid) {
					count++;
					prevhouse=house[i];
				}
			}
			
			/*
			 * 설치된 공유기의 개수가 설치하고자 하는 대수보다 작다면
			 * 공유기간의 거리를 줄여서 다시 탐색한다.
			 * 
			 * 설치된 공유기의 개수가 설치하고자 하는 대수보다 많다면
			 * 해당 값을 저장해두고 공유기간의 거리를 늘려 다시 탐색한다.
			 * -> 다음 탐색에서 start<=end 조건을 불만족 한다면 이전에 result에 저장해 둔 값을 출력
			 */
			if(count<c)
				end=mid-1;
			else {
				start=mid+1;
				result=mid;
			}
		}
		System.out.println(result);
	}
}
