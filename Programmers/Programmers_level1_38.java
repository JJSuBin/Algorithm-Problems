public class level1_38 {
	public int solution(String s) {
        String answer="";
        
        for(int i=0;i<s.length();i++) {
        	char ch=s.charAt(i);
        	
        	// 읽은 문자가 숫자인 경우
        	if(ch>='0'&&ch<='9') 
        		answer+=ch;
        	
        	/*
        	 * 읽은 문자가 알바펫인 경우 i번째 문자와 다음 문자(i+1)를 통해
        	 * 어떤 숫자인지 파악한 후 숫자를 answer에 저장하고,
        	 * 다음 읽어야할 인덱스 i를 해당 숫자의 길이만큼 증가시킨다.
        	 */
        	else {
        		switch(ch) {
        		// z로 시작하는 영단어는 zero밖에 없다.
        		case 'z':
        			answer+='0'; // 영단어에 맞는 숫자 answer에 저장
        			i+=3; // zero 문자열의 길이만큼 i증가
        			break;
        		// o로 시작하는 영단어는 one밖에 없다.
        		case 'o':
        			answer+='1'; 
        			i+=2; 
        			break;
        		/*
        		 * t로 시작하는 숫자 영단어는 two와 three가 있다.
        		 * 이럴 경우에는 i+1번째 알파벳을 비교하여 어떤 숫자인지 알아낸다. 
        		 */
        		case 't':
        			// tw로 시작하는 영단어는 two밖에 없다.
        			if(s.charAt(i+1)=='w') {
        				answer+='2';
        				i+=2;
        				break;
        			}
        			// th로 시작하는 영단어는 three밖에 없다.
        			if(s.charAt(i+1)=='h') {
        				answer+='3';
        				i+=4;
        				break;
        			}
        		case 'f':
        			// fo로 시작하는 영단어는 four밖에 없다.
        			if(s.charAt(i+1)=='o') {
        				answer+='4';
        				i+=3;
        				break;
        			}
        			// fi로 시작하는 영단어는 five밖에 없다.
        			if(s.charAt(i+1)=='i') {
        				answer+='5';
        				i+=3;
        				break;
        			}
        		case 's':
        			if(s.charAt(i+1)=='i') {
        				answer+='6';
        				i+=2;
        				break;
        			}
        			if(s.charAt(i+1)=='e') {
        				answer+='7';
        				i+=4;
        				break;
        			}
        		// e로 시작하는 영단어는 eight밖에 없다.
        		case 'e':
        			answer+='8';
        			i+=4;
        			break;
        		// n으로 시작하는 영단어는 nine밖에 없다.
        		case 'n':
        			answer+='9';
        			i+=3;
        			break;
        		}
        	}
        }
        // 함수의 반환형이 int이기 때문에 문자열을 int형으로 변환하여 return 한다.
        return Integer.parseInt(answer);
    }
}
