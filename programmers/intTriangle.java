package programmers;

public class intTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangle));
    }
    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] arr = new int[triangle.length][triangle[triangle.length-1].length];
        arr[0][0] = triangle[0][0];

        for(int i=1;i< triangle.length;i++){
            arr[i][0] = arr[i-1][0] + triangle[i][0];
            arr[i][i] = arr[i-1][i-1] + triangle[i][i];
            for(int j=1;j<=i-1;j++){
                arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + triangle[i][j];
                answer = Math.max(answer, arr[i][j]);
            }
        }
        return answer;
    }
}
