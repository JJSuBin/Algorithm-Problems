import java.util.*;

public class BaekJoon_20055 {
	static int[] belt;
	static int n,k,count=0;
	static boolean[] robot;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		
		belt=new int[n*2];
		robot=new boolean[n];
		
		for(int i=0;i<2*n;i++)
			belt[i]=sc.nextInt();
		
		while(true) {
			move_belt();
			count++;
			move_robot();
			if(check()) {
				System.out.println(count);
				break;
			}
		}
	}
	
	// 과정을 종료해야 하는지 체크하는 함수
	static boolean check() {
		int result=0;
		
		// 모든 컨베이어 벨트의 내구도 검사
		for(int i=0;i<2*n;i++) {
			if(belt[i]==0) // 내구도가 0인 벨트 개수 count
				result++;
		}
		
		// 내구도가 0인 벨트의 개수가 k개 이상이라면 과정 종료 
		if(result>=k)
			return true;
		else
			return false;
	}
	
	// 컨베이어 벨트가 회전하는 함수
	static void move_belt() {
		int temp=belt[belt.length-1]; // 위로 올라와야 하는 값 임시저장
		
		for(int i=belt.length-1;i>0;i--)
			belt[i]=belt[i-1];
		
		belt[0]=temp;
		
		// 컨베이어 벨트가 이동함에 따라 로봇도 함께 이동
		for(int i=n-1;i>0;i--)
			robot[i]=robot[i-1];
		
		robot[0]=false; // 첫 번째 칸은 반드시 로봇이 없어야 한다.
	}
	
	// 로봇을 움직이는 함수
	static void move_robot() {
		// 내려가는 위치에 있는 없애주어야 한다. 
		if(robot[n-1])
			robot[n-1]=false;
		
		// 로봇을 옆칸으로 이동
		for(int i=n-2;i>0;i--) {
			/*
			 * 현재 칸에 로봇이 있고, 다음 칸에는 로봇이 없으며, 
			 * 다음 칸의 내구도가 0 이상일 경우 로봇 이동
			 */
			if(robot[i]&&!robot[i+1]&&belt[i+1]>0) {
				robot[i+1]=true; // 다음칸 로봇 이동
				robot[i]=false; // 현재 칸 초기화
				belt[i+1]--; // 로봇이 이동했으므로 내구도 1 감소
			}
		}
		
		// 벨트의 맨 앞이 내구도가 0보다 크고, 로봇이 없다면 새로운 로봇 투입
		if(belt[0]>0&&!robot[0]) {
			robot[0]=true;
			belt[0]--; // 로봇이 투입됐으므로 내구도 1 감소
		}
	}
}
