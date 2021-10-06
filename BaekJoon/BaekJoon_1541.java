import java.util.*;

/*
 * 덧셈과 뺄셈으로 이루어진 문자열에서 최솟값을 만들기 위해서는 
 * 덧셈으로 이루어진 부분을 먼저 계산한 후 빼주는 것이다.
 * 뺼셈을 기준으로 분리하면 덧셈으로 이루어진 계산식 들이 나온다.
 * 이 덧셈식들을 먼저 계산한 후 첫 번째 피연산자에서 모두 뺴주면 된다.
 * 이때 첫 번째 피연산자를 식별하지 않고 뺄셈을 진행하면 첫 번째 피연산자가 음수가 되므로
 * 식별해주는 과정이 필요하다.
 */
public class BaekJoon_1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int sum=Integer.MAX_VALUE; // 첫 번째 숫자인지 확인하기 위한 값으로 설정
		
		// 입력받은 문자열을 뺄셈으로 분리하여 저장
		String[] arr=sc.next().split("-");
		
		// arr 배열에는 뺄셈으로 분리된 덧셈식의 문자열의 덩어리들이 저장되어 있다.
		for(int i=0;i<arr.length;i++) {
			int temp=0;
			
			// arr2 배열에는 덧셈식의 문자열을 덧셈을 기준으로 분리한 뒤 저장 -> 숫자만 저장되어 있음
			String[] arr2=arr[i].split("\\+");
			
			// String 형식을 Integer로 변경하여 누적합 저장
			for(int j=0;j<arr2.length;j++)
				temp+=Integer.parseInt(arr2[j]);
			
			// 첫 번째 피연산자인 경우 temp 값에 대입
			if(sum==Integer.MAX_VALUE)
				sum=temp;
			// 아니라면 뻴셈 진행
			else 
				sum-=temp;
		}
		System.out.println(sum);
	}
}
