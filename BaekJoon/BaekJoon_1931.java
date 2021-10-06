import java.util.*;

public class BeakJoon_1931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[][] time=new int[n][2];
		
		for(int i=0;i<n;i++) {
			time[i][0]=sc.nextInt();
			time[i][1]=sc.nextInt();
		}
		
		/*
		 * 서로 겹치지 않는 활동에 대해 종료 시간이 빠르면 더 많은 활동을 선택할 수 있다.
		 * 따라서 종료시간을 기준으로 정렬을 수행해야 한다. 
		 * 
		 * <주의 할 점>
		 * 예를 들어 (8,8), (4,8), (1,3)을 종료시점으로만 정렬한다면
		 * (1,3), (8,8), (4,8)이 된다. 그러면 (1,3)과 (8,8)만이 선택되며
		 * (4,8)은 선택될 수 없다. 이러한 오류를 없애기 위해 종료 시간이 같다면 시작 시간이 빠른 순으로 정렬해야 한다.
		 */
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같으면 시작시간이 빠른 순으로 정렬
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		int count=0;
		int prev_end_time=0;
		
		for(int i=0;i<n;i++) {
			// 직전 회의 종료 시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
			if(prev_end_time<=time[i][0]) {
				prev_end_time=time[i][1];
				count+=1;
			}
		}
		System.out.println(count);
	}
}
