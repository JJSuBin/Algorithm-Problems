import java.util.*;

public class BaekJoon_14891 {
	static int[][] wheels=new int[4][8];
	static int[] direction; // 각 톱니바퀴마다 회전해야 하는 방향 저장 (0이면 이동 X)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int i=0;i<4;i++) {
			String str=sc.next();
			for(int j=0;j<8;j++) {
				wheels[i][j]=Integer.parseInt(str.charAt(j)+"");
			}
		}
		
		int round=sc.nextInt();
		for(int i=0;i<round;i++) {
			direction=new int[4];
			
			int wheelnum=sc.nextInt()-1;
			int dir=sc.nextInt();
			
			check(wheelnum,dir);
			rotate(direction);
		}
		
		System.out.println(calculation());
	}
	
	static int calculation() {
		int sum=0;
		for(int i=0;i<4;i++) {
			if(wheels[i][0]==1)
				sum+=Math.pow(2, i);
		}
		return sum;
	}
	
	// 회전 방향이 든 배열을 받아 해당 방향으로 각 바퀴를 회전시킨다.
	static void rotate(int[] direction) {
		for(int i=0;i<4;i++) {
			int[] temp=new int[8]; // 임시 배열
			
			int index;
			for(int j=0;j<8;j++) {
				index=j+direction[i];
				
				if(index==-1)
					index=7;
				else if(index==8)
					index=0;
				
				temp[index]=wheels[i][j];
			}
			// 원래 배열에 회전한 값이 들어있는 임시배열 복사
			wheels[i]=temp;
		}
	}
	
	/*
	 * 입력으로 들어오는 바퀴 번호와, 회전 방향을 받아 
	 * 해당 바퀴의 왼쪽, 오른쪽 바퀴와 맞닿아 있는 극을 확인한다.
	 * 이때 양 극이 달라 회전해야 한다면 재귀호출로 계속 검사하고, 
	 * 각 바퀴마다 direction 배열에 회전 방향을 저장한다.
	 * 
	 * 주의해야 할 점은 양 옆의 톱니바퀴의 회전 여부는 회전 이전의 극으로 결정된다는 것이다.
	 */
	static void check(int wheelnum, int dir) {
		direction[wheelnum]=dir;
		
		int left=wheelnum-1;
		int right=wheelnum+1;
		
		/*
		 * 왼쪽 바퀴 검사
		 * 왼쪽에 바퀴가 있고, 왼쪽 바퀴의 회전 여부가 아직 결정되지 않았으며
		 * 현재 바퀴의 9시 방향과 왼쪽 바퀴의 3시 방향의 극이 다르다면 회전
		 */
		if(left>=0&&direction[left]==0)
			if(wheels[wheelnum][6]!=wheels[left][2])
				check(left,dir*-1);
		
		/*
		 * 왼쪽 바퀴 검사
		 * 오른쪽에 바퀴가 있고, 오른쪽 바퀴의 회전 여부가 아직 결정되지 않았으며
		 * 현재 바퀴의 3시 방향과 왼쪽 바퀴의 9시 방향의 극이 다르다면 회전
		 */
		if(right<=3&&direction[right]==0)
			if(wheels[wheelnum][2]!=wheels[right][6])
				check(right,dir*-1);
	}
}
