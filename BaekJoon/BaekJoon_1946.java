import java.util.*;

public class BaekJoon_1946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=sc.nextInt();
		
		while(testcase-->0) {
			int n=sc.nextInt();
			int[] people=new int[n+1];
			
			/*
			 * 서류 점수의 순위를 인덱스로하고,
			 * 면접 점수의 순위를 해당 인덱스의 값으로 저장한다.
			 */
			for(int i=0;i<n;i++) {
				int document=sc.nextInt();
				int interview=sc.nextInt();
				
				people[document]=interview;
			}
			
			int count=1; // 면접 1등은 입사가 확실하기 때문에 count는 1로 초기화
			
			/*
			 * 1등부터 시작하는 서류 순위를 인덱스로 저장했기 때문에
			 * 배열의 인덱스 1부터 n까지 값이 저장되어 있다.
			 * 
			 * people 배열은 인덱스 1부터 n까지 서류 순위대로 정렬되어 있다.
			 * 서류 순위가 x(배열 인덱스)인 사람은 
			 * 자신보다 순위가 하나 높은 사람보다 면접 순위(배열 값)가 낮다면 입사할 수 없다. 
			 * 따라서 자신보다 순위가 한 단계 높은 사람과 배열의 값을 비교하여 
			 * 배열의 값이 작다면 입사 가능하고, 아니라면 입사할 수 없다.
			 */
			int prev=people[1];
			for(int i=2;i<=  n;i++) {
				if(people[i]<prev) {
					count++;
					prev=people[i];
				}
			}
			System.out.println(count);
		}
	}
}
