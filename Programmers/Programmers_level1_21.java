public class level1_21 {
	public String solution(String[] seoul) {
        String answer="";
        int index=0;
        
        // 문자열이 같은지 확인하기 위해서는 equals() 함수를 사용하여야 한다. 
        for(int i=0;i<seoul.length;i++) {
        	if(seoul[i].equals("Kim"))
        		index=i;
        }
        
        answer+="김서방은 "+index+"에 있다";
        return answer;
    }
}
