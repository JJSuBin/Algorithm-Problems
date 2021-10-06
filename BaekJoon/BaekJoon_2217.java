import java.util.*;

public class BaekJoon_2217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Integer[] rope=new Integer[n];
		
		for(int i=0;i<n;i++)
			rope[i]=sc.nextInt();
		
		// 중량이 큰 로프부터 검사하기 위해 내림차순 정렬
		Arrays.sort(rope, Collections.reverseOrder());
		
		int max=Integer.MIN_VALUE;
		/*
		 * 중량이 큰 로프부터 들수 있는 무게를 계산하여 그 중 최댓값 저장
		 * 이때 i가 늘어날 수록 로프의 중량은 작아지지만 로프의 개수는 많아지므로 곱하기 i를 해주어야 한다. 
		 * 
		 * 예를들어 35 33 30 20 12 로프가 있을 경우
		 * 중량 35 로프를 선택하면 최대 중량은 35
		 * + 중량 33 로프가 병렬로 연결된다면 최대 중량은 33*2=66
		 * + 중량 30 로프가 병렬로 연결된다면 최대 중량은 30*3=90
		 * + 중량 20 로프가 병렬로 연결된다면 최대 중량은 20*4=80
		 * + 중량 12 로프가 병렬로 연결된다면 최대 중량은 12*5=60
		 */
		for(int i=1;i<=n;i++) {
			max=Math.max(max,rope[i-1]*i);
		}
		
		System.out.println(max);
	}
}
