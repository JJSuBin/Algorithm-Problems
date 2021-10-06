import java.util.*;

public class BaekJoon_9012 {
	public static int point;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		for(int i=0;i<testcase;i++)
			System.out.println(check(sc.next()));
		}	
	
	public static String check(String str) {
		Stack<Character> stack=new Stack<Character>(); // 스택 선언
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			// 여는 괄호일 경우 스택에 삽입
			if(ch=='(')
				stack.push(ch);
			
			/*
			 * 여는 괄호가 아닌 닫는 괄호를 입력 받았으나 스택이 비어
			 * pop 할 원소가 없는 경우 온전한 수식어가 아니기 때문에 NO return 
			 */ 
			else if(stack.empty())
				return "NO";
			
			// 닫는 괄호인 경우 스택의 여는 괄호 삭제
			else
				stack.pop();
		}
		
		/*
		 * 검사를 마치고 스택에 잔여 요소가 있다면 여는 괄호가 남아있다는 의미이고,
		 * 스택이 비어있다면 온전한 수식어이다. 
		 */
		if(stack.empty())
			return "YES";
		else
			return "NO";
	}
}
