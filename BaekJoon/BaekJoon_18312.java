import java.util.*;

public class BaekJoon_18312 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int count=0;
		
		for(int hour=0;hour<=n;hour++) {
			for(int min=0;min<60;min++) {
				for(int sec=0;sec<60;sec++) {
					// 시간을 문자열로 표현, 시,분,초가 10 미만일 경우 앞에 0을 붙인다.
					String time=((hour<10)?"0"+hour:""+hour)+
							((min<10)?"0"+min:""+min)+
							((sec<10)?"0"+sec:""+sec);
					
					// 시간에 k가 포함되어 있다면 count
					if(time.contains(""+k))
						count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
