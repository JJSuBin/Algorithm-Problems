import java.util.*;

public class BaekJoon_11663 {
	static int[] point;
	static int n,m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		
		point=new int[n];
		for(int i=0;i<n;i++)
			point[i]=sc.nextInt();
		
		Arrays.sort(point); // 이진탐색을 위한 정렬
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<m;i++) {
			int s=sc.nextInt();
			int e=sc.nextInt();
			
			sb.append(binarySearch(s,e)).append('\n');
		}
		System.out.println(sb);
	}
	
	/*
	 * 이진탐색 
	 * 선분의 좌표를 (x,y)라고 할 때
	 * x를 기준으로 x를 포함한 오른쪽 부분의 인덱스
	 * y를 기준으로 y를 포함한 오른쪽 부분의 인덱
	 * y-x를 통해 점으로 주어진 좌표상에서 선분 사이에 있는 점의 개수를 구할 수 있다. 
	 */
	static int binarySearch(int x, int y) {
		int start=0;
		int end=point.length-1;
		
		// 선분의 y좌표보다 작은 점들의 개수 count
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(point[mid]>y)
				end=mid-1;
			
			else 
				start=mid+1;
		}
		
		int endIndex=end+1;
		
		start=0;
		end=point.length-1;
		
		// 선분의 x좌표보다 작은 점들의 개수 count
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(point[mid]<x)
				start=mid+1;
				
			else 
				end=mid-1;
		}
		
		int startIndex=start;
		
		return endIndex-startIndex;
	}

}
