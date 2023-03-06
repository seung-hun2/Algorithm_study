package programmers;

public class pushKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lh=10,rh=12;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                lh = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                rh = numbers[i];
            }
            else{
                if(numbers[i] == 0) numbers[i] = 11;
                int rdis = Math.abs(numbers[i] - rh)/3 + Math.abs(numbers[i] - rh)%3;
                int ldis = Math.abs(numbers[i] - lh)/3 + Math.abs(numbers[i] - lh)%3;
                if( ldis > rdis ){
                    answer += "R";
                    rh = numbers[i];
                }else if(rdis == ldis){
                    if(hand.equals("right")){
                        answer += "R";
                        rh = numbers[i];
                    }else{
                        answer += "L";
                        lh = numbers[i];
                    }
                }
                else{
                    answer += "L";
                    lh = numbers[i];
                }
            }
        }
        return answer;
    }
}
