public class level1_41 {
	public String solution(int[] numbers, String hand) {
        String answer="";
        int prevleft=10; // *의 위치를 숫자로 표현(초기의 왼손 위치)
        int prevright=12; // #의 위치를 숫자로 표현(초기의 오른손 위치)
        
        for(int i=0;i<numbers.length;i++) {
        	int current=numbers[i]; // 누르고자 하는 키패드 번호
        	
        	// 누르고자 하는 키패드의 번호가 1,4,7번 이면 왼손으로 누른다.
        	if(current==1||current==4||current==7) {
        		answer+='L';
        		prevleft=current; // 2,5,8,0 키패드를 누르는 경우를 위해 이전에 누른 키패드 번호를 기록한다.
        	}
        	
        	// 누르고자 하는 키패드의 번호가 3,6,9번 이면 왼손으로 누른다.
        	else if(current==3||current==6||current==9) {
        		answer+='R';
        		prevright=current; // 2,5,8,0 키패드를 누르는 경우를 위해 이전에 누른 키패드 번호를 기록한다.
        	}
        	
        	/* 
        	 * 누르고자 하는 키패드의 번호가 2,5,8,0번 이면 
        	 * 오른손과 왼손이 위치하고 있는 번호판으로 부터 거리가 짧은 손으로 해당 키패드를 누른다.
        	 * 이때 두 손으로부터의 거리가 같다면 입력받은 hand 쪽의 손으로 키패드를 누른다.
        	 */
        	else if(current==2||current==5||current==8||current==0) {
        		// 누르고자 하는 키패드가 0이라면 11로 대체
        		if(current==0) 
        			current+=11;
        		
        		/*
        		 * 각 키패드의 위, 아래의 값 차이는 3이고, 양 옆의 값의 차이는 1이다.
        		 * 누르고자 하는 키패드 번호 - 왼손의 위치를 3으로 나눈 몫 + 3으로 나눈 나머지로
        		 * 손에서 키패드간의 거리를 나타낼 수 있다. 오른손도 같은 계산을 하면 거리를 구할 수 있다.
        		 */
        		int left=(Math.abs(current-prevleft))/3+(Math.abs(current-prevleft))%3;
        		int right=(Math.abs(current-prevright))/3+(Math.abs(current-prevright))%3;
        		
        		// 두 손의 거리가 같다면 hand 값에 따라 해당 손으로 키패드를 누른다.
        		if(right==left) {
        			if(hand.equals("right")) {
        				answer+='R';
        				prevright=current;
        			}
        			else {
        				answer+='L';
        				prevleft=current;
        			}
        		}
        		
        		// 왼손의 거리가 더 크다면 오른손으로 해당 키패드를 누른다.
        		else if(left>right) {
    				answer+='R';
    				prevright=current;
    			}
        		
        		// 오른손의 거리가 더 크다면 왼손으로 해당 키패드를 누른다.
        		else {
        			answer+='L';
    				prevleft=current;
        		}
        	}
        }
        return answer;
    }	
}
