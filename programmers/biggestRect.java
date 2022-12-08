package programmers;

public class biggestRect {
    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board));
    }
    public static int solution(int[][] board)
    {
        int answer = 0;
        int[][] arr = new int[board.length+1][board.length+1];
        for(int i=1;i<=board.length;i++){
            for(int j=1;j<=board.length;j++){
                if(board[i-1][j-1]!=0){
                    int min = Math.min(Math.min(arr[i-1][j],arr[i][j-1]),arr[i-1][j-1]);
                    arr[i][j] = min+1;
                    answer = Math.max(answer, min+1);
                }
            }
        }
        answer *= answer;

        return answer;
    }
}
