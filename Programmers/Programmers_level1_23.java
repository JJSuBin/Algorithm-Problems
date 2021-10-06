import java.util.*;

public class level1_23 {
	public String solution(String s) {
        String answer="";
        Character[] arr=new Character[s.length()];
        
        // 문자열의 문자마다 잘라 배열에 저장
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	arr[i]=ch;
        }
        
        // 문자열 s 역순 정렬
        Arrays.sort(arr,Collections.reverseOrder());
        
        for(int i=0;i<arr.length;i++)
        	answer+=arr[i];
        
        return answer;
    }
}
