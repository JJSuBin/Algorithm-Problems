import java.util.*;

public class BaekJoon_11508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer[] food=new Integer[n];
		
		for(int i=0;i<n;i++)
			food[i]=sc.nextInt();
		
		// 역순 정렬
		Arrays.sort(food, Collections.reverseOrder());
		
		int result=0;
		int count=0;
		for(int i=0;i<n;i++) {
			count++; // 개수 증가
			
			// 할인이 되는 3번째 값은 더하지 않고, count 개수 초기화
			if(count==3) {
				count=0;
				continue;
			}
			
			// 할인이 안되는 제품은 누적합 구하기
			result+=food[i];
		}
		System.out.println(result);
	}

}
