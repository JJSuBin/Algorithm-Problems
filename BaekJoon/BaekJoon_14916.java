import java.util.*;

public class BaekJoon_14916 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int coin=sc.nextInt();
		int result=0;
		
		while(true) {
			// 액수가 5로 나눠 떨어진다면 5로 나눈 몫을 더한 후 while문 종료
			if(coin%5==0) {
				result+=coin/5;
				break;
			}
			
			// 5로 나눠 떨어지지 않는다면 액수에서 2를 뺀 수 동전 개수 1개 count
			coin-=2;
			result++;
		}
		
		// 거슬러 줄 수 없는 경우
		if(coin<0)
			System.out.println(-1);
		else 
			System.out.println(result);
	}

}
