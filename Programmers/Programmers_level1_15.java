public class level1_15 {
	public String solution(String s) {
        String answer="";
        /*
         * 배열에 문자열 s를 단어 하나씩 분리해 저장한다.
         * 이때 배열에는 공백 또한 그대로 저장되어 있다. 
         */
        String[] str=s.split("");
        
        int count=0;
        /*
         * count는 짝/홀수 인덱스를 판단하는 변수이다. 
         * 이때 문자열 전체의 짝/홀수 인덱스가 아닌, 단어별로 짝/홀수 인덱스를 판단해야 하기 때문에
         * 공백을 만날때면 count를 0으로 초기화 시켜줘야 한다.
         * 공백이 아닌 문자를 만날때는 count가 짝수이면 대문자로, 홀수이면 소문자를 저장한다. 
         */
        for(int i=0;i<str.length;i++) {
        	if(str[i].equals(" "))
        		count=0;
        	else {
        		if(count%2==0) {
            		count+=1;
            		str[i]=str[i].toUpperCase();
            	}
            	else {
            		count+=1;
            		str[i]=str[i].toLowerCase();
            	}
        	}
        	answer+=str[i];
        }
        
        return answer;
    }
}
