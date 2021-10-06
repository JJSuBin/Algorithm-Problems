import java.util.*;

/*
 * 입력 받은 1과 n을 제외한 n의 모든 약수를 정렬 후 
 * 가장 큰 값과 가장 작은 값을 곱한 값이 n이 된다.
 */
public class BaekJoon_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		System.out.println(arr[0]*arr[n-1]);
	}
}
