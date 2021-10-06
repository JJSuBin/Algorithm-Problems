import java.util.*;

public class BaekJoon_17266 {
	static int[] a;
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		// 가로등이 설치된 지점 입력 받기
		a=new int[m];
		for(int i=0;i<m;i++)
			a[i]=sc.nextInt();
		
		int start=1;
		int end=n;
		int result=0;
		
		// 이진탐색
		while(start<=end) {
			int mid=(start+end)/2;
			
			// mid 높이로 모든 지점을 비출 수 있다면 result 갱신 후 높이를 줄여 재탐색
			if(possible(mid)) {
				result=mid;
				end=mid-1;
			}
			// 모든 지점을 비출 수 없다면 높이를 높여 재탐색
			else
				start=mid+1;
		}
		
		System.out.println(result);
	}
	
	static boolean possible(int target) {
		int prev=0; // 이전 가로등이 비춘 마지막 지점, 0 지점부터 모두 비춰주어야 하기 때문에 0부터 시작
		
		for(int i=0;i<a.length;i++) {
			/*
			 * 가로등이 있는 지점에서 비출 수 있는 높이(target)을 뺀 값이
			 * 이전 가로등이 비춘 마지막 지점에 도달했다면 prev 갱신
			 */
			if(a[i]-target<=prev) {
				prev=a[i]+target; // a[i] 가로등이 마지막으로 비춘 지점
			}
			/*
			 * 가로등의 시작 지점에서 높이(target)만큼 비춘 곳이
			 * 이전 가로등이 마지막으로 비춘 곳에 도달하지 못한다면 모든 지점을 비출수 없다. 
			 */
			else 
				return false;
		}
		
		/*
		 * 마지막 지점도 가로등이 비출 수 있는지 확인해야 하기 떄문에 
		 * 마지막 가로등이 비출 수 있는 끝 지점에서 굴다리의 끝 좌표를 뺐을 때
		 * 0보다 작거나 같아야 마지막 지점도 비춰지므로 해당 과정 필수!
		 */
		return n-prev<=0;
	}
}
