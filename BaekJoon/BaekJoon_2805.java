import java.util.*;

public class BaekJoon_2805 {
	public static int n,m,tree[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		tree=new int[n];
		
		for(int i=0;i<n;i++)
			tree[i]=sc.nextInt();
		
		Arrays.sort(tree);
		
		/*
		 * 절단기에 설정할 수 있는 높이는 양의 정수 또는 0이라고 명시되어 있기 때문에
		 * start는 최소 길이인 0으로 초기화 한다. 
		 * 그리고 절단기가 가질수 있는 제일 큰 값은 
		 * 제일 긴 나무의 값과 같기 때문에 해당 값으로 초기화 해준다. 
		 */
		int start=0;
		int end=tree[n-1];
		int result=0;
		
		// 이진탐색
		while(start<=end) {
			int mid=(start+end)/2;
			long length=0; // 가져갈 수 있는 나무의 길이
			
			for(int i=0;i<n;i++){
				/*
				 * 절단기의 길이보다 긴 나무들은 
				 * 절단기 높이만큼 자르고 남은 높이만큼 누적 값을 구해준다. 
				 */
				if(tree[i]>=mid) {
					length+=tree[i]-mid;
				}
			}
			
			/*
			 * 가져갈 수 있는 나무의 길이가 원하는 길이보다 작으면
			 * 절단기의 높이를 줄여 더 많은 길이의 나무를 가져갈 수 있게 한다.
			 * 
			 * 만약 가져갈 수 있는 나무의 길이가 원하는 길이보다 길다면
			 * 해당 값은 result 변수에 저장해 두고 절단기의 높이를 좀 더 늘린다.
			 */
			if(length<m) {
				end=mid-1;
			}
			else {
				start=mid+1;
				result=mid;
			}
		}
		System.out.println(result);
	}
}
