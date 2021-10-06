import java.util.*;

public class BaekJoon_1920 {
	public static int n;
	public static int[] num;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		num=new int[n];
		
		for(int i=0;i<n;i++) 
			num[i]=sc.nextInt();
		
		Arrays.sort(num); // 이진 탐색할 배열은 반드시 정렬되어 있어야 한다.
		
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {
			int find=sc.nextInt();
			System.out.println(binarysearch(num,find,0,n-1));
		}
	}
	
	// 이진 탐색
	public static int binarysearch(int[] arr,int target, int start, int end) {
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==target) return 1;
			else if(arr[mid]>target) end=mid-1;
			else start=mid+1;
		}
		return 0;
	}
}
