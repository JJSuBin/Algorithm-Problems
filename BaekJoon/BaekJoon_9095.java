import java.util.*;

public class BaekJoon_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int n=sc.nextInt();
			
			System.out.println(dynamic(n));
		}
	}
	
	/*
	 * n번째의 개수는 n-1 + n+2 + n-3의 개수들을 더한 값과 닽다
	 * 따라서 dynamic(n-3)+dynamic(n-2)+dynamic(n-1)이 오류가 없기 위해서는
	 * n이 1,2,3일 떄 값을 구해 return 시키고 이외의 값을 재귀호출을 통해 구한다.
	 */
	public static int dynamic(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		
		return dynamic(n-3)+dynamic(n-2)+dynamic(n-1);
	}
}
