import java.util.*;

public class BaekJoon_1158 {
	static Queue<Integer> q=new LinkedList<>();
	static StringBuilder sb=new StringBuilder();
	static int n,k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		
		for(int i=1;i<=n;i++)
			q.add(i);
		
		sb.append("<");
		while(q.size()>1) {
			/*
			 * k번째 이전 사람까지는 큐에서 제거후
			 * 큐의 제일 뒤에 다시 삽입해준다.
			 */
			for(int i=0;i<k-1;i++)
				q.offer(q.poll());
			
			sb.append(q.poll()+", ");
		}
		
		/*
		 * 마지막에 제거되는 사람의 번호 뒤에는
		 * 콤마가 없기 때문에 따로 처리해주어야 한다.
		 */
		sb.append(q.poll()+">");
		
		System.out.println(sb);
	}

}
