import java.util.Scanner;

public class BaekJoon_1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int number=665; // 시작할 숫자
		int count=0; 
		
		while(count!=n) {
			number++;
			//number를 문자열로 변환해 666이 포함되는지 여부 확인, 반환값은 true/false 
			if(String.valueOf(number).contains("666")) count++;
		}
		System.out.println(number);
	}
}
