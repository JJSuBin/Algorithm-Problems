public class level1_22 {
	public boolean solution(String s) {
        boolean answer = true;
        
        // 문자열의 길이가 4 또는 6이 아니라면 false 반환 
        if(s.length()!=4&&s.length()!=6)
        	answer=false;
        
        // 문자열에 영어가 있다면 false 반환 
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	if(ch>='a'&&ch<='z')
        		answer=false;
        }
        return answer;
    }
}
