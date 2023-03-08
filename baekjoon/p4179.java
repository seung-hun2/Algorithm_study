package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4179 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] arr;
    static boolean[][] visited;
    static int cnt;
    static int R,C;
    static Node node;
    static Node fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new boolean[R][C];
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                if(str.charAt(j) == 'J') {
                    arr[i][j] = 1;
                    queue1.add(new Node(i,j));
                }
                if(str.charAt(j) == 'F') {
                    arr[i][j] = -2;
                    queue2.add(new Node(i,j));
                }
                if(str.charAt(j) == '#') {
                    arr[i][j] = -1;
                }
                if(str.charAt(j) == '.') {
                    arr[i][j] = 0;
                }

            }
        }

        int answer = 0;
        while(true){
            answer++;
            int fs = queue2.size();
            while(fs>0) {
                fs--;
                Node node = queue2.poll();
                int y = node.y;
                int x = node.x;
                for (int i = 0; i < 4; i++) {
                    if (x + dx[i] >= 0 && x + dx[i] < C && y + dy[i] > 0 && y + dy[i] < R) {
                        if (arr[y + dy[i]][x + dx[i]] >= 0) {
                            queue2.add(new Node(y + dy[i], x + dx[i]));
                            arr[y + dy[i]][x + dx[i]] = -2;
                        }
                    }
                }
            }
            int js = queue1.size();
            while(js>0){
                js--;
                Node node = queue1.poll();
                int y = node.y;
                int x = node.x;
                for(int i=0; i<4; i++){
                    if (x+dx[i] < 0 || x+dx[i] >= C || y+dy[i]< 0 || y+dy[i] >= R){
                        System.out.println(answer);
                        return;
                    }
                    if(arr[y+dy[i]][x+dx[i]] ==0){
                        queue1.add(new Node(y+dy[i], x+dx[i]));
                        arr[y+dy[i]][x+dx[i]] = 1;
                    }
                }
            }
            if(queue1.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }


    }//
    public static class Node{
        int x,y;
        public Node(int y,int x){
            this.x = x;
            this.y = y;
        }
    }

}
