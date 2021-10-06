import java.util.*;

public class BaekJoon_2164 {
	public static Queue<Integer> q=new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++)
			q.offer(i);
		
		while(q.size()>1) {
			q.poll(); // 맨 앞의 카드를 버린다.
			/*
			 * 버린 카드 다음 카드를 꺼내 
			 * 맨 뒤에 삽입한다. 
			 */
			int x=q.poll(); 
			q.add(x);
		}
		// 1개 남은 원소를 출력
		System.out.println(q.poll());
	}
}
