public class level1_17 {
	public String solution(String s, int n) {
        String answer="";
        
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	
        	// 문자가 소문자인 경우
        	if(ch>='a'&&ch<='z') {
        		// 민 문자가 소문자를 벗어나는 경우 값 조정
        		if(ch+n>'z')
        			answer+=(char)(ch-26+n);
        		else
        			answer+=(char)(ch+n);
        	}
        	
        	// 문자가 대문자인 경우
        	else if(ch>='A'&&ch<='Z') {
        		// 민 문자가 대문자를 벗어나는 경우 값 조정 
        		if(ch+n>'Z')
        			answer+=(char)(ch-26+n);
        		else
        			answer+=(char)(ch+n);
        	}
        	
        	// 공백인 경우 밀어도 공백이기 때문에 값 변화 없이 더해준다.
        	else
        		answer+=(char)ch;
        }
        return answer;
    }
}
