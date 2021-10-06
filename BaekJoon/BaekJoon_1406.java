import java.util.*;
import java.io.*;

public class BaekJoon_1406 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str=br.readLine();
		int n=Integer.parseInt(br.readLine());
		
		/*
		 * leftStack에는 입력받은 문자열의 문자들이 아래부터 저장되어 있고
		 * 커서의 초기 위치는 문자열의 제일 위에 있기 때문에 leftStack의 제일 위의 문자 뒤에 위치한다.
		 * 
		 * leftStack에는 커서를 기준으로 왼쪽에 위치한 문자들이 아래부터 저장되어 있고,
		 * rightStack에는 커서를 기준으로 오른쪽에 위치한 문자들이 아래부터 저장되어 있다.
		 */
		Stack<Character> leftStack=new Stack<>();
		Stack<Character> rightStack=new Stack<>();
		
		for(int i=0;i<str.length();i++)
			leftStack.push(str.charAt(i));
		
		while(n-->0) {
			String command=br.readLine();
			char c=command.charAt(0);
			
			switch(c) {
			/*
			 * 커서를 한칸 왼쪽으로 옮길 경우에는 커서를 오른쪽으로 한칸 옮겼을 때
			 * rightStack으로 이동한 문자를 다시 leftStack으로 옮겨온다.  
			 */
			case 'L':
				if(!leftStack.isEmpty())
					rightStack.push(leftStack.pop());
				break;
			/*
			 * 커서를 한칸 오른쪽으로 옮길 경우에는 커서가 이동한것 처럼 보이기 위해
			 * leftStack의 제일 위에있는 값을 rightStack으로 이동시킨다.  
			 */	
			case 'D':
				if(!rightStack.isEmpty())
					leftStack.push(rightStack.pop());
				break;	
			/*
			 * 커서의 왼쪽에 있는 문자를 제거하는 경우이기 때문에 
			 * leftStack의 제일 위에있는 값을 삭제해준다.
			 */
			case 'B':
				if(!leftStack.isEmpty())
					leftStack.pop();
				break;	
			/*
			 * 입력받은 문자를 커서 왼쪽에 삽입하는 경우이기 때문에 
			 * 커서는 항상 leftStack의 제일 위에있는 문자 다음에 위치해있으므로
			 * leftStack의 제일 위에 문자를 삽입한다. 
			 */
			case 'P':
				char ch=command.charAt(2);
				leftStack.push(ch);
				break;	
			default:
				break;
			}
		}
		
		/*
		 * 스택은 LIFO 구조이기 때문에 
		 * leftStack에 있는 값들을 아래서부터 출력하기 위해서는
		 * rightStack에 저장한 후 rightStack 값을 위에서부터 꺼내 출력한다. 
		 */
		while(!leftStack.isEmpty())
			rightStack.push(leftStack.pop());
		
		while(!rightStack.isEmpty())
			bw.write(rightStack.pop());
		
		bw.flush();
		bw.close();
	}

}
