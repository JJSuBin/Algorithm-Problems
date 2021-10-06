public class level1_29 {
	public static int solution(String dartResult) {
        int[] score=new int[3];
        int index=0;
        for(int i=0;i<dartResult.length();i++) {
        	char ch=dartResult.charAt(i);
        	int dartInt=Character.getNumericValue(ch);
        	
        	// 읽은 문자열이 숫자라면 
        	if(dartInt>=0&&dartInt<=10) {
        		// 읽은 문자의 앞자리가 1인 경우일때 10점인 경우도 체크해야 한다.
        		if(dartInt==1) {
        			if(Character.getNumericValue(dartResult.charAt(i+1))==0) {
        				dartInt=10;
        				i++; // 읽은 위치 1 증가(0 때문에)
        			}
        		}
        		
        	score[index]=dartInt; // 구한 점수를 배열에 저장
        	}
        	
        	// 읽은 문자열이 숫자가 아니라면
        	else {
        		switch(ch) {
        		// 문자 S일 경우 1제곱 처리 후 index 증가
        		case 'S':
        			score[index]=(int)Math.pow(score[index], 1);
        			index++;
        			break;
        		// 문자 D일 경우 2제곱 처리 후 index 증가
        		case 'D':
        			score[index]=(int)Math.pow(score[index], 2);
        			index++;
        			break;
        		// 문자 T일 경우 3제곱 처리 후 index 증가	
        		case 'T':
        			score[index]=(int)Math.pow(score[index], 3);
        			index++;
        			break;
        		/*
        		 * 문자 *인 경우는 스타상으로 해당 점수와 바로 전에 얻은 점수를 각각 2배씩
        		 * 이때 스타상과 아차상은 앞선 S, D, T 후에 나오기 때문에 index가 증가되어있는 상태
        		 * 따라서 index에 -1한 값에 연산을 수행해주어야 한다.
        		 */
        		case '*':
        			score[index-1]*=2;
        			if(index>1) // 첫 번째 점수가 아니라면 그 전의 점수도 2배 처리
        				score[index-2]*=2;
        			break;
        		// 문자 #인 경우는 아차상으로 해당 점수는 마이너스 처리 
        		case '#':
        			score[index-1]*=-1;
        			break;
        		}
        	}
        }
        return score[0]+score[1]+score[2];
    }
}
