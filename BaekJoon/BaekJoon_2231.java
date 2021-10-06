import java.util.Scanner;

public class BaeJoon_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int result=0;
		
		//n을 넘길 때 까지 생성자를 찾지 못하면 기존 result값 0을 출력한다.
		for(int i=1;i<n;i++) {
			int num=i;
			int sum=0; //각 자리의 합 변수
			
			while(num!=0) {
				sum+=num%10; //각 자리수 더하기
				num/=10;
			}
			//생성자를 찾은 경우
			if(sum+i==n) {
				result=i;
				break;
			}
		}
		System.out.println(result);
	}
}
