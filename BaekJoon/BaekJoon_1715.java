import java.util.*;

public class BaekJoon_1715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i=0;i<n;i++)
			pq.offer(sc.nextInt());
		
		int result=0;
		/*
		 * 비교 횟수가 최소가 되기 위해서는 매 경우마다 
		 * 카드의 크기가 가장 작은 두 묶음을 합치는 것이다. 
		 * 
		 * 따라서 우선순위 큐를 사용하여 크기가 작은 카드를 먼저 꺼내도록 하고,
		 * 두 묶음을 합쳐 하나의 묶음으로 만들어 다시 우선순위 큐에 삽입한다.
		 * 최종적으로 하나의 카드 묶음이 만들어 질때까지 반복
		 */
		while(pq.size()!=1) {
			int a=pq.poll(); // 제일 작은 카드 묶음 꺼내기
			int b=pq.poll(); // 두 번째로 작은 카드 묶음 꺼내기
			
			int sum=a+b; // 두 묶음을 합치지
			result+=sum; // 횟수 누적
			pq.offer(sum); // 두 카드 묶음을 다시 우선순위 큐에 삽입
		}
		
		System.out.println(result);
	}

}
