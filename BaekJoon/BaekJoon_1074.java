import java.util.*;

public class BaekJoon_1074 {
	static int count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int r=sc.nextInt();
		int c=sc.nextInt();
		
		int size=(int)Math.pow(2,n); // 2^n×2^n인 2차원 배열의 한 변의 크기 계산
		
		find(size,r,c);
		System.out.println(count);
	}
	
	// 2^n×2^n인 배열은 4등분 해가며 r행 c열은 언제 방문하는지 찾는다.
	static void find(int size, int r, int c) {
		if(size==1)
			return;
		
		/*
		 * 1사분면에 있다면 아직 아무곳도 방문하지 않은 상태이므로
		 * size만 절반으로 줄인 값을 매개변수로 하여 재귀호출 한다.
		 */
		if(r<size/2 && c<size/2) 
			find(size/2,r,c);
		
		/*
		 * 2사분면에 있다면 1사분면을 방문한 상태이므로 1사분면의 칸 개수를 누적해주고
		 * 2사분면에서의 r,c의 상태위치 r,c-size/2를 매개변수로 하여 재귀호출 한다.
		 */
		else if(r<size/2 && c>=size/2) {
			count+=size*size/4;
			find(size/2,r,c-size/2);
		}
		
		/*
		 * 3사분면에 있다면 1,2사분면을 방문한 상태이므로 1,2사분면의 칸 개수를 누적해주고
		 * 3사분면에서의 r,c의 상태위치 r-size/2,c를 매개변수로 하여 재귀호출 한다.
		 */
		else if(r>=size/2 && c<size/2) {
			count+=(size*size/4)*2;
			find(size/2,r-size/2,c);
		}
		
		/*
		 * 4사분면에 있다면 1,2,3사분면을 방문한 상태이므로 1,2,3사분면의 칸 개수를 누적해주고
		 * 4사분면에서의 r,c의 상태위치 r-size/2,c-size/2를 매개변수로 하여 재귀호출 한다.
		 */
		else {
			count+=(size*size/4)*3;
			find(size/2,r-size/2,c-size/2);
		}
	}
}
