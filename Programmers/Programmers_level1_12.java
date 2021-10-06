import java.util.*;

public class level1_12 {
	 public long solution(long n) {
		 // String.valueOf(n) : long형의 정수를 String으로 변환한다. 
	    String num=String.valueOf(n);
	    String answer="";
	    char[] arr=new char[num.length()];
	    for(int i=0;i<num.length();i++)
	    	arr[i]+=num.charAt(i);
	    
	    Arrays.sort(arr);
	    
	    // 오름차순으로 정렬된 값을 역으로 출력 : 내림차순
	    for(int i=arr.length-1;i>=0;i--)
	    	answer+=arr[i];
	    
	    // Long.parseLong(answer) : String형의 문자열을 Long으로 변환한다.
	     return Long.parseLong(answer);
	 }
}
