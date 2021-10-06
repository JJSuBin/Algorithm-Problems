public class level2_2 {
	 public static String solution(String s) {
		 StringBuilder answer=new StringBuilder();
		// 첫번째 문자는 무조건 대문자로 변경
		 String first=s.charAt(0)+""; 
		 answer.append(first.toUpperCase());
		 
	     for(int i=1;i<s.length();i++) {
	    	 String now=s.charAt(i)+"";
	    	 
	    	 if(now.equals(' ')) // 공백이면 answer에 공백 추가
	    		 answer.append(" ");
	    	 
	    	// 이전 문자열이 공백이라면 대문자로 변경
	    	 else if(s.charAt(i-1)==' ')  
	    		 answer.append(now.toUpperCase());
	    	 
	    	 // 이전 문자열이 공백이 아니라면 소문자로 변경
	    	 else
	    		 answer.append(now.toLowerCase());
	     }
	     // StrintBuilder를 String 형식으로 변환하여 return
	     return answer.toString();
	 }
}
