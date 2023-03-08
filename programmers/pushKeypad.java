package programmers;

public class pushKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lh=10,rh=12;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){          // 왼손
                answer += "L";
                lh = numbers[i];                                                // 왼손 위치 저장
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){     // 오른손
                answer += "R";
                rh = numbers[i];                                                // 오른손 위치 저장
            }
            else{
                if(numbers[i] == 0) numbers[i] = 11;                            // 0을 11로 변경
                int rdis = Math.abs(numbers[i] - rh)/3 + Math.abs(numbers[i] - rh)%3;   // 오른손 위치에서 다음 숫자까지의 거리
                int ldis = Math.abs(numbers[i] - lh)/3 + Math.abs(numbers[i] - lh)%3;   // 왼손 위치에서 다음 숫자까지의 거리
                if( ldis > rdis ){
                    answer += "R";                                          // 왼손이 더 멀면 오른손 추가하고
                    rh = numbers[i];                                        // 오른손 위치 저장
                }else if(rdis == ldis){
                    if(hand.equals("right")){                               // 거리가 같다면 오른손 잡이 -> 오른손 저장
                        answer += "R";                                      // 왼손 잡이 -> 왼손 저장
                        rh = numbers[i];
                    }else{
                        answer += "L";
                        lh = numbers[i];
                    }
                }
                else{
                    answer += "L";                                          // 오른손이 더 멀면 왼손 추가하고
                    lh = numbers[i];                                        // 왼손 위치 저장
                }
            }
        }
        return answer;
    }
}
