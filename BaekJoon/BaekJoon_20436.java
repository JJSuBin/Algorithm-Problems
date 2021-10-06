import java.util.Scanner;

public class BaekJoon_20436 {
	// 키보드의 상태가 저장되어 있는 배열, 이때 자판이 없는 곳은 X 저장
	static Character[][] keyboard= {{'q','w','e','r','t','y','u','i','o','p'}
									,{'a','s','d','f','g','h','j','k','l','X'}
									,{'z','x','c','v','b','n','m','X','X','X'}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char sL=sc.next().charAt(0); // 왼손 검지손가락의 초기 위치
		char sR=sc.next().charAt(0); // 오른손 검지손가락의 초기 위치
		String str=sc.next(); 
		int time=0; // 총 걸리는 시간
		
		// 입력받은 문자열 탐색
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			// 모음인 경우 오른손 검지손가락 사용
			if(ch=='y'||ch=='u'||ch=='i'||ch=='o'||ch=='p'
			||ch=='h'||ch=='j'||ch=='k'||ch=='l'
			||ch=='b'||ch=='n'||ch=='m'){
				
				String hand=findIndex(sR); // 오른손이 위치한 알파벳의 인덱스 구하기
				String move=findIndex(ch); // 이동해야하는 알파벳의 인덱스 구하기
				
				// findIndex는 문자열로 반환되기 때문에 int 형식으로 변환
				int x1y2=Integer.parseInt(hand);
				int x2y2=Integer.parseInt(move);
				
				/*
				 * findIndex로 반환된 값이 "03"이라면 int형 03으로 바꾼 후
				 * 거리를 계산하기 위해 행의 값을 10으로 나눈 몫으로 구하고,
				 * 열의 값을 10으로 나눈 나머지의 값으로 구해 매개변수로 전달한다.
				 * 
				 * 두 좌표를 사용하여 이동 시간을 구해 time 값에 누적시킨다.
				 */
				time+=distacnce(x1y2/10,x1y2%10,x2y2/10,x2y2%10);
				
				sR=ch; // 오른손 위치 갱신
			}
			
			// 자음인 경우 왼손 검지손가락 사용
			else {
				String hand=findIndex(sL);
				String move=findIndex(ch);
				
				int x1y2=Integer.parseInt(hand);
				int x2y2=Integer.parseInt(move);
				
				time+=distacnce(x1y2/10,x1y2%10,x2y2/10,x2y2%10);
				
				sL=ch; // 왼손 위치 갱신
			}
			
			time+=1; // 자판을 누르는 1초 count
		}
		
		System.out.println(time);
	}
	
	/*
	 * 문자 c가 키보드상 어느 위치에 있는지 반환하는 함수
	 * 문자열 첫 번째에 행, 두 번째에 열이 저장되어 있는 형태로 반환
	 * 
	 * 예를들어 "03"은 키보드 0행의 3열에 있다는 의미
	 */
	public static String findIndex(char c) {
		String result=""; 
		for(int i=0;i<3;i++) {
			for(int j=0;j<10;j++) {
				if(keyboard[i][j]==c) {
					result+=i;
					result+=j;
				}	
			}
		}
		return result;
	}
	
	// 이동 시간 구하는 함수
	public static int distacnce(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+Math.abs(y1-y2);
	}
}
