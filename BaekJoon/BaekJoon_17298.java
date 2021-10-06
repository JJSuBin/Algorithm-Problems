import java.util.*;

public class BaekJoon_17298 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack<Integer> stack=new Stack<>();
		int n=sc.nextInt();
		int[] num=new int[n];
		
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			/*
			 * 스택이 비어있지 않고, 스택에 저장된 인덱스의 배열값(왼쪽) 보다
			 * 오른쪽 배열 값이 크다면 배열 값을 변경해준다. 
			 */
			while(!stack.isEmpty()&&num[stack.peek()]<num[i])
				num[stack.pop()]=num[i];
			// 스택에 해당 인덱스 삽입
			stack.push(i);
		}
		
		/*
		 * 최종적으로 스택에 남아있는 인덱스는
		 * 해당 인덱스의 배열 값 보다 큰 값이 오른쪽에 존재하지 않는다는 의미이기 떄문에
		 * 배열 값을 -1로 변경 
		 */
		while(!stack.isEmpty())
			num[stack.pop()]=-1;
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++)
			sb.append(num[i]).append(" ");
		
		System.out.println(sb);
	}
}
