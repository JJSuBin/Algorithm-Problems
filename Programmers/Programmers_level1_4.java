public class level1_4 {
	public String solution(String phone_number) {
		String answer = "";
		
		for(int i=0;i<phone_number.length();i++) {
			// 뒷 4자리 이전까지는 번호 가림
			if(i<phone_number.length()-4)
				answer+="*";
			// 뒷 4자리는 실제 번호 저장
			else
				answer+=phone_number.charAt(i);
		}
        return answer;
    }
}
