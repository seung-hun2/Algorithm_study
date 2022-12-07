package programmers;

public class numberBlock {
    public static void main(String[] args) {
        solution(1,10);
    }
    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end-begin+1)];
        int idx=0;
        for(int i = (int)begin;i<=end;i++){
            boolean flag = false;
            if(i==1){
                answer[idx++]=0;
                continue;
            }
            // 에라토스테네스의 체
            for(int j=2;j*j<=i;j++){
                // 나누어 질 때 제일 작은 소수로 나눈 몫
                if(i%j==0 && i/j<=10000000){
                    answer[idx++] = i/j;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                answer[idx++] = 1;
            }
        }
        return answer;
    }
}
