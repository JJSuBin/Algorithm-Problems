import java.util.*;

public class BaekJoon_1182 {
	static int count=0,n,s;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		s=sc.nextInt();
		arr=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		dfs(0,0);
		
		// 합이 0일 경우에는 공집합도 포함되므로 -1 해준 값을 출력한다.
		if(s==0)
			count-=1;
		
		System.out.println(count);
	}
	public static void dfs(int depth, int sum) {
		if(depth==n) {
			if(sum==s)
				count++;
			return;
		}
		
		/*
		 * 부분수열을 구하는 방법으로는 지금 위치의 원소를
		 * 선택하는 방법과, 선택하지 않는 방법이 있다. 
		 */
		dfs(depth+1,sum); // 지금 위치의 원소를 빼고 구하는 방법
		dfs(depth+1,sum+arr[depth]); // 지금 위치의 원소를 포함하여 구하는 방법
	}
}
