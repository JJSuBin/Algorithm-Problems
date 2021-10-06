import java.util.*;

public class level2_12 {
	public String[] solution(String[] files) {
     
        Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] file1=divide(o1);
				String[] file2=divide(o2);
				
				// head 부분을 사전순으로 비교한다.
				int headvalue=file1[0].compareTo(file2[0]);
				
				// head 부분을 사전으로 정렬한 값이 같다면 숫자 부분을 비교
				if(headvalue==0) {
					int number1=Integer.parseInt(file1[1]);
					int number2=Integer.parseInt(file2[1]);
					
					return Integer.compare(number1, number2);
				}
				// head 부분은 사전순으로 정렬
				else
					return headvalue;
			}
			
			// 문자열을 머리,숫자,꼬리로 나눠주는 함수
			public String[] divide(String str) {
				String head="";
				String number="";
				String tail="";
				
				/*
				 * 머리,숫자,꼬리로 나눌때
				 * 머리 다음에 숫자부분, 숫자부분 다음에 꼬리부분으로 
				 * 인덱스가 누적되면서 탐색해야하기 때문에 for문 밖에 변수를 선언 후 사용한다.
				 */
				int index=0;
				// 머리 부분
				for(;index<str.length();index++) {
					char ch=str.charAt(index);
					// 숫자가 나오면 숫자부분이기 때문에 for문 중단
					if(ch>='0'&&ch<='9')
						break;
					head+=ch;
				}
				
				// 숫자 부분
				for(;index<str.length();index++) {
					char ch=str.charAt(index);
					// 숫자가 끝나면 tail 부분이기 때문에 for문 중단
					if(!(ch>='0'&&ch<='9'))
						break;
					number+=ch;
				}
				
				// 꼬리 부분
				for(;index<str.length();index++) {
					// 남은 문자 tail에 저장
					char ch=str.charAt(index);
					tail+=ch;
				}
				
				// 파일명에서 대문자와 소문자는 구분하지 않기 때문에 head는 모두 소문자로 바꿔 저장한다.
				String[] file= {head.toLowerCase(),number,tail};
				
				return file;
			}
        });
        return files;
    }
}
