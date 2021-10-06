import java.util.*;

public class BaekJoon_11399 {
	public static int n;
	public static int[] time;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		time=new int[n];
		int sum=0;
		int result=0;
		
		for(int i=0;i<n;i++)
			time[i]=sc.nextInt();
		
		/* 시간이 적게 걸리는 사람부터 돈을 인출하는 것이 
		 * 시간의 합이 최솟값이 도출되므로 입력 받은 값들을
		 * 오름차순으로 정렬 
		 */
		Arrays.sort(time);
		
		for(int i=0;i<n;i++) {
			// 시간이 적게 소요되는 사람부터 값을 누적시킨다.
			sum+=time[i];
			// 누적된 값들을 결과 값에 저장
			result+=sum;
		}
		System.out.println(result);
	}
}
