import java.util.*;

public class BaekJoon_15721 {
	static int a,t,k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt(); // 전체 인원수 (0부터 a-1번 까지)
		t=sc.nextInt(); // t번째 뻔/데기를 외치는 사람 구하기
		k=sc.nextInt(); // 0->뻔, 1->데기
		
		System.out.println(solution());
	}
	static int solution() {
		int count=2; // 
		int bbun=0;
		int degi=0;
		
		while(true) {
			// 처음 뻔-데기-뻔-데기 count
			for(int i=0;i<4;i++) {
				if(i%2==0)
					bbun++;
				else
					degi++;
				
				/*
				 * 총 인원은 a명이지만 0번 부터 count하기 때문에
				 * 뻔이 나온 횟수와 데기가 나혼 횟수는 더한 값에 
				 * -1 해준 값을 전체 인원수로 나눈 값을 return 한다. 
				 */
				if(bbun==t&&k==0)
					return (bbun+degi-1)%a;
				if(degi==t&&k==1)
					return (bbun+degi-1)%a;
			}
			
			// 이후 count만큼 반복되는 뻔Xn-데기Xn count
			for(int i=0;i<count;i++) {
				bbun++;
				if(bbun==t&&k==0)
					return (bbun+degi-1)%a;
			}
			for(int i=0;i<count;i++) {
				degi++;
				if(degi==t&&k==1)
					return (bbun+degi-1)%a;
			}
			count++;
		}
	}
}
