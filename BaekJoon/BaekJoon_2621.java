import java.util.*;

public class BaekJoon_2621 {
	static int[] number=new int[10]; // 1~9까지 나온 수의 빈도를 저장하는 배열
	static int[] cardvalue=new int[5]; // 입력받은 수 저장 배열
	static int[] color=new int[5]; // R,B,G,Y
	static boolean continuous=true; // 숫자가 연속적인지 판단
	static boolean fivecolor=false; // 카드 5장이 모두 같은 색인지 판단
	static boolean threecolor=false; // 카드 3장이 모두 같은 색인지 판단
	static boolean fournumber=false; // 4장의 숫자가 같은 경우
	static boolean threenumber=false; // 3장의 숫자가 같은 경우
	/*
	 * 2장의 숫자가 같은 경우은 최대 두 번 발생할 수 있기 때문에
	 * 이를 확인하는 변수는 int형으로 선언하고 각 수를 저장하기 위해 크기가 2인 배열을 사용한다.
	 */
	static int twonumber=0; 
	static int[] two=new int[2];
	static int value=0,answer=0,count=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++) {
			String ch=sc.next();
			int num=sc.nextInt();
			
			// 색깔
			switch(ch) {
			case "R":
				color[0]++;
				break;
			case "B":
				color[1]++;
				break;
			case "G":
				color[2]++;
				break;
			case "Y":
				color[3]++;
				break;
			}
			// 숫자
			number[num]++;
			cardvalue[i]=num;
		}
		
		Arrays.sort(cardvalue);
		Arrays.sort(two);
		continuescard();
		checkcolor();
		checknumber();
		
		// 카드 5장이 모두 같은 색이면서 숫자가 연속적인 경우
		if(continuous==true&&fivecolor==true) {
			answer+=cardvalue[4]+900;
		}
		// 카드 5장 중 4장의 숫자가 같은 경우
		else if(fournumber==true) {
			answer+=value+800;
		}
		// 카드 5장 중 3장의 숫자가 같고 나머지 2장도 숫자가 같은 경우
		else if(threenumber==true&&twonumber==1) {
			answer+=(value*10)+two[0]+700;
		}
		// 5장의 카드 색깔이 모두 같은 경우
		else if(fivecolor==true) {
			answer+=cardvalue[4]+600;
		}
		// 카드 5장의 숫자가 연속적은 경우
		else if(continuous==true) {
			answer+=cardvalue[4]+500;
		}
		// 카드 5장 중 3장의 숫자가 같은 경우
		else if(threenumber==true) {
			answer+=value+400;
		}
		// 카드 5장 중 2장의 숫자가 같고 또 다른 2장의 숫자가 같은 경우
		else if(twonumber==2) {
			answer+=(two[1]*10)+two[0]+300;
		}
		// 카드 5장 중 2장의 숫자가 같은 경우
		else if(twonumber==1) {
			answer+=two[0]+200;
		}
		// 위의 어떤 경우에도 해당하지 않은 경우
		else {
			answer+=cardvalue[4]+100;
		}
		
		System.out.println(answer);
	}
	
	// 카드 숫자가 4개가 같은지, 3개가 같은지, 2개가 같은지 확인하는 함수
	public static void checknumber() {
		for(int i=1;i<10;i++) {
			if(number[i]==4) {
				fournumber=true;
				value=i;
			}
			else if(number[i]==3) {
				threenumber=true;
				value=i;
			}
			/*
			 * 카드의 숫자가 2가가 같은 경우는 최대 두 번
			 * 발생할 수 있기 때문에 각각의 수를 배열에 저장
			 */
			else if(number[i]==2) {
				twonumber++;
				two[count++]=i;
			}
		}
		
	}
	
	// 카드의 색이 모두 같은지, 3장의 색이 같은지 확인하는 함수
	public static void checkcolor() {
		for(int i=0;i<4;i++) {
			// 카드 5장의 색이 모두 같은 경우
			if(color[i]==5) {
				fivecolor=true;
				break;
			}
			// 카드 3장의 색이 모두 같은 경우
			if(color[i]==5) {
				threecolor=true;
				break;
			}
		}
	}
	
	// 카드의 숫자가 연속적인지 판별하는 함수
	public static void continuescard() {
		for(int i=1;i<cardvalue.length;i++) {
			if(cardvalue[i]!=cardvalue[i-1]+1) {
				continuous=false;
				break;
			}
		}
	}
}

