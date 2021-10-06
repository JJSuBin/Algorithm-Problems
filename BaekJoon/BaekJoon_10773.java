import java.util.*;

public class BaekJoon_10773 {
	public static int point=0;
	public static int[] stack;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		stack=new int[k];
		
		while(k-->0) {
			int n=sc.nextInt();
			
			// 0인 경우 최근에 입력 받는 숫자 제거
			if(n==0) {
				pop();
			}
			
			// 0이 아닌 정수를 입력 받은 경우 스택에 추가
			else {
				push(n);
			}
		}
		
		int result=0;
		for(int i=0;i<stack.length;i++)
			result+=stack[i];
		
		System.out.println(result);
	}
	
	// 스택에 입력받은 데이터 추가
	public static void push(int data) {
		stack[point]=data;
		point+=1;
	}
	
	// 스택에 제일 위에 있는 값 제거
	public static int pop() {
		// 스택에 아무것도 없는 경우 0 반환
		if(point==0)
			return 0;
		else {
			int res=stack[point-1];
			stack[point-1]=0;
			point-=1;
			return res;
		}
	}
}
