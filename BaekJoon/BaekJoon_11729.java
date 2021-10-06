import java.util.Scanner;
/*
 * 하노이의 원판
 * 원판을 A에서 C로 옮기기 위해서는 n-1개의 원판이 A에서 B로 이동해야 한다
 * 이후 A에 남은 가장 큰 한개의 원판을 C로 이동시킨다.
 * B로 이동해있던 n-1개의 원판을 C로 이동시킨다.
 */
public class BaekJoon_11729 {
	 public static StringBuilder sb=new StringBuilder();
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(); //원판의 개수 입력
		
		sb.append((int)(Math.pow(2, n)-1)).append('\n'); //총 이동 횟수 계산(일반항을 이용 = 2^n-1)
		Hanoi(n,1,2,3);
		System.out.println(sb);
		
	}
	/* 
	 * n : 원판의 개수
	 * start : 출발지
	 * mid : 목적지로 가기 위해 이동시킬 장소
	 * end : 목적지
	 */
	public static void Hanoi(int n, int start, int mid, int end) {
		if(n==1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		Hanoi(n-1,start,end,mid); //제일 큰 원판을 제외하고 나머지 n-1개의 원판을 A에서 B로 이동
		sb.append(start+" "+end+"\n"); //제일 큰 원판을 A에서 C로 이동
		Hanoi(n-1,mid,start,end); // A에서 B로 이동시킨 원판을 다시 B에서 C로 이동
	}
}
