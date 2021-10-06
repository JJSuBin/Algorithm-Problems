import java.util.*;

public class BaekJoon_1026 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer[] a=new Integer[n];
		int[] b=new int[n];
		int sum=0;
		
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		for(int i=0;i<n;i++)
			b[i]=sc.nextInt();
		
		// a 배열은 내림차순으로, b 배열은 오름차순으로 정렬 
		Arrays.sort(a,Collections.reverseOrder());
		Arrays.sort(b);
		
		// 두 배열을 곱한 값을 누적
		for(int i=0;i<n;i++)
			sum+=a[i]*b[i];
		
		System.out.println(sum);
	}
}
