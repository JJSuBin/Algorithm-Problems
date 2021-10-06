public class level1_30 {
	public String solution(String s) {
        String answer="";
        
        // 문자열의 길이가 짝수일 경우
        if(s.length()%2==0) {
        	answer+=s.charAt(s.length()/2-1);
        	answer+=s.charAt(s.length()/2);
        }
        
        // 문자열의 길이가 홀수일 경우
        else {
        	answer+=s.charAt(s.length()/2);
        }
        return answer;
    }
}
