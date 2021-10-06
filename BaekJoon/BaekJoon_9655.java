import java.util.*;

public class BaekJoon_9655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		/*
		 * 돌의 개수가 홀수이면 상근이가 이기고
		 * 짝수이면 창영이가 이기게 된다.  
		 */
		if(n%2==1)
			System.out.println("SK");
		else
			System.out.println("CY");
	}

}
