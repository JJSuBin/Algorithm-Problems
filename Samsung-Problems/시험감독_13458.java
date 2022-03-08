import java.util.*;

public class 시험감독_13458 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); // 시험장의 개수
		int[] student=new int[n];
		
		for(int i=0;i<n;i++)
			student[i]=sc.nextInt();
		
		int b=sc.nextInt(); // 총 감독관이 감시 가능한 수
		int c=sc.nextInt(); // 부 감독관이 감시 가능한 수
		
		long result=0;
		// 총 감독관 1명, 부 감독관 n명으로 각 시험장의 응시자들을 모두 감시할 수 있어야 함
		for(int i=0;i<n;i++) {
			int rest=student[i]-b; // 총 감독관이 감시 가능한 수 빼기
			result++; // 총 감독관 count;
			
			if(rest<=0) // 모두 감시 가능하다면 넘어가기
				continue;
			
			if(rest%c==0) // 남은 인원과 부 감독관이 딱 나눠 떨어지는 경우
				result+=rest/c;
			else // 그렇지 않은 경우 남은 인원 위해 부 감독관 한명 더 추가
				result+=rest/c+1;
		}
		
		System.out.println(result);
	}

}
