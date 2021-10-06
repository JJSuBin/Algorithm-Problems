public class level1_24 {
	boolean solution(String s) {
        boolean answer=true;
        int pcount=0;
        int ycount=0;
        
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	
        	// 문자열에 p가 있다면 해당 변수 count
        	if(ch=='p'||ch=='P')
        		pcount+=1;
        	// 문자열에 y가 있다면 해당 변수 count
        	else if(ch=='y'||ch=='Y')
        		ycount+=1;
        }
        
        // p와 y의 개수가 다르다면 answer 값 변경
        if(ycount!=pcount)
        	answer=false;
        
        return answer;
    }
}
