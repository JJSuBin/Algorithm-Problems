import java.util.*;

public class BaekJoon_11866 {
	public static Queue<Integer> q=new LinkedList<>();
	public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		for(int i=1;i<=n;i++)
			q.offer(i);
		
		sb.append("<");
		
		/*
		 * 마지막 원소 뒤에는 콤마가 없어야 하기 때문에
		 * 마지막 원소는 출력 처리를 따로 해줘야 한다. 
		 */
		while(q.size()>1) {
			for(int i=0;i<k-1;i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()+">");
		System.out.println(sb);
	}
}
