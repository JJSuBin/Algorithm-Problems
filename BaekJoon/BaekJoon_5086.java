import java.util.*;

public class BeakJoon_5086 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			if(a==0&&b==0)
				break;
			
			if(a%b==0)
				System.out.println("multiple");
			else if(b%a==0)
				System.out.println("factor");
			else 
				System.out.println("neither");
		}
	}
}
