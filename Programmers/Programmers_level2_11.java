import java.util.*;

public class level2_11 {
	boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	
        	// 여는 괄호일 경우 스택에 삽입
        	if(ch=='(')
        		stack.add(ch);
        	
        	// 닫는 괄호일 경우
        	else if(ch==')') {
        		// 스택이 비어있다면 짝지을 여는 괄호가 없기 때문에 false return
        		if(stack.isEmpty()) {
        			answer=false;
        			return answer;
        		}
        		// 스택에 여는 괄호가 있다면 짝이되는 여는 괄호를 스택에서 제거
        		else {
        			if(stack.peek()=='(')
        				stack.pop();
        		}
        	}
        }
        
        /*
         * 위의 과정이 끝났는데도 스택에 값이 있다면 여는 괄호가 남아있다는 의미
         * 스택이 비어있다면 완전한 문장이기 때문에 true return
         */
        if(stack.isEmpty())
        	answer=true;
        else
        	answer=false;
        
        return answer;
    }
}
