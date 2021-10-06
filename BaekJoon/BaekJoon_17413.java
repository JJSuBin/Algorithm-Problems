import java.util.*;

public class BaekJoon_17413 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Stack<Character> stack=new Stack<>(); // 문자를 뒤집어서 출력하기 위해 스택 사용
		boolean check=false; // 문자가 <>안에 있는지 확인하는 함수
		
		for(int i=0;i<str.length();i++) {
			// < 문자를 만났다면 < 이전에 있는 문자들을 역으로 출력하고 < 까지 출력
			if(str.charAt(i)=='<') {
				print(stack);
				check=true; // 이후에 나오는 문자들을 <> 내에 있는 문자라고 표시
				System.out.print(str.charAt(i)); // < 출력
			}
			
			// >를 만났다면 check 변수를 되돌리고 > 출력 
			else if(str.charAt(i)=='>') {
				check=false;
				System.out.print(str.charAt(i));
			}
			
			// <> 안에 있는 문자라면 순서 변화없이 그대로 출력
			else if(check)
				System.out.print(str.charAt(i));
			
			// <> 안에 있지 않은 문자 
			else if(!check) {
				// 공백일 경우 스택에 저장된 문자 모두 출력
				if(str.charAt(i)==' ') {
					print(stack);
					System.out.print(str.charAt(i)); // 공백 출력
				}
				
				// 공백이 아니고 <> 안에 있지 않은 문자라면 거꾸로 출력되야 하는 문자이므로 스택에 삽입
				else
					stack.push(str.charAt(i));
			}
		}
		print(stack); // 마지막에 스택에 남아있는 문자 모두 출력
	}
	
	// 스택에 저장되있는 문자 모두 출력하는 함수
	static void print(Stack<Character> stack) {
		while(!stack.isEmpty())
			System.out.print(stack.pop());
	}
}
