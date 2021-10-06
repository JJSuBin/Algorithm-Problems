import java.util.*;

public class BaekJoon_1935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack<Double> stack=new Stack<>();
		int n=sc.nextInt();
		
		String str=sc.next(); // 후위식 입력 받기
		double[] number=new double[27];
		
		// 숫자 입력 받기
		for(int i=0;i<n;i++)
			number[i]=sc.nextDouble();
		
		// 후위식 계산
		for(int i=0;i<str.length();i++) {
			int code=(int)str.charAt(i);
			
			// 숫자라면 스택에 삽입
			if(code>=65&&code<=90)
				stack.push(number[code-65]);
			
			// 문자라면 스택에서 두 숫자를 꺼내 연산 후 다시 스택에 삽입한다.
			else {
				double a=stack.pop();
				double b=stack.pop();
				double result=0;
				
				switch(code) {
				case 42: // * 인 경우
					result=b*a;
					break;
				case 43: // + 인 경우
					result=b+a;
					break;
				case 47: // / 인 경우
					result=b/a;
					break;
				case 45: // - 인 경우
					result=b-a;
					break;
				}
				
				stack.push(result);
			}
		}
		
		// 계산이 끝난 결과 값을 소숫점 둘째 자리까지 출력한다.
		System.out.printf("%.2f",stack.pop());
	}

}
