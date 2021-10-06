import java.util.*;

public class BaekJoon_14467 {
	static int[][] cow;
	static int n,count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		cow=new int[n][2];
		
		for(int i=0;i<n;i++) {
			cow[i][0]=sc.nextInt();
			cow[i][1]=sc.nextInt();
		}
		
		// 소의 번호를 기준으로 오름차순으로 정렬한다.
		Arrays.sort(cow, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		
		int prev=cow[0][0]; // 이전 소의 번호
		int status=cow[0][1]; // 이전 소의 위치
		for(int i=1;i<n;i++) {
			int now=cow[i][0]; // 현재 소의 번호
			
			/*
			 * 현재 소의 번호가 이전 소의 번호와 같으면
			 * 상태가 변했다면 count를 증가시킨다. 
			 */
			if(prev==now) 
				if(status!=cow[i][1]) 
					count++;
			
			status=cow[i][1]; // 소 위치 갱신
			prev=now; // 소 번호 갱신
				
		}
		
		System.out.println(count);
	}

}
