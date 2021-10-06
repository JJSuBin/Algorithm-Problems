import java.util.*;

public class BaekJoon_1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		Integer[] arr=new Integer[str.length()]; // 각 자릿수를 저장할 변수
		
		// 문자열 형식으로 입력 받은 값을 정수 형태로 바꿔 배열에 저장 
		for(int i=0;i<str.length();i++)
			arr[i]=str.charAt(i)-'0';
		
		// 배열 값을 내림차순으로 정렬
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
	}
}
