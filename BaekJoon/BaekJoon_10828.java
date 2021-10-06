import java.util.*;

public class BaekJoon_10828 {
	public static int point=0;
	public static int[] stack=new int[10000];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		for(int i=0;i<testcase;i++) {
			String str=sc.next();
			
			switch(str) {
			case "push":
				push(sc.nextInt());
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
                
			case "size":
				sb.append(size()).append('\n');
				break;
                
			case "empty":
				sb.append(empty()).append('\n');
				break;
                
			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
	
	// push X : 정수 X를 스택에 넣는 연산이다.
	public static void push(int x) {
		stack[point]=x;
		point+=1;
	}
	
	/*
	 * pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
	 * 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */
	public static int pop() {
		if(point==0)
			return -1;
		else {
			int res=stack[point-1];
			stack[point-1]=0;
			point-=1;
			return res;
		}
	}
	
	// size : 스택에 들어있는 정수의 개수를 출력한다.
	public static int size() {
		return point;
	}
	
	// empty : 스택이 비어있으면 1, 아니면 0을 출력한다.
	public static int empty() {
		if(point==0)
			return 1;
		else 
			return 0;
	}
	
	/* 
	 * top : 스택의 가장 위에 있는 정수를 출력한다.
	 * 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */
	public static int top() {
		if(point==0)
			return -1;
		return stack[point-1];
	}
}
