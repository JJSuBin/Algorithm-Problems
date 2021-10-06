import java.util.*;

public class level2_19 {
	public String solution(String p) {
        String answer = "";
        
        // 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if(p.equals(""))
        	return answer;
        
        int index=balance(p); // 균형잡힌 문자열로 분리하기 위한 인덱스 얻어오기
        String u=p.substring(0,index+1); // 균형잡힌 문자열 u
        String v=p.substring(index+1); // 나머지 문자열
        
        /*
         * u가 균형잡힌 문자열인 경우 solution(v) 재귀함수를 호출하여
         * v문자열을 다시 u, v로 나누는 과정을 수행한다. 
         */
        if(correct(u))
        	answer=u+solution(v);
        
        /*
         * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
  		 *	4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
  		 *	4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
  		 *	4-3. ')'를 다시 붙입니다. 
  		 *	4-4. u의 첫 번째와 마지막 문자를 제거하고(1), 
  		 *		나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다(2). 
  		 *	4-5. 생성된 문자열을 반환합니다.
         */
        else {
        	answer="("; // 4-1
        	answer+=solution(v); // 4-2
        	answer+=")"; // 4-3
        	u=u.substring(1,u.length()-1); // 4-4(1)
        	
        	// 4-4(2)
        	String temp="";
        	for(int i=0;i<u.length();i++) {
        		if(u.charAt(i)=='(')
        			temp+=")";
        		else 
        			temp+="(";
        	}
        	answer+=temp; // 4-5
        }
        return answer; 
    }
	
	// 균형잡힌 괄호 문자열인지 판단하고, 문자열 p중 균형잡인 괄호의 인덱스 번호를 return 하는 함수
	public int balance(String p){
		int count=0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(')
				count+=1;
			else
				count-=1;
			
			if(count==0)
				return i;
		}
		return -1;
	}
	
	// 올바른 괄호 문자열인지 판단하는 함수
	public boolean correct(String p){
		int count=0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(')
				count+=1;
			else {
				if(count==0)
					return false;
				
				count-=1;
			}
		}
		return true;
	}
}
