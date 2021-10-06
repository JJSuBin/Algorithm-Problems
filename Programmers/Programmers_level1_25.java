import java.util.*;

public class level1_25 {
	public String[] solution(String[] strings, int n) {
        String[] answer=new String[strings.length];
        for(int i=0;i<strings.length;i++)
        	answer[i]=strings[i];
        
        Arrays.sort(answer,new Comparator<String>() {
			@Override
			/*
			 * n번째 알파벳이 같다면 문자열을 비교하여 사전순으로 정렬한다.
			 * n번째 알파벳이 다르다면 해당 알파벳을 기준으로 정렬한다.  
			 */
			public int compare(String o1, String o2) {
				return (o1.charAt(n)==o2.charAt(n))?o1.compareTo(o2):Character.compare(o1.charAt(n), o2.charAt(n));
			}
        });
        return answer; 
	}
}
