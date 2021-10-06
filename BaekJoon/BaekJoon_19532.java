import java.util.*;

public class BaekJoon_19532 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=sc.nextInt();
		int e=sc.nextInt();
		int f=sc.nextInt();
		
		// 완전탐색
		for(int x=-999;x<1000;x++) {
			for(int y=-999;y<1000;y++) {
				/*
				 * ax + by = c 
				 * dx + ey = f 를 만족하는 x, y 구하기
				 */
				if((a*x)+(b*y)==c && (d*x)+(e*y)==f) {
					System.out.println(x+" "+y);
					return;
				}
			}
		}
	}

}
