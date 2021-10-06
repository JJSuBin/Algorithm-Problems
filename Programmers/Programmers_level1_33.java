import java.util.*;

public class level1_33 {
	public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> three=new ArrayList<Integer>();
        int num=n;
        
        // 10진법을 3진법 역순으로 바꿔 ArrayList에 저장
        while(num>0) {
        	three.add(num%3);
        	num/=3;
        }
        
        /*
         * ArrayList에는 이미 n을 3진법으로 바꾼 수가 역순으로 저장되어 있기 때문에
         * 그 순서대로 다시 10진법으로 바꾸면 된다. 
         */
        for(int i=0;i<three.size();i++) 
        	answer+=three.get(i)*Math.pow(3, three.size()-1-i);
        
        return answer;
    }
}
