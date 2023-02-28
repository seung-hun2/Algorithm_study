package programmers;

public class targetNumber {
    static int answer;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }
    void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(target == sum) answer++;
        }
        else{
            dfs(numbers,target,++depth,sum+numbers[depth]);
            dfs(numbers,target,++depth,sum-numbers[depth]);
        }
    }
}
