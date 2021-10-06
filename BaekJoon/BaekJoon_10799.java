import java.util.*;

public class BaekJoon_10799 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		Stack<Character> stack=new Stack<>();
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			// 여는 괄호는 스택에 삽입
			if(ch=='(') 
				stack.add(ch);
			
			// 닫인 괄호인 경우
			if(ch==')') {
				stack.pop(); // 스택에서 짝이 되는 여는 괄호 삭제
				
				// 바로 전 문자가 ( 인 경우 레이저를 의미하므로 스택의 크기만큼 count 증가
				if(str.charAt(i-1)=='(') {
					count+=stack.size();
				}
				// 단순히 닫힌 괄호라면 count 1 증가(닫힌 괄호는 하나의 막대 조각을 의미한다.)
				else
					count++;
			}
		}
		System.out.println(count);
	}

}
