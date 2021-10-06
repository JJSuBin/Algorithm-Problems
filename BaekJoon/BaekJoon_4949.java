import java.util.*;

public class BaekJoon_4949 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String s;
		
		while(true) {
			s=sc.nextLine();
			
			// 마침표를 기준으로 문장 판별
			if(s.equals("."))
				break;
			
			System.out.println(check(s));
		}
	}
	public static String check(String str) {
		Stack<Character> stack=new Stack<>(); // 스택 선언
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			// 여는 괄호일 경우 스택에 삽입
			if(ch=='('||ch=='[')
				stack.push(ch);
			
			/*
			 * 닫는 괄호 중 ')'인 경우 스택이 비어있거나 
			 * 스택에 제일 최근에 삽입된 괄호가 ')'의 짝인 '('이 아닐 경우 no return
			 * 조건을 만족한다면 스택에서 '(' 삭제  
			 */
			else if(ch==')') {
				if(stack.empty()||stack.peek()!='(')
					return "no";
				else 
					stack.pop();
			}
			
			/*
			 * 닫는 괄호 중 ']'인 경우 스택이 비어있거나 
			 * 스택에 제일 최근에 삽입된 괄호가 ']'의 짝인 '['이 아닐 경우 no return
			 * 조건을 만족한다면 스택에서 '[' 삭제  
			 */
			else if(ch==']') {
				if(stack.empty()||stack.peek()!='[')
					return "no";
				else 
					stack.pop();
			}
			
		}
		
		// 검사가 끝난 후 스택이 비어있다면 완전한 문장이라고 판단.
		if(stack.empty())
			return "yes";
		else
			return "no";
	}
}
