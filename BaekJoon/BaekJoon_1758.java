import java.util.*;

public class BaekJoon_1758 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer[] tip=new Integer[n];
		
		for(int i=0;i<n;i++)
			tip[i]=sc.nextInt();
		
		// 주려고 하는 팁의 액수가 많은 사람부터 시작해야 팁의 최댓값을 구할 수 있다.
		Arrays.sort(tip, Collections.reverseOrder());
		
		long result=0; // 팁은 100,000보다 작거나 같은 자연수이기 때문에 반드시 long 자료형 사용
		for(int i=0;i<n;i++) {
			int give=tip[i]-i; // 커피를 받아가는 순위에 따른 팁 값 계산
			// 액수가 음수가 아니라면 누적액 계산
			if(give>=0)
				result+=give;
		}
		System.out.println(result);
	}

}
